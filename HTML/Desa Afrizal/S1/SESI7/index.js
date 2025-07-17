const http = require('http');
const host = "127.0.0.1";
const port = 3001;

let nama = "Muhamma Junaidi";
let jajan = 5000;
let uang = 10000;
let sisa = uang-jajan ; 

const hasil = `
<head>
    <title>Muhammad Junaidi</title>
</head>
<body>
<div>
<div>halo nama saya ${nama}. Saya jajan sebanyak ${jajan}. Sebelumn6ya uang saya ${uang}. Sekarang sisanya ${sisa}</div>
<div style="height:10vh;background-color:aqua   ">NAVBAR</div>
</div>
<div style="height:10vh;background-color:aqua   ">NAVBAR</div>
    </div>
<div style="height:10vh;background-color:aqua   ">NAVBAR</div>
    </div>
</body>
`;

const server = http.createServer(function(request,response) {
    response.statusCode = 203;
    response.end(hasil);
});
 
server.listen(port, host, '', function  () {
    console.log(`server menyala di ${host} : ${port}`);
});