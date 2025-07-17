let passwordLength = document.getElementById("passwordLength")
let password = document.getElementById("password")
let saveButton = document.getElementById("saveButton")

function generatorPassword(len) {
    let lowerAlphabet = "abcdefghijklmnopqrstuvwxyz"
    let upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    let numeric = "0123456789"

    const data = lowerAlphabet + upperAlphabet + numeric
    let generator = ""
    for (let index=0; index<len; index++ ) {
        generator += data[~~(Math.random() * data.length)]
    }
    return generator
}

function getPassword() {
     const newPassword = generatorPassword(passwordLength.value)
    password.value = newPassword;
    setTimeout(() => {
        alert('password hasbeen generated');
    },2000)
}

const savePassword = () => {
    document.title = password.value;
    saveButton.setAttribute("href", "data:text/plain; charset=utf-8," + encodeURIComponent(`password saya : ${document.title}`))
    saveButton.setAttribute('download', 'MyPasswordGenerator.txt')
    setTimeout (() => {
        alert('password telah disimpan')
    },2000)
}