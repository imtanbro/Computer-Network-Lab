import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
public class DNSLookup
{
 public static void main(String args[])
 {
      Scanner sc=new Scanner(System.in);
      String arg;

      try
      {
           InetAddress inetAddress;

           System.out.println("Enter Domain name or domain address");
           arg=sc.next();
           inetAddress = InetAddress.getByName(arg);
           System.out.println(inetAddress);
           // show the Internet Address as name/address
           System.out.println(inetAddress.getHostName() + "/" +
           inetAddress.getHostAddress());
           // get the default initial Directory Context
           InitialDirContext iDirC = new InitialDirContext();
           // get the DNS records for inetAddress
           Attributes attributes = iDirC.getAttributes("dns:/" + inetAddress.getHostName());
           // get an enumeration of the attributes and print them out
           NamingEnumeration attributeEnumeration = attributes.getAll();
           System.out.println("-- DNS INFORMATION --");
           while (attributeEnumeration.hasMore())
           {
               System.out.println("" + attributeEnumeration.next());
           }
           attributeEnumeration.close();
      }
      catch (UnknownHostException exception)
      {
          System.err.println("ERROR: No Internet Address ");
      }
      catch (NamingException exception)
      {
          System.err.println("ERROR: No DNS record");
      }
 }
}
