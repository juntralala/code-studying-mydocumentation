<script>
  let elapsed = $state(0);
  let interval = $state(1000);

  $effect(function() {
    const id = setInterval(function() {
      elapsed++;
    }, interval);
    return () => clearInterval(id);
  });
</script>

<button onclick={() => (interval /= 2)}>speed up</button>
<button onclick={() => (interval *= 2)}>slow down</button>

<p>elapsed: {elapsed}</p>
