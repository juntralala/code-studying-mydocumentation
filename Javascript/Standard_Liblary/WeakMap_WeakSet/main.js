const cache = new WeakMap();
// get dan set harus pakai reference object yg sama, atau pakai unregistered symbol
const someKey = new String("result");
cache.set(someKey, "OK");
console.log(cache.get(someKey));


const ws = new WeakSet();
const foo = {};
ws.add(foo);
console.log(ws.has(foo)); // true
ws.delete(foo); // removes foo from the set
console.log(ws.has(foo)); // false, foo has been removed