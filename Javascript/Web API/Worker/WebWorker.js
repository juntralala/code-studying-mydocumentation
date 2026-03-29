const worker = new Worker("./ww.js");

worker.onmessage = function(e) {
    console.log('received: ' + e.data);
};

worker.postMessage("ok bos");