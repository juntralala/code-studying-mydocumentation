let person = {
    address : {
        country : "Indnesia"
    }
}

let address = person?.address?.country
console.log(address)





// tanpa optional chaining operator
let address2 
if (person !== undefined && person !== null) {
    address2 = person.address.country
}
console.log(address2)



console.log("Akhir Program")