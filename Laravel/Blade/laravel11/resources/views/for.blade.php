<html>

<body>
    <ul>
        @for($i = 0; $i < $limit; $i++)
        <li>Itekrasi ke-{{$i}}</li>
        @endfor
    </ul>
</body>

</html>