/**
 * unshift() digunakan Untuk menambahkan data di awal Array
 */

const arr = ["ujun", "Humaidi"]
arr.unshift("Abd Wahid")

console.log(arr)

arr.forEach(function(value, index){
    console.log(`${index} : ${value}`)
})

