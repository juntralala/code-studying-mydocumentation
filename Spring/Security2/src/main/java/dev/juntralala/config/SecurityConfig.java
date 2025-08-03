package dev.juntralala.config;

import dev.juntralala.authorization.manager.OpenPolicyAgentAuthorizationManager;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
//        return new MvcRequestMatcher.Builder(introspector).servletPath("/spring-mvc"); // mengganti map path menjadi diawali `/spring-mvc`, yg defaultnya `/`
//        // alternatif di springboot, bisa menggunakan property : spring.mvc.servlet.path
//        // note: dibagian authorize tidak perlu menulis bagian prefix
//    }

    @Bean
    public LogoutHandler printLogoutHandler() {
        // Custom logout Handler
        LogoutHandler printLogoutHandler = (HttpServletRequest request, HttpServletResponse response, Authentication authentication) -> {
            // disini bisa melakukan implementasi clear data authentikasi jika mengimplementasi login sendiri
            // Note: Because LogoutHandler instances are for the purposes of cleanup, they should not throw exceptions.
            System.out.println("\\033[32mLogout: Membesihkan data authentikasi pada proses logout\\033[0m");
        };
        return printLogoutHandler;
    } // ada juga LogoutSuccessHandler (baca di dokumentasi)

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            RememberMeServices rememberMeServices,
            OpenPolicyAgentAuthorizationManager openPolicyAgentAuthorizationManager,
            @Qualifier("printLogoutHandler") LogoutHandler printLogoutHandler
    ) throws Exception {

        // custom request matcher
        RequestMatcher printview = (HttpServletRequest request) -> request.getParameter("print") != null;

        return http
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.ERROR, DispatcherType.FORWARD).permitAll()
                        .requestMatchers("/anonym", "/public/**").permitAll()
                        .requestMatchers(RegexRequestMatcher.regexMatcher("/resource/[A-Za-z0-9]+")).authenticated()
                        .requestMatchers(printview).hasAuthority("PRINT")
                        .anyRequest().authenticated()
                        /*.anyRequest().access(new WebExpressionAuthorizationManager("anu anu, tanya ai atau dokumentas"))*/
                        /*.anyRequest().access((authentication, context) -> new AuthorizationDecision(true))*/ /* <- lebih direkomendasikan dibandingkan WebExpressionAuthorizationManager*/ )
                .securityContext(securityContext -> securityContext.requireExplicitSave(true))
                .rememberMe(remember -> remember
                        .rememberMeServices(rememberMeServices))
                .sessionManagement(session -> session
                        .sessionFixation().changeSessionId())
                .formLogin(Customizer.withDefaults())
                .logout(logout -> logout
                                .invalidateHttpSession(true)
                                .logoutSuccessUrl("/anonym")
                                .logoutUrl("/logout")
                                .deleteCookies("our-custom-cookie")
                                .addLogoutHandler(printLogoutHandler)
//                        .addLogoutHandler(new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter())) // <- send header Clear-Site-Data to ask browser to clear cookie, cache and storage. But if wanna delete spesific cookie, sotrage or other you can use Directive.COOKIE in the constructor
                ).build();
    }

    @Bean
    public RememberMeServices rememberMeServices(UserDetailsService userDetailsService, PersistentTokenRepository persistentTokenRepository) {
        PersistentTokenBasedRememberMeServices rememberMe = new PersistentTokenBasedRememberMeServices(
                "AnotherSomthingThatSecret",
                userDetailsService,
                persistentTokenRepository);
        rememberMe.setTokenValiditySeconds(60 * 60 * 24 * 15); // <- 15hari
        return rememberMe;
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(DataSource dataSource) {
        JdbcTokenRepositoryImpl persistentTokenRepository = new JdbcTokenRepositoryImpl();
        persistentTokenRepository.setDataSource(dataSource);
        return persistentTokenRepository;
    }

    @Bean
    public JdbcUserDetailsManager userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

//  Detail about Security Matcher: https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html#security-matchers
