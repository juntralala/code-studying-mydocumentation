function outer() {
    
    function inner() {
        console.log("ini inner")
    }

    console.log("Ini outer")

    inner() // hanya bisa diakses didalam

}


//inner()    // tidak bisa diakses diluar

outer()