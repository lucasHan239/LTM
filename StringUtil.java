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
public class StringUtil {
    int a,b;
    String requestId;
    public StringUtil(){
        
    }
    public void SolveString(String s){
        int i = 0;
        for (; i < s.length();i++){
            if ( s.charAt(i) == ';') break;
        }
        int j = i + 1;
        for (; j < s.length();j++){
            if ( s.charAt(j) == ',') break;
        } 
        requestId = s.substring(0, i+1);
        a = Integer.parseInt(s.substring(i+1, j));
        b = Integer.parseInt(s.substring(j+1, s.length()));
    }
    public int UC(){
        int c,aa = a,bb = b;
        while (bb!=0){
            aa = aa % bb;
            c = aa;
            aa = bb; 
            bb = c;
        }
        return aa;
    }
    
}
