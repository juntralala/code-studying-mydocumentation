<script>
  const kondisi = false;
</script>

<div>
  {#if kondisi}
    <h1 style="color: green;">benar</h1>
  {:else if kondisi == null}
    <h1>IDK</h1>
  {:else}
    <h1 style="color: red;">salah</h1>
  {/if}
</div>
