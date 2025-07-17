import fs from "fs/promises"
import zlib from "zlib" 

const source = await fs.readFile("compressed.txt")
const decompressed = zlib.unzipSync(source)

console.log(source.toString())
console.log(decompressed.toString())