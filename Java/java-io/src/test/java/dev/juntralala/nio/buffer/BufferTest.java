package dev.juntralala.nio.buffer;

/*
buffer untuk channel (baca ChannelTest buat lebih jelas)

implementasi:
    ByteBuffer
    ShortBuffer
    IntBuffer
    LongBuffer
    CharBuffer
    MappedByteBuffer

method:
flip() -> literally: pindah limit ke position saat ini dan position ke 0
clear() -> literally: pindah limit ke capacity dan position ke 0 serta hapus mark
rewind() -> literally: pindah position ke 0 dan limit nggak berpindah -> biasanya untuk read ulang data dari buffer

compact()

mark()
reset() // <- position pindah ke mark
*/

public class BufferTest {

}
