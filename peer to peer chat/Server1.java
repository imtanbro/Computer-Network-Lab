import java.net.*;
import java.io.*;  
import java.util.*;


public class Server1 {
	public static void main(String args[]) throws Exception{  
		ServerSocket ss = new ServerSocket(3333);
		System.out.println("Waiting for connection..."); 
		Socket s = ss.accept();  
		DataInputStream din = new DataInputStream(s.getInputStream());  
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());  
		Scanner scanner = new Scanner(System.in);

		while(true){
			
			String cmsg = din.readUTF();
			System.out.println("Client : " + cmsg);

			if(cmsg.equals("stop")){
				System.out.println("Stopping....");
				din.close();
				dout.close();
				scanner.close();
				s.close();
				System.exit(0);
			} 
			System.out.println("Enter your msg : ");
			String smsg = scanner.nextLine();
			dout.writeUTF(smsg);

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
	


