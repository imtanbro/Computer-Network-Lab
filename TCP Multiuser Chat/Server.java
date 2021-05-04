import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
     public static void main(String[] args) {
          // TODO Auto-generated method stub
          try {
               ServerSocket s=new ServerSocket(2324);
               int id=0;
               while(true)
               {
                    Socket ss=s.accept();
                    id++;
                    Clienth client=new Clienth(ss,id);
                    client.start();
               }
          } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
          }
     }
}
class Clienth extends Thread{
     int id;
     Socket client;
     public Clienth(Socket client,int id) {
          // TODO Auto-generated constructor stub
          this.client=client;
          this.id=id;
     }
     @Override
     public void run() {
          // TODO Auto-generated method stub
          try {
               DataOutputStream out=new
               DataOutputStream(client.getOutputStream());
               DataInputStream in=new DataInputStream(client.getInputStream());
               boolean running = true;
               while(running)
               {
                    String Client=in.readUTF();
                    System.out.println("Client"+client.getInetAddress().getHostName()+" ClientID:- "+id+" Message :-"+Client);
                    if(Client.equals("exit"))
                    {
                         running=false;
                    }
               }
          } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
          }
     }
}

