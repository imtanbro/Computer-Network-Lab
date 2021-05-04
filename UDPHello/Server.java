import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class Server {

    public static void main(String[] args) throws Exception {
        InetAddress localhost = InetAddress.getLocalHost();

        //reading
        try {
            DatagramSocket datagramSocket = new DatagramSocket(8081);
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length,localhost,8081);
            datagramSocket.receive(datagramPacket);
            System.out.println("Connected to : " + datagramPacket.getAddress());
            String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //sending
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            String message = "Hello, I'm Server";
            byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
            DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length,localhost,8080);
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

