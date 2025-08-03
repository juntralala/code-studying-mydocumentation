addEventListener("message", function(message) {

    const total = message.data

    for(let i = 0 ; i < total ; i++){
        if(i % 1000 === 0) {
            postMessage(i)
        }
    }

}) 