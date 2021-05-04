// package TCPHello;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        Socket socket =  serverSocket.accept();

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        //reading hello
        System.out.println(dataInputStream.readUTF());

        //sending hello
        dataOutputStream.writeUTF("Hello client, I'm server");
        dataOutputStream.flush();

        //closing all
        dataOutputStream.close();
        dataInputStream.close();
        socket.close();
        serverSocket.close();

    }
}
