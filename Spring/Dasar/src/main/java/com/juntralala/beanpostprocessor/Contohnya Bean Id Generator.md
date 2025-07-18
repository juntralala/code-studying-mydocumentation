# Bean Id Generator
* Misal sekarang kita akan coba membuat id unique untuk bean
* Dimana kita akan membuat sebuah interface bernama IdAware, lalu memiliki method setId(String)
* Kita akan membuat Bean Post Processor, dimana jika bean nya implements IdAware, kita akan setId(String) nya menggunakan UUID
