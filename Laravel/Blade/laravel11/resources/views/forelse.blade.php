<div>
    <ul>
        @forelse($hobbies as $hobby)
            <li>{{$hobby}}</li>
        @empty
            <li>Have no hobby</li>
        @endforelse
    </ul>
</div>