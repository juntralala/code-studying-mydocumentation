<script>
  function myAttachment(node) {
    // node = referensi ke elemen DOM (kayak ref)
    console.log(node); // <button>...</button>
    // Lifecycle: ini jalan saat element di-mount
    node.style.color = 'red';
    // Return cleanup = lifecycle saat unmount
    return () => {
      console.log('Element dihapus dari DOM');
    };
  }
</script>

<button {@attach myAttachment}>Click me</button>