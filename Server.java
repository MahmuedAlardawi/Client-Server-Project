import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/* CPCS-371
Network Group Project: Client-Server Program.
Students:-
Abdullah Abed Alharbi - 2135999
Abdullah Emad Almashharawi - 2136141
Mahmued Alardawi - 2135209
*/

public class Server {

    public static void main(String[] args) throws IOException {

        try {//catching socket exception


            ServerSocket server = new ServerSocket(9001);//creating a server socket with a specified port
            System.out.println("Checking For Connection...");//a message to give update on current status in console
            Socket socket = server.accept();//the accept method waits for a client to connect, once found, it creates a socket, forming the connection

            PrintWriter sender = new PrintWriter(socket.getOutputStream(), true);//create a printWriter object that prints in the output stream, and making it auto flushes too
            BufferedReader receiver = new BufferedReader(new InputStreamReader(socket.getInputStream()));//create a bufferReader, which collects the inputStreamReader(it turns the inputStream from the socket and turns the bytes to characters)
                                                                                                        //, and collects it all in one go (that's what a buffer is, basically)
            sender.println("Connected to Server Successfully!");//this will send the client-side an update
            System.out.println(receiver.readLine());//this will print the received message from the client saying its connected successfully

            sender.println("Enter a Character to be searched: ");//sends the first prompt to client
            String message;

            while ((message = receiver.readLine()) != null) {//receiving a message from client

                char character = Character.toUpperCase(message.charAt(0));//turning it into an uppercase character
                System.out.println("Client chose '" + character + "' to be searched.");//giving update in the console

                sender.println("Enter a String: ");//send the second prompt
                message = receiver.readLine();//retrieve the string from client

                System.out.println("Client's String is \"" + message + "\".");//giving update to console
                sender.println("The number of Occurrences are: " + counter(message.toUpperCase(), character));//sending the number of occurrences to client
                        //note:in the print above, you can see we called a method. counter, to count, check line 66 for more info
                sender.println("Want to repeat (Y/N): ");//sending the repeat prompt
                message = receiver.readLine();//retrieving the repeat answer from client
                if (message == null || Character.toLowerCase(message.charAt(0)) == 'n')
                    break;//if it starts with N/n, break the loop

                System.out.println("Client chose to continue.");//otherwise, give the update
                sender.println("Enter a Character to be searched: ");//and send the first prompt again
            }

            sender.println("Thank You!");//if the client wants to stop, send thank you message
            socket.close();//close the socket, terminating the connection
            System.out.println("Client chose to stop.");//giving update to console
        } catch (SocketException e) {//catching error
            System.out.println("Client lost connection.\nShutting Down...");
            System.exit(2);
        }
    }

    public static int counter(String str, char target) {//simple character counter in a string, case-sensitive
        int count = 0;//however, in we sent in the already uppercase character, and upper-cased the retrieved string in line 46
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
            }
        }
        return count;
    }
}
