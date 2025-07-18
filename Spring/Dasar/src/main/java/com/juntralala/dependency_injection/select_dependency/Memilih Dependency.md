## Memilih Dependency
* Kadang saat menggunakan DI, kita ingin memilih object mana yang ingin kita gunakan
* Saat terdapat duplicate bean dengan tipe data yang sama, secara otomatis Spring akan memilih bean yang primary
* Namun kita juga bisa memilih secara manual jika memang kita inginkan
* Kita bisa menggunakan annotation @Qualifier(value=”namaBean”) pada parameter di method nya

> Contohnya di com.juntralala.dependency_injection.DependencyInjectionConfiguration  
> dan DependencyInjection_SelectDependencyTest 
