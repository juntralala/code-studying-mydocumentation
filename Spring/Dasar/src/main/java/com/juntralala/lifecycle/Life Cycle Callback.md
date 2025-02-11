# Life Cycle Callback
* Secara default, bean tidak bisa tahu alur hidup Spring ketika selesai membuat bean dan ketika akan menghancurkan bean
* Jika kita tertarik untuk bereaksi ketika alur hidup Spring terjadi, maka kita bisa implements interface InitializingBean dan DisposableBean
* InitializingBean digunakan jika kita ingin bereaksi ketika Spring selesai membuat bean
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/InitializingBean.html
* DisposableBean digunakan jika kita ingin bereaksi ketika Spring akan menghancurkan bean
 *https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/DisposableBean.html 
