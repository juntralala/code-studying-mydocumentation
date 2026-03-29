import webpush from 'web-push';

const vapidkeys = {
    private: "CxuwVfAP6tD5C8RXFvB1v0u0QZ7paB6799oKVJyRFpo",
    public: "BF-quCvBd1zZoopi5FS1vlQKYsoWPWH2nHmyyD55lQPZpm2gfPQJ1kGcLLp_uxW4gBVhJQRJV91ljhvxm4jqaGg",
};

webpush.setVapidDetails(
    'mailto:ujunkeren@gmail.com',
    vapidkeys.public,
    vapidkeys.private
);

let subscriptions = [];

Bun.serve({
    port: 8080,
    routes: {
        "/": {
            GET: Bun.file("./ServiceWorker.html")
        },
        "/ServiceWorker.html": async () => new Response(await Bun.file("./ServiceWorker.html").text(), {headers: {"Content-Type": "text/html"}}),
        "/orang.json": async () => new Response(await Bun.file("./orang.json").text(), {headers: {"Content-Type": "application/json"}}),
        "/sw.js": async () => new Response(await Bun.file("./sw.js").text(), {headers: {"Content-Type": "text/javascript"}}),
        "/subscribe": {
            POST: async (req) => {
                try {
                    const subscription = await req.json();
                    subscriptions.push(subscription);
                    console.log("Subscription saved:", subscription);
                    return new Response(JSON.stringify({ success: true }), {
                        headers: { "Content-Type": "application/json" },
                    });
                } catch (error) {
                    return new Response(JSON.stringify({ error: error.message }), {
                        status: 400,
                        headers: { "Content-Type": "application/json" },
                    });
                }
            }
        },

        "/notify": {
            POST: async (req) => {
                try {
                    const { title, body, url } = await req.json().catch(() => ({}));
                    const payload = JSON.stringify({
                        title: title || "Notifikasi",
                        body: body || "Halo dari server",
                        url: url || "/",
                        // icon: "/icon.png"
                    });

                    const results = await Promise.allSettled(
                        subscriptions.map(sub =>
                            webpush.sendNotification(sub, payload).catch(err => {
                                console.error("Gagal kirim ke subscription:", err);
                                if (err.statusCode === 410) {
                                    subscriptions = subscriptions.filter(s => s !== sub);
                                }
                                return null;
                            })
                        )
                    );

                    const successCount = results.filter(r => r.status === 'fulfilled' && r.value !== null).length;
                    return new Response(JSON.stringify({ 
                        success: true, 
                        sent: successCount,
                        total: subscriptions.length 
                    }), {
                        headers: { "Content-Type": "application/json" },
                    });
                } catch (error) {
                    return new Response(JSON.stringify({ error: error.message }), {
                        status: 500,
                        headers: { "Content-Type": "application/json" },
                    });
                }
            }
        },
    }
});

console.log("Server running on http://localhost:8080");