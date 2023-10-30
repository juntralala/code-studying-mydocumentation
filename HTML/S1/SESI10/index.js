const myName = 'Muhammad junaidi'
let myAdress = 'Cindai Alus 1 Pasar Papan'
let i = 0 

function getDetailHuman(data1,data2) {
    i += 1 ;
    if (i>5) {
        console.log('lebih dari 5x di klik')
    } else {
    console.log(`masih ada jatah` )
    }
}

const getDetailHuman2 = () => {
    i+=1
    i>5 ? console.log('lebih dari 5x bro human2') :console.log("jatah masih ada human2") 
}

const mahasiswa = [{
        name : 'Muhammad Junaidi',
        alamat : 'Handil rantau',
        usia : '18',
        pekerjaan : 'mahasiswa'
    },
    {
        name : 'Humaidi',
        alamat : 'Handil rantau',
        usia : '24',
        pekerjaan : 'Ahli Psikolog'
    }
]

const getDetailData = () => {
    // mahasiswa.map(function (result, i) {
    //     console.table(mahasiswa)

    // })

    mahasiswa.forEach(result => {
        console.table(result)
    })
}

class Hewan {
    warna
    keahlian
    constructor(nama) {
        this.nama = nama
    }

    set newColor(color) {
        this.warna = color
    }
    set newKeahlian(skill) {
        this.keahlian = skill
    }

    get detail() {
        return `Hi saya ${this.nama}, saya berwarna ${this.warna }, dan keahlian saya ${this.keahlian}`
    }

}

const kucing = new Hewan('Urik')
kucing.newColor = 'Black'
kucing.newKeahlian = 'Berak'
console.log(kucing.detail)