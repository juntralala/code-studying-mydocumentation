const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

readline.question('Masukkan nama Anda: ', (nama) => {
    console.log(`Halo, ${nama}!`);
    readline.close();
});

console.log(`Hai ${nama}`)