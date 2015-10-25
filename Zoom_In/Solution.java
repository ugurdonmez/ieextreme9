/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zoom_In;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ugurdonmez
 */
public class Solution {
    
    /*
    
    4
    4
    3
    H
    H  H
    H%%H
    H%%H
    H  H
    i
     () 

     II 
     II 
    !
     II 
     II 
     II 
     () 
    1
    Hi!
    */
    
    public static void main ( String [] args ) {
        
        Scanner scanner = new Scanner(System.in);
        
        int n, m, k;
        int test;
        
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        
        scanner.nextLine();
        
        HashMap<String, ArrayList<String>> maps = new HashMap<>();
        
        for ( int i = 0 ; i < k ; i++ ) {
            
            String c = scanner.nextLine();
            
            ArrayList<String> list = new ArrayList<>();
            
            for ( int j = 0 ; j < m ; j++ ) {
                String str = scanner.nextLine();
                
                while (str.length() < n) {                    
                    str = str + " ";
                }
                
                list.add(str);
                
            }
            
            maps.put(c, list);
            
        }
        
        test = scanner.nextInt();
        
        for ( int i = 0 ; i < test ; i++ ) {
            
            String str = scanner.next();
            
            for ( int a = 0 ; a < m ; a++ ) {
                
                for ( int j = 0 ; j < str.length() ; j ++) {
                    String chr = str.substring(j, j+1);
                    ArrayList<String> list = maps.get(chr);
                    
                    System.out.print(list.get(a));
                
                
                }
                System.out.println();
            }
        } 
    }
}
