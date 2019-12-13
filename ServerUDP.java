/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ID100;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class ServerUDP {
    DatagramSocket server;
    DatagramPacket receivePacket, sendPacket;
    String receiveStr ="", sendStr="";
    byte[] receiceBuff, sendBuff;
    int buffSize;
    public ServerUDP() {
        try {
            buffSize = 1024;
            server = new DatagramSocket(1107);
            System.out.println("server opened ...");
        } catch (SocketException ex) {
            Logger.getLogger(ServerUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void listening(){
        System.out.println("listening ...");
        while(true){
            try {
                // Nhận gói tin
                receiceBuff = new byte[buffSize];
                receivePacket = new DatagramPacket(receiceBuff, receiceBuff.length);
                server.receive(receivePacket);
                
                receiveStr = new String(receivePacket.getData());
                System.out.println(receiveStr.trim());
                
                // Gửi gói tin chứa chuỗi đảo ngược
                sendStr = "requestID;15,80";
                sendBuff = sendStr.getBytes();
                
                sendPacket = new DatagramPacket(sendBuff,sendBuff.length
                        ,receivePacket.getSocketAddress());
                        
                server.send(sendPacket);
                System.out.println("done!");
                
            } catch (IOException ex) {
                Logger.getLogger(ServerUDP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
