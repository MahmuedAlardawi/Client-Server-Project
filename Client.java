import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/* CPCS-371
Network Group Project: Client-Server Program.
Students:-
Abdullah Abed Alharbi - 2135999
Abdullah Emad Almashharawi - 2136141
Mahmued Alardawi - 2135209
*/

public class Client {

    public static void main(String[] args) throws IOException {

        try { //catching connection and socket exceptions

            System.out.println("Checking For Connection...");       //a message to give update on current status in console
            Socket socket = new Socket("localhost", 9001);//creating a socket with the host and port of the server socket in order to connect
            //by the time the above line finished, either the program successfully connects with the server, or catches a ConnectionException
            PrintWriter sender = new PrintWriter(socket.getOutputStream(), true);//create a printWriter object that prints in the output stream, and making it auto flushes too
            BufferedReader receiver = new BufferedReader(new InputStreamReader(socket.getInputStream()));//create a bufferReader, which collects the inputStreamReader(it turns the inputStream from the socket and turns the bytes to characters)
            Scanner input = new Scanner(System.in);                                                     //, and collects it all in one go (that's what a buffer is, basically)
            //client exclusive, this is mainly for getting the input from the console

            sender.println("Client Connected Successfully!");//this will send the server-side an update
            System.out.println(receiver.readLine());//this will print the received message from the server saying its connected successfully

            String message;
            message = receiver.readLine();//a string object to hold the sent message, readline just reads the entire line that was collected in the buffer (only one line at a time)

            while (message != null) {//this will most likely never be false, but just in case

                System.out.print(message);//prints the previously received message at line 36(or 50), which prompts the client to give a character
                sender.println(input.nextLine());//this sends said character to server(actually sends a string, turning it to character is the server's job)

                System.out.print(receiver.readLine());//retrieving the new sent line from server, prompting to give a string to search.
                sender.println(input.nextLine());//sends said string to server

                System.out.println(receiver.readLine());//receive a line that has the number of occurrences that was calculated in the server

                System.out.print(receiver.readLine());//receiving the second line that mentions whether the client wants to continue (as said previously, buffer only collect one line at a time)
                sender.println(input.nextLine()); //sending the answer (same explanation in line 41)
                message = receiver.readLine(); //this message is either asking for the character to search, or a thank you message (meaning the program is done)

                if (message == null || message.equals("Thank You!"))
                    break; //if we receive the end message from server, we break the loop, otherwise we print the first prompt that we got again at line 50

            }
            System.out.println(message);//show the thank you message
            socket.close(); //close the socket, terminating the connection

        } catch (ConnectException e) {//errors for certain situations
            System.out.println("Could not find server. Make sure the server program is running before turning the client program on.\nShutting Down...");
            System.exit(1);
        } catch (SocketException e) {
            System.out.println("Lost connection to server.\nShutting Down...");
            System.exit(2);
        }
    }
}
