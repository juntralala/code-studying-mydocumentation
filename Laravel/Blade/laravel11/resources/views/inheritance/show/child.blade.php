@extends('inheritance.show.parent')

@section('title')
Inheritance Template
@endsection

@section('header')
    @parent
    <h1>Deskripsi header</h1>
@endsection

@section('content')
    <h1>Ini adalah halaman utama</h1>
@endsection