<script>
  const success = true;

  const nilai = new Promise(function (resolve, reject) {
    setTimeout(() => {
      if (success) {
        resolve("Nice");
      } else {
        reject("Waduh");
      }
    }, 2_000);
  });
</script>

<div>
  <h1>
    {#await nilai}
      Loading...
    {:then nilaiValue}
      diterima: {nilaiValue}
    {:catch error}
      Error: {error}
    {/await}
  </h1>
</div>
