package Aufgabe3_ClientServer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static final int PORT = 4999;

    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(PORT);
            while (true) {
                byte[] buffer = new byte[65507];
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                server.receive(dp);
                String msg = new String(dp.getData(), 0, dp.getLength());
                System.out.println(msg);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
