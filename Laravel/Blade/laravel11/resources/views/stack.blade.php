<html>

<body>

@push('script')
    <script src="first.js"></script>
@endpush

@push('script')
    <script src="second.js"></script>
@endpush

@prepend('script')
    <script src="third.js"></script>
@endprepend

@stack('script')

</body>

</html>