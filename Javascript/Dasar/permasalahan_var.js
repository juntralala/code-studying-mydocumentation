var iVar = 100;
let iLet = 100;

for (var iVar = 0; iVar <= 10; iVar++) {
    console.log(`iVar : ${iVar}`)
}
for (let iLet = 0 ; iLet <= 10 ; iLet++) {
    console.log(`iLet : ${iLet}`)
}

console.log(`Global iVar : ${iVar}`)
console.log(`Global iLet : ${iLet}`)