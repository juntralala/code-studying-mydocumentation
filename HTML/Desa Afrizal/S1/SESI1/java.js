const nama = 'Muhammaad Junaidi' ;
let umur = 15;
let biodata = document.getElementById('biodata');

function generatebiodata() {
    let golongan;
    if (umur >9 && umur < 18 ) {
        golongan = 'Golongan Remaja';
    } else if ( umur <10 ) {
        golongan = 'Golongan Anak-anak';
    } else if (umur > 17 && umur <40 ) {
        golongan ='Golongan Dewasa';
    } else {
        golongan = 'wah kamu jenis manusia yang mana ya aku gak tau😂';
    }
    return biodata.innerHTML = golongan;
}

generatebiodata();