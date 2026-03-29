// pakai importScripts() kalau tidak pakai module

self.addEventListener('message', function(e) {
    self.postMessage(e.data.toUpperCase());
})