function sayHello(name) {
    console.log(`Hello ${name}`)
}

let sapa = sayHello
sapa("Muhammad Junaidi")








function giveMeName(callback) {
    callback("Ujun")
}

giveMeName(sayHello)
giveMeName(sapa)

giveMeName( () => console.log("Nama Saya Muhammad Junaidi"))
