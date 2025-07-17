// from array
let names = ["UJUN", "UBUN", "Ipul", "Danu", "Udin", "Amat"]

function fungsi([nama1, nama2, nama3, ...sisaNama]) {
    console.log(nama1)
    console.log(nama2)
    console.log(nama3)
    console.log(sisaNama)
}

fungsi(names)

// from object
let orang = {
    nama : "Muhammad junaidi",
    umur : 18,
    alamat: {
        negara : "Indonesia",
        kec    : "Bumi Makmur",
        desa   : "Handil Labuan Amas"
    },
    jenkel  : "laki-laki",
    profesi : "Mahasiswa"
}

function display({nama, umur, alamat: {negara, kec, desa}, ...sisaValue}) {
    console.log(nama);
    console.log(umur);
    console.log(negara);
    console.log(kec);
    console.log(desa);
    console.log(sisaValue);
}

display(orang)
