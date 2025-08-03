import { defineConfig } from "vite"

export default defineConfig({
    build: {
        outDir: "production",
        rollupOptions: {
            input: {
                index: "index.html",
                blog: "blog.html",
                contact: "others/contact.html"
            }
        }
    },
    server: {
        port: 80
    },
    preview: {
        port: 80
    }
})