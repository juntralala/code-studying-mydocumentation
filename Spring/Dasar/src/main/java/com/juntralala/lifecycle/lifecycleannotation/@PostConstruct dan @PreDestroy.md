# @postConstruct dan @PreConstruct
* Selain menggunakan annotation @Bean, untuk menandai sebuah method adalah init method dan destroy method, kita juga bisa menggunakan annotation pada method nya secara langsung
* Ini bisa digunakan untuk menghindari kita lupa menyebutkan init dan destroy method ketika membuat @Bean
* @PostConstruct merupakan method yang ditandai harus dipanggil ketika bean selesai dibuat
* @PreDestroy merupakan method yang ditandai harus dipanggil ketika bean akan dihancurkan
* Jika sudah menggunakan annotation ini, kita tidak perlu lagi menyebutkan nya di @Bean
