// ada di NodeJS dan Bun jufa
// new URLSearchParams(FormData);
const params = new URLSearchParams({name: "ujun", hobby: "gaming"}); // <- nggak bisa pakai array sebagai value dari property objectnya
// const params = new URLSearchParams("?name=ujun&hobby=makan&hobby=ngoding");

console.log(params);

params.set("name", "ozon");
params.append("hobby", "gaming");
params.append("age", "12");

console.log(params);
console.log(params.toString()); // <- jadi string query param, tanpa dawali "?"

// mirip MultiValueMap di Java Springboot