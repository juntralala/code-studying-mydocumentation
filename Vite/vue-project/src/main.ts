import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

// declare global {
//   interface Window {
//     myname: string
//   }
// }
// window.myname = "ujun";

declare module 'vue' {
  interface ComponentCustomProperties {
    $myname: string
  }
}
const app = createApp(App)

app.use(router)
app.config.globalProperties.$myname = "ujun";

app.mount('#app')