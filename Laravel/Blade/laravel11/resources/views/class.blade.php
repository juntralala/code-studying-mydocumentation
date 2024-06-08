<html>
<head>
    <style>
        .red {
            color: red;
        }
        .bold {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <ul>
        @foreach ($hobbies as $hobby)
        <li @class(['red', 'bold' => $hobby['love']])>{{$hobby['name']}}</li>
        @endforeach
    </ul>
</body>
</html>