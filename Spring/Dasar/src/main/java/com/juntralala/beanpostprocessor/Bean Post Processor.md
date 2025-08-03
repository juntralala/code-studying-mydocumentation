# Bean Post Processor
* Bean Post Processor merupakan sebuah interface yang bisa kita gunakan untuk memodifikasi proses pembuatan bean di Application Context
* Bean Post Processor mirip seperti middleware, yang diakses sebelum bean di initialized dan setelah bean di initialized
* Karena sangat flexible, bahkan Bean Post Processor bisa memodifikasi hasil object bean
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/BeanPostProcessor.html 

> Contoh penggunaan akses bean di BeanPostProcessorTest