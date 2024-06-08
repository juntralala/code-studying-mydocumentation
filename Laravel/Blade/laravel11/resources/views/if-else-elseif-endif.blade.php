<html>

<body>
    @if(count($hobbies) == 1)
        <h1>I have a hobby</h1>
    @elseif(count($hobbies) > 1)
        <h1>I have some hobbies</h1>
    @else
        <h1>I have no hobby</h1>
    @endif
</body>

</html>