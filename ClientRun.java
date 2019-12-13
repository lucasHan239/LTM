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
public class ClientRun {
    public static void main(String[] args) {
        CLientUDP client = new CLientUDP();
        client.send(";B16dccn298;100");
        String res = client.receive();
        StringUtil util = new StringUtil();
        util.SolveString(res);
        String requestID = util.requestId;
        int UC = util.UC();
        int a = util.a;
        int b = util.b;
        
        String send = requestID.concat(String.valueOf(UC));
        send = send.concat(",");
        send = send.concat(String.valueOf(a*b/UC));
        send = send.concat(",");
        send = send.concat(String.valueOf(a+b));
        send = send.concat(",");
        send = send.concat(String.valueOf(a*b));
        
        client.send(send);
        
    }
}
