import net from "net"

const server = net.createServer(function(client) {
    console.info("Client connected")
    client.on("data", function(data){
        console.info(`Resieve data from clinet : ${data.toString()}`)
        client.write(`Halo ${data.toString()}\r\n`)
    })
})

server.listen(80, 'localhost')