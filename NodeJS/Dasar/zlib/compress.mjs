// zlib adalah standard library untuk melakukan kompresi (bukan archive) menggunakan Gzip
import fs from 'fs/promises'
import zlib from 'zlib' 

const source = await fs.readFile("resource.txt")
const compressed = zlib.gzipSync(source)

// console.log(source.toString())
// console.log(compressed.toString())

fs.writeFile('compressed.txt', compressed)