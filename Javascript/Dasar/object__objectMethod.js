function katakanHalo(nama) {
    console.log(`halo ${nama}`)
} 

const orang = {
    nama : "Muhammad Junaidi",
    perekenalan : function() { console.log(`Nama saya ${this.nama}`); },
    sapa : (nama) => console.log(`Hai ${nama}`),
    halo : katakanHalo
}


console.log(orang.nama)
orang.perekenalan()
orang.sapa("Danu")
orang.halo("Jamal")