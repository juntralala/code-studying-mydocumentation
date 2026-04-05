<script>
    let count = $state(0);
    let numbers = $state([1]); // kalau nilainya object maka pakai proxy
    let total = $derived(numbers.reduce((prev, current) => prev + current));

    function counter() {
        count++;
    }

    function addNumber(num) {
        numbers.push(count);
    }
</script>

<div>
    <h1>Total: {total}</h1>
    <h1>{numbers}</h1>
    <h1>{count}</h1>
    <button onclick={counter}>Plus</button>
    <button onclick={addNumber}>Push that number</button>

</div>