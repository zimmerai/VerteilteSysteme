package Aufgabe3_ClientServer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static final int PORT = 4999;
    public static final String host = "localhost";

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            while (true) {
                Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
                System.out.print("Enter a message: ");
                String str= sc.nextLine(); //reads string
                byte[] sendMessage = str.getBytes();
                DatagramPacket packet = new DatagramPacket(sendMessage, sendMessage.length, InetAddress.getByName(host).getLoopbackAddress(), PORT);
                socket.send(packet);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}

