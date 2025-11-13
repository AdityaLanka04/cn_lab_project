import java.util.*;
import java.net.*;
import java.io.*;

public class server{
    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(9999);
            Socket s = ss.accept();
            BufferedReader b = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String msg = b.readLine();
            System.out.println("msg from client");
            String encoded = "";
            for (int i = 0; i < msg.length(); i++) {
                char c = msg.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    if (c == 'z') c = 'a';
                    else c = (char)(c + 1);
                } 
                encoded += c;
            }
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            pw.println(encoded);
        } catch (Exception e) {
        }
    }
}