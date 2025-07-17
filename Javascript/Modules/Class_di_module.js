/**
 * Selain function dan juga variable, di module kita juga bisa menambahkan class 
 * Secara default, class tersebut hanya bisa diakses dari dalam module nya saja, tidak bisa diluar module
 * Jika kita ingin mengekspos class yang kita buat, kita juga bisa menambahkan kata kunci export diawal 
   deklarasi class nya
*/

export class Orang {
    /**
     * @param {string} name 
     */
    constructor(name){
        this.name = name
    }
}