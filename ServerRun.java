/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ID100;

/**
 *
 * @author My PC
 */
public class ServerRun {
    public static void main(String[] args) {
        ServerUDP server = new ServerUDP();
        server.listening();
    }
}
