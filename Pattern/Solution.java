/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern;

import java.util.*;
import java.util.regex.*;

/**
 *
 * @author ugurdonmez
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test_case = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < test_case; i++) {
            String str = sc.nextLine();
                        
            int ch = 0;
            while ( true ) {
                ch++;
                
                if ( ch == str.length() ) {
                    break;
                }
                
                Pattern pattern = Pattern.compile(str.substring(0, ch));
                Matcher matcher = pattern.matcher(str);
                
                int last = 0;
                boolean isConnected = true;
                while (matcher.find()) {
                    
                    //System.out.println("found: " + count + " : "
                    //        + matcher.start() + " - " + matcher.end());
                                        
                    if ( last != 0 && matcher.start() != last ) {
                        isConnected = false;
                        break;
                    }
                    
                    last = matcher.end();
                }
                
                String lastPart = str.substring(last, str.length());
                                
                if ( !lastPart.equals(str.substring(0, lastPart.length())) ) {
                    continue;
                }

                if ( isConnected ) {
                    break;
                }
            }
            System.out.println(ch);
        }
    }

}
