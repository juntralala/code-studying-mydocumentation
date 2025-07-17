/**
 * NodeJS juga memiliki standard library untuk HTTP
 * Salah satu fitur di module HTTP adalah HTTP Client, dimana kita bisa melakukan simulasi HTTP Request menggunakan NodeJS
 * Terdapat 2 jenis module HTTP di NodeJS, HTTP dan HTTPS
 * https://nodejs.org/dist/latest-v16.x/docs/api/http.html
 * https://nodejs.org/dist/latest-v16.x/docs/api/https.html
 */

import https from 'http'

// const url = "https://discord.com/api/webhooks/1248793056313081908/28vFg7Qik6YbZhc73ATWn2IUhR8e-C1z6AQJTQoLbV3ssIzXAD_l1H342Jf_KK6dfgxy"
const url = "http://127.0.0.1:80/api/users/register"

let request = https.request(url, {
    method: "POST",
    headers: {
        "Content-Type": "application/json",
        "Accept": "application/json"
    }
})

const body = JSON.stringify({
    username: "juntralala",
    password: "Admin#1234",
    name: "ujun"
})

request.write(body)