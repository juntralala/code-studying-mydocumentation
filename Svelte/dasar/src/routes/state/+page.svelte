<script>
    let count = $state(0);
    let numbers = $state([1]); // kalau nilainya object maka pakai proxy

    function counter() {
        count++; // mutation trigger rerender
    }

    function addNumber(num) {
        numbers.push(count); // mutation of object trigger rerender
    }
</script>

<div>
    <h1>{numbers}</h1>
    <h1>{count}</h1>
    <button onclick={counter}>Plus</button>
    <button onclick={addNumber}>Push that number</button>

</div>