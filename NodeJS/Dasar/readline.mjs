import readline from 'readline/promises'
import process from 'process'

const input = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

let nama = await input.question("Siapa Nama Kamu? ")
input.close()
console.info(`Halo ${nama}`)
