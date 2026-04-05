<script>
	let numbers = $state([1, 2, 3, 4]);
	let total = $derived(numbers.reduce((t, n) => t + n, 0));

	function addNumber() {
		numbers.push(numbers.length + 1);
		console.log($state.snapshot(numbers));
	}

	$inspect(numbers).with(console.log);
</script>

<p>{numbers.join(' + ')} = ...</p>

<button onclick={addNumber}>
	Add a number
</button>