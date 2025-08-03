/*
- debugger digunkan untuk melakukan debugging
- debugger bukan berasal dari javascript melainkan browser 
- debugging adalah proses mencari masalah(bug) yang biasa terjadi dalam program
- dengan debugger kita bisa menghentikan kode jalan program di posisi yang kita
  inginkan(breakpoint), lalu melihat isi variable yang ada pada saat kode
  program berhenti 
*/

function createFullName(firstName, middleName, LastName) {
    debugger;
    let fullName = `${firstName} ${middleName} ${middleName}`
    return fullName
}

let fullName = createFullName("Eko", "Kurniawan", "Khannedy")
debugger
console.log(fullName)
