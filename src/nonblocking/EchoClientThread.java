package nonblocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

//via https://www.developer.com/java/data/what-is-non-blocking-socket-programming-in-java/
public class EchoClientThread extends Thread {
    private ByteBuffer buffer;
    private String[] input;
    private static final String HOST = "localhost";
    private static final int PORT = 19001;

    public EchoClientThread(String[] input) {
        this.input = input;
    }

    public void run() {
        try (SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT))){
            buffer = ByteBuffer.allocate(256);
            if (input != null) {
                Arrays.stream(input).forEach(msg -> {
                            buffer = ByteBuffer.wrap(msg.getBytes());
                            try {
                                socketChannel.write(buffer);
                                buffer.clear();
                                socketChannel.read(buffer);
                                String response = new String(buffer.array()).trim();
                                System.out.println("response: " + response);
                                buffer.clear();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
