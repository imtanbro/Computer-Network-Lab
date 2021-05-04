// package TCPHello;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),8080);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        //sending hello

        dataOutputStream.writeUTF("Hello server, I'm client");
        dataOutputStream.flush();

        //reading hello
        System.out.println(dataInputStream.readUTF());


        //closing all
        dataOutputStream.close();
        dataInputStream.close();
        socket.close();



    }
}
