<div>
    <h1>{{ $author }}</h1>
    <br>
    <button wire:click="count" wire:confirm="Doyou sure?">Count</button> <br>
    Angka ke : <span>{{$counter}}</span>
</div>