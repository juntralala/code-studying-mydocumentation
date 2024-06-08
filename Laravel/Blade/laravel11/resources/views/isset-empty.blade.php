<html>

<body>
    <p>
        @isset($name)
            Hello my name is {{$name}}    
        @endif
    </p>

    <p>
        @empty($hobbies)
            I have no hobby
        @endif
    </p>
</body>

</html>