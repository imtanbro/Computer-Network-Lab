import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        InetAddress localhost = InetAddress.getLocalHost();

        //sending
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            String message = "Hello I'm Client" ;
            byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
            DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length,localhost,8081);
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //reading
        try {
            DatagramSocket datagramSocket = new DatagramSocket(8080);
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length,localhost,8080);
            datagramSocket.receive(datagramPacket);
            String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
