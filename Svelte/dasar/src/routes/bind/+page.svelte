<script>
	let name = $state('world');
</script>

<div>
    <input bind:value={name} />
    <h1>Hello {name}!</h1>
</div>
