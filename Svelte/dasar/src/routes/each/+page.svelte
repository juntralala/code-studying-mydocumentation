<script>
    const names = ['ikan', 'kucing', 'ayam'];
</script>

<div>
    {#each names as name, i (name)} <!-- '(name)' adalah cara menentukan key di svelte  -->
    <h1>{i + 1}. {name}</h1>
    {/each}
</div>