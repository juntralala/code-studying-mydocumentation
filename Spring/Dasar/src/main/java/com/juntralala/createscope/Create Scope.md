# Create Scope
* Jika scope yang disediakan oleh Spring tidak bisa memenuhi kebutuhan kita, kita juga bisa membuat scope sendiri
* Caranya dengan membuat class yang implement interface Scope
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/Scope.html 
* Selanjutnya untuk meregistrasikannya, kita bisa membuat bean CustomScopeConfigurer
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/CustomScopeConfigurer.html 
