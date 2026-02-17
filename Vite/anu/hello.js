import { bye } from "./bye.ts";
import dataJson from "./package.json";
import gambar from "./../../../../../../home/ujun/Downloads/gambar/gakboleh.jpeg"; // <- hasilnya string

// js biasa
// export function hello() {
//     const p = document.createElement("p");
//     p.textContent = "Hello";
//     document.body.appendChild(p);
//}

// react
// import ReactDOM from 'react-dom/client';
// export function hello() {
//     const root = ReactDOM.createRoot(document.body);
//     root.render(<p>Hello dunia Mantap</p>);
// }
// hello();

// vue
import { createApp, h } from 'vue';
const app = createApp({
    render() {
        return [
            h('p', 'Hello dunia'),
            h('p', bye()),
            h('p', JSON.stringify(dataJson)),
            h('p', gambar),
            h('p', import.meta.url),
        ];
    }
});
app.mount('#app');