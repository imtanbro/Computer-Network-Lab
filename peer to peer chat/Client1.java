import java.io.*;  
import java.util.*;
import java.net.*;

public class Client1 {

	public static void main(String args[]) throws Exception{  
		Socket s=new Socket("localhost",3333);  // creating socket and sending request to server
		System.out.println("Connected"); 
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());     
		Scanner scanner = new Scanner(System.in);
		

		while(true){
			System.out.println("Enter your msg : ");
			String cmsg = scanner.nextLine();
			dout.writeUTF(cmsg);

			if(cmsg.equals("stop")){
				System.out.println("Stopping....");
				din.close();
				dout.close();
				scanner.close();
				s.close();
				System.exit(0);
			} 
			String smsg = din.readUTF();
			System.out.println("Server : " + smsg);

			if(smsg.equals("stop")){
				System.out.println("Stopping....");
				din.close();
				dout.close();
				scanner.close();
				s.close();
				System.exit(0);
			} 
		}
	}
}
