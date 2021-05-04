// package TCPCALCI;

// Java program to illustrate Server Side Programming
// for Simple Calculator using TCP

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.StringTokenizer;


public class Calc_Server{
    static double executeFunction(String function, double number) {
        double result = 0.0;
        if (function.equalsIgnoreCase("sin"))
            result = Math.sin(number);
        else if (function.equalsIgnoreCase("cos"))
            result = Math.cos(number);
        else if (function.equalsIgnoreCase("tan"))
            result = Math.tan(number);
        else if (function.equalsIgnoreCase("asin"))
            result = Math.asin(number);
        else if (function.equalsIgnoreCase("atan"))
            result = Math.atan(number);
        else if (function.equalsIgnoreCase("acos"))
            result = Math.acos(number);
        return result;
    }

    public static void main(String[] args) throws IOException
    {

        // Step 1: Establish the socket connection.
        ServerSocket ss = new ServerSocket(4444);
        Socket s = ss.accept();

        // Step 2: Processing the request.
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        try {
            while (true)
            {
                // wait for input
                String input = dis.readUTF();

                if(input.equals("bye"))
                    break;

                System.out.println("Equation received:-" + input);
                double result;

                // Use StringTokenizer to break the equation into operand and
                // operation
                StringTokenizer st = new StringTokenizer(input);

                String trigonometricFunction = st.nextToken();
                double number = Double.parseDouble(st.nextToken());

                result =  executeFunction(trigonometricFunction,number);

                System.out.println("Sending the result...");

                // send the result back to the client.
                dos.writeUTF(Double.toString(result));
            }
        }catch (SocketException socketException){
            System.out.println("Thank you for joining us");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

