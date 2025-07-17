import net from "net"

const client = net.createConnection({port:80, host:'localhost'})

setInterval(function(){
    client.write("ujun\r\n")
}, 2000)

client.addListener('data', function(data){
    console.info(`Resieve data from server : ${data.toString()}`)
})