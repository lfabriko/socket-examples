package nonblocking;

//via https://www.developer.com/java/data/what-is-non-blocking-socket-programming-in-java/
public class MainClients {
    public static void main(String[] args) {
        new EchoClientThread(new String[]{"aa", "bb", "cc"}).start();
        new EchoClientThread(new String[]{"10", "20", "30"}).start();

        // nok on openjdk17
        //Executors.newCachedThreadPool().submit(new EchoClientThread(new String[]{"aa", "bb", "cc"}), new EchoClientThread(new String[]{"10", "20", "30"}));
    }
}
