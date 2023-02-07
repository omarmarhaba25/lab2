import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket welcomeSocket = new ServerSocket(6789);

            while (true) {
                //accept the connection
                Socket connectionSocket = welcomeSocket.accept();

                BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(
                        connectionSocket.getInputStream() ) );

                DataOutputStream outputStream = new DataOutputStream( connectionSocket.getOutputStream() );


                //receive the message
                String receivedSentence = bufferedReader.readLine();

                System.out.println(receivedSentence);

                //send the reply message
                String sendingSentence = "Hello back from server.";

                outputStream.writeBytes(sendingSentence + "\n");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
