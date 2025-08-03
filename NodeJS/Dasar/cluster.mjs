import cluster from "cluster"
import os from "os"
import http from "http"

if(cluster.isPrimary){
    // jalankan worker
    console.info(`primary : ${process.pid}`)
    for(let i = 0 ; i < os.cpus().length ; i++){
        cluster.fork()
    }
    cluster.addListener('exit', function(worker){
        console.info(`Worker-${worker.id} is exit`)
        cluster.fork()
    })
}

if(cluster.isWorker){
    console.info(`worker : ${process.pid}`)
    const server = http.createServer(function(request, response){
        response.write(`Response from process ${process.pid}`)
        response.end()
        process.exit()
    })
    server.listen(80)
    console.info(`Start cluster worker ${process.pid}`)
}