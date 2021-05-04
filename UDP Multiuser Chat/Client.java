import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Client {
     public static void main(String[] args) {
          System.out.println("Enter Your Name:-");
          // TODO Auto-generated method stub
          Scanner sc=new Scanner(System.in);
          String name=sc.nextLine();
          String nsay="Client "+name+" Says:-";
          try {
               DatagramSocket ss=new DatagramSocket();
               byte rec[]=new byte[512];
               byte send[]=new byte[512];
               InetAddress ina=InetAddress.getByName("127.0.0.1");
               while(true)
               {
                    System.out.println("Enter Message:-");
                    String cmsg=sc.nextLine();
                    String nmsg=nsay.concat(cmsg);
                    send=nmsg.getBytes();
                    DatagramPacket d=new DatagramPacket(send,
                    send.length,ina,2322);
                    ss.send(d);
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
          } catch (UnknownHostException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
          } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
          }
     }
}
