import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;
public class Server {
     public static void main(String[] args) {
          // TODO Auto-generated method stub
          Scanner sc=new Scanner(System.in);
          try {
               DatagramSocket ss=new DatagramSocket(2322);
               byte rec[]=new byte[512];
               byte send[]=new byte[512];
               System.out.println("Waiting for client to send message:-");
               while(true)
               {
                    DatagramPacket d=new DatagramPacket(rec,rec.length);
                    ss.receive(d);
                    String cmsg=new String(d.getData(), 0, d.getLength());
                    System.out.println(cmsg);
                    if(cmsg.equals("exit"))
                    {
                         ss.close();
                         sc.close();
                         System.exit(0);
                    }
               }
          } catch (SocketException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
          } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
          }
     }
}

