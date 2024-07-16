@extends('layout')

@section('title')
Validation
@endsection

@section('body')
@if($errors->any)
    <ul>
        @foreach ($errors->all() as $error)
            <li>{{$error}}</li>
        @endforeach
    </ul>
@endif

<form action="" method="post">
    @csrf 
    <label for="username">Username: @error('username'){{$message}}@enderror<input type="text" name="username" value="{{old('username')}}"></label> <br>
    <label for="password">Password: @error('password'){{$message}}@enderror<input type="text" name="password" value="{{old('password')}}"></label> <br>
    <input type="submit" name="login" value="Login">
</form>
@endsection