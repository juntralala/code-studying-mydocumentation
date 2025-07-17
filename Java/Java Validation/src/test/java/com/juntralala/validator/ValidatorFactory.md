# ValidatorFactory
* Validator merupakan sebuah Interface, untuk membuatnya kita butuh bantuan object ValidatorFactory
* ValidatorFactory merupakan sebuah interface yang digunakan untuk membuat object-object yang ada di Bean Validation
* Salah satu method nya adalah getValidator(), yang digunakan untuk mendapatkan object Validator
* ValidatorFactory cukup dibuat sekali di setiap aplikasi, karena object ini merupakan object yang berat, dan untuk membuatnya kita bisa menggunakan class Validation dan method buildDefaultValidatorFactory()
