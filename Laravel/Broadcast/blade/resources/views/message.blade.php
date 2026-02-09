<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Broadcast</title>
    @vite(['resources/css/app.css', 'resources/js/app.js'])
</head>
<body>
    <h1>hello</h1>
    <script type="module">
        window.Echo.channel('message')
            .listen('.message', e => alert(`message: ${e.message}`));
    </script>
</body>
</html>