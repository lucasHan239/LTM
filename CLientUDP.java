/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ID100;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author My PC
 */
public class CLientUDP {
    DatagramSocket Client;
    DatagramPacket sendPacket, receivePacket;
    byte[] sendData, receiveData;
    int DataSize;
    public CLientUDP(){
        try {
            DataSize = 1024;
            Client = new DatagramSocket();
            
        } catch (SocketException ex) {
            Logger.getLogger(CLientUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void send(String s){
        try {
            sendData = s.getBytes();
            InetAddress address = InetAddress.getByName("localhost");
            sendPacket = new DatagramPacket(sendData, sendData.length, address, 1107);
            Client.send(sendPacket);
        } catch (Exception ex) {
            Logger.getLogger(CLientUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String receive(){
        try {
            receiveData = new byte[DataSize];
            receivePacket = new DatagramPacket(receiveData, DataSize);
            Client.receive(receivePacket);
            String res = new String (receivePacket.getData()).trim();
            System.out.println(res);
            
        } catch (IOException ex) {
            Logger.getLogger(CLientUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new String (receivePacket.getData()).trim();
    }

}
