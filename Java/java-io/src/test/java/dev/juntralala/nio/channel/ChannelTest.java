package dev.juntralala.nio.channel;

import java.io.IOException;
import java.nio.channels.Channel;

/*
Channel mirip seperti stream di java.io tapi ada bedanya:
1. bisa read dan write, beda sama stream yg satu arah
2. Channel bisa async (file tidak bisa io async, hanya socket (tcp/udp) saja)
3. Channel hanya read dari buffer dan hanya write dari buffer (artinya kalau kita ambil dari buffer, dan write masukin dulu ke buffer baru kita masukin ke channel)

class implementasi:
    FileChannel
    DatagramChannel
    SocketChannel
    ServerSocketChannel

    ByteChannel
    ReadableByteChannel
    WritableByteChannel
 */
public class ChannelTest {
    /**
     * Interface Channel nggak ngebikin contract read karna ada beberapa channel yg cuman bisa read atau cuman bisa write
     */
    class MyChannel implements Channel {
        @Override
        public boolean isOpen() {
            return false;
        }
        @Override
        public void close() throws IOException {
        }
    }

}
