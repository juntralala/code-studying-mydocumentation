<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form POST</title>
</head>

<body>
    <form action="" method="post">
        <input type="hidden" name="_token" value="{{csrf_token()}}">
        <label for="username">
            <span>Name : </span>
            <input type="text" name="username">
        </label>
        <input type="submit" value="Kirim" name="kirim">
    </form>
</body>

</html>