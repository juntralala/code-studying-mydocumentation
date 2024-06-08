<html>

<body>
    @php
        class Orang
        {
            public string $name;
            public string $alamat;
        }

        $orang = new Orang();
        $orang->name = "ujun";
        $orang->alamat = "Indonesia"; 
    @endphp

    <p>{{$orang->name}}</p>
    <p>{{$orang->alamat}}</p>

</body>

</html>