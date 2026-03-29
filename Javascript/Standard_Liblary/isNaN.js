/*
== dan === tidak bisa untuk perbandingan NaN
*/
const number = NaN;

console.log(number != NaN); // true
console.log(number !== NaN); // true
console.log(!isNaN(number)); // false