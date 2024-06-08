<html>

<body>
    @unless($isAdmin)
        <h1>You are not an admin</h1>
    @else
        <h1>You are an admin</h1>
    @endunless
</body>

</html>