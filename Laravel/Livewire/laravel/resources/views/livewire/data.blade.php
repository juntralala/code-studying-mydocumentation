<div>
    <h1>Kamu berhasil mengakses ID</h1>
    <br>
    <p>Id yang diakses: {{$id}}</p>
    <br>
    <p>Data : {{ $data }}</p>

    @script
    <script>
        setInterval(function(){
            $wire.$refresh();
        }, 10_000);
    </script>
    @endscript
</div>