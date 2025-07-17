/** Worker
 * Untuk menggunakan Web Worker API, kita bisa membuat object Worker
 * https://developer.mozilla.org/en-US/Web/API/Worker
 * Saat kita membuat object Worker, Worker tidak akan secara otomatis berjalan, melainkan kita perlu
   memberi perintah dengan cara mengirim pesan
 * Untuk mengirim pesan kita bisa menggunakan method postMessage()
 * Sedangkan untuk menerima pesan balasan dari Worker, kita bisa menggunakan event listener onmessage
 * Data yang diterima adalah object MessageEvent
 * https://developer.mozilla.org/en-US/Web/API/MessageEvent
 */