# Event Listener
* Spring memiliki fitur Event Listener yang bisa kita gunakan untuk komunikasi antar class menggunakan Event
* Event di Spring merupakan object turunan dari ApplicationEvent, sedangkan Listener di Spring merupakan turunan dari ApplicationListener
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationEvent.html 
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationListener.html 

> contoh penggunaanya di EventListenerTest

> Dengan membuat class turunan dari ApplicationListener adalah cara pertama
> cara lainnya ada lah menggunakan annotasi @EventListener