import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/Home.vue';
import Oke from '@/Oke.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "Home",
      component: Home
    },
    {
      path: "/oke",
      name: "Oke",
      component: Oke
    }
  ],
})

export default router
