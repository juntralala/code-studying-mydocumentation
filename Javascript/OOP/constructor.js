/**
 * Karena bentuk contructor function mirip dengan function, jadi kita bisa menambah parameter pada
   contructor function, lantas bagaimana degan class?
 * Di class kita juga bisa menmabhakan contructor, dimana dengan contructor, kita juga bisa menambahkan
   parameter saat pertama kali membuat object nya
 * Untuk membuat contructor di class, kita bisa menggunakan katakunci constructor() 
 */

class Person {
    constructor(name){
        this.name = name
    }

}

const ujun = new Person("ujun")
console.log(ujun)