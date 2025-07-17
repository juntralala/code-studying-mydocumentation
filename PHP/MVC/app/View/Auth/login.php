<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <form action="/login" method="post">
        <label for="username">Username: 
            <input type="text" name="username" id="username">
        </label><br>
        <label for="password">Password: 
            <input type="text" name="password" id="password">
        </label><br>
        <button type="submit">Login</button>
    </form>
</body>
</html>