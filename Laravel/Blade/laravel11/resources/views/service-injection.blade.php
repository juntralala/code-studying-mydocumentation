<html>
<body>
@inject('service', 'App\Services\SayHello')
<h1>{{$service->hello($name)}}</h1>
</body>
</html>