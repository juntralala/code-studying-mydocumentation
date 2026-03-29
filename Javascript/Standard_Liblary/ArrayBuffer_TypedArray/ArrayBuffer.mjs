/*
ArrayBuffer adalah block pisik pada memori (RAM) (alamat memori tidak terekspose ke js, hanya kode hanya native interpreter)
dan data pada ArrayBuffer tidak bisa diakses kecuali dengan TypedArray seperti Uint8Array, Int16Array dan lainnya
*/

const someFile = new Blob(["hello whats upp guys"], {type: 'text/plain'});
const buffer = await someFile.arrayBuffer();

// ======= TypedArray =============
const bytes = new Uint8Array(buffer);
console.log(bytes);
console.log(bytes[1]); // ambil data
bytes[1] = 75;          // write data

const teks = String.fromCharCode(...bytes); // jadikan string
console.log(teks);

console.log(new Uint32Array(buffer)); // <- menggabung 4 byte jadi 1 menjadi 32bit
console.log(`jumlah angka 8bit: ${bytes.length} - jumlah angka 32bit: ${new Uint32Array(buffer).length}`);

/* diatas adalah contohnya
TypedArray adalah class hidded, tidak terekspos ke js.
jenis TypedArray:
Int8Array
Int16Array
Int32Array

Uint8Array
Uint16Array
Uint32Array

BigInt64Array
BigUint64Array

Float16Array
Float32Array
Float64Array
*/
