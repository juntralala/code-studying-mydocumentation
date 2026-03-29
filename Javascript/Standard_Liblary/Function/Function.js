// 
function printThis(a) {
    console.log(this);
}
printThis() // <- this adalah global object atau context, kalau di browser object window

const orang = {name: "ujun", printThis};
orang.printThis(); // this adalah object sebelah kiri, saat pemanggilan function

// manual binding this
const bindedPrintThis = printThis.bind({name: "ozon"}); // return function baru
bindedPrintThis()

const person = {name: "danu"};
printThis.call(person); // argumen pertama call() menjadi this
printThis.apply(person);

console.log(printThis.name); // string identifier function
console.log(printThis.toString()); // string identifier dan body function

