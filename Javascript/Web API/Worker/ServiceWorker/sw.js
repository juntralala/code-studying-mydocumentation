self.addEventListener('message', function (e) {
  e.source.postMessage(e.data.toUpperCase());
});

self.addEventListener('install', event => {
  event.waitUntil(
    caches.open('v1').then(cache => {
      return cache.addAll(['./ServiceWorker.html']);
    })
  );
});

self.addEventListener('fetch', event => { // intercept fetch
  event.respondWith(
    caches.match(event.request).then(response => {
      return response || fetch(event.request);
    })
  );
});

self.addEventListener('push', async function (event) {
  let data = { title: "Pesan baru", body: "Pesan default" };
  try {
    data = await event.data.json();
  } catch {
    data.body = await data.text();
  }

  const options = {
    body: data.body,
    vibrate: [200, 100, 200],
    data: {
      url: data.url || '/'
    }
  };

  event.waitUntil(
    self.registration.showNotification(data.title, options)
  );
});

self.addEventListener('notificationclick', function(event) {
  event.notification.close();
  const urlToOpen = event.notification.data.url || '/';
  event.waitUntil(
    clients.openWindow(urlToOpen)
  );
});