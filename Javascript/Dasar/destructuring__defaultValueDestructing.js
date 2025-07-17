// array
let names = ["Ujun", "Barizi"]

let [nama1, nama2, nama3 = "Akbar", nama4 = "Wahyu"] = names
console.log(nama1)
console.log(nama2)
console.log(nama3)
console.log(nama4)

console.log("")

// object
let orang = {
    firstName : "Muhammad",
    lastName  : "Junaidi",
}

let {firstName, lastName, fullName= "Muhammad Junaidi", umur= 0} = orang
console.log(firstName)
console.log(lastName)
console.log(fullName)
console.log(umur)