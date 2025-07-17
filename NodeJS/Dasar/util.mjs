import util from 'util'

const orang = {name: "ujun", age: 20}
console.log(`Name : ${orang.name} with age ${orang.age}`)
console.log(util.format("Name : %s with age %i", orang.name, orang.age))

console.log(`JSON : ${JSON.stringify(orang)}`)
console.log(util.format(`JSON : %j`, orang))

util.promisify()
