<html>
    <body>
        @includeWhen($user['owner'], 'admin.header')
        <p>Selamat datang {{$user['name']}}</p>
    </body>
</html>