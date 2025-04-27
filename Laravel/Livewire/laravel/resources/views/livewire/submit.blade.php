<div>
    <div>Title : <span>{{$title}}</span></div>
    <form wire:submit="setTitle">
        <input type="text" id="title" wire:model="title">
        <button type="submit">Submit</button>
    </form>
</div>
