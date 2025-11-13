import java.io.*;
import java.net.*;

public class main {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 9999);

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter message: ");
            String msg = input.readLine();

            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            pw.println(msg);

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String encoded = br.readLine();

            System.out.println("Message from Server: " + encoded);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
