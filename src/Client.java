import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 6789);
            DataOutputStream outToServer = new DataOutputStream( clientSocket.getOutputStream() );
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(
                    clientSocket.getInputStream() ) );

            //send
            String sendingSentence = "Hello from client";
            outToServer.writeBytes(sendingSentence + "\n");

            //receive the reply
            String receivedSentence = bufferedReader.readLine();
            System.out.println(receivedSentence);


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
