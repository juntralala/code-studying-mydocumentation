# Life Cycle Annotation
* Selain menggunakan interface InitializingBean dan DisposableBean, kita juga bisa menggunakan annotation untuk mendaftarkan callback method untuk lifecycle
* Pada annotation @Bean, terdapat method initMethod() dan destoyMethod()
* initMethod() digunakan untuk meregistrasikan method yang akan dipanggil ketika bean selesai dibuat
* destroyMethod() digunakan untuk meregistrasikan method yang akan dipanggil ketika bean akan dihancurkan
* Methodnya harus tanpa parameter, dan return value nya tidak akan dipedulikan, jadi sebaiknya gunakan void saja
