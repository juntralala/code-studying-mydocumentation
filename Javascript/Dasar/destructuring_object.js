let orang = {
    nama : "Muhammad Junaidi",
    umur : 18,
    perkerjaan : "Mahasiswa",
    jenkel: "Lak-laki",
    alamat : {
        negara : "Indonesi",
        kec    : "Bumi Makmur",
        desa   : "Handil Lahuan Amas"
    }
}

{
    let {nama, umur} = orang    // harus seusai dengan nama propertynya
    console.log(nama)
    console.log(umur)
}

console.log()

{
    let {nama, umur, ...sisanya} = orang        // pakai spread syntax
    console.log(nama)
    console.log(umur)
    console.log(sisanya)
}

{ // nested object
    let {nama, umur, perkerjaan, jenkel, alamat: {negara, kec, desa}} = orang
    console.log(nama)
    console.log(umur)
    console.log(perkerjaan)
    console.log(jenkel)
    console.log(negara)
    console.log(kec)
    console.log(desa)
}
