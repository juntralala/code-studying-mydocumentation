/** RegExp Instance Method
    +=======================+===========================================================================+
    | Instance Method       | Keterangan                                                                |
    +-----------------------+---------------------------------------------------------------------------+
    | exec(value): result   | Eksekusi regex, jika menemukan data sesuai pola, maka akan kembalikan     |
    |                       |  resultnya, jika tidak maka null                                          |
    | test(value): boolean  | Eksekusi Regex, jika menemukan data sesuai pola, maka akan return true,   |
    |                       |  jika tidak maka false                                                    |
    +=======================+===========================================================================+
*/

const name = "ujun Muhammad ujun Junaidi"
const regex = /ujun/

const result = regex.exec(name)  // return null jika tidak ditemukan
console.log(result)
console.log("typeof result : ", typeof result)

const isExist = regex.test(name) // return true atau false
console.log("isExist : ", isExist)