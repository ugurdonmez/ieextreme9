/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Car_Spark;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author ugurdonmez
 */
public class Solution {
    /*
    
    2
    4
    1 2 100
    2 3 200
    3 4 1600
    1 3 2100
    3
    1 10 2000
    2 5 100
    6 9 400
    */
    
    public static void main (String  [] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int test_case = sc.nextInt();
        
        for ( int i = 0 ; i < test_case ; i++ ) {
            
            int int_size = sc.nextInt();
            LinkedList<Interval> list = new LinkedList<>();
            
            for ( int j = 0 ; j < int_size ; j++ ) {
                list.add(new Interval(sc.nextInt(), sc.nextInt(), sc.nextInt()));                
            }
            
            Collections.sort(list);
            
            int [] max_array = new int[49];
            
            for ( int a = 0 ; a < max_array.length ; a++ ) {
                max_array[a] = 0;
            }
            
            for ( Interval it : list) {
                
                int m = Integer.max(max_array[it.end], max_array[it.start] + it.value);
                
                for ( int a = it.end ; a < 49 ; a++ ) {
                    max_array[a] = m;
                }
                
            }
            
            /*
            for ( int a = 0 ; a < max_array.length ; a++ ) {
                System.out.println(a + " " + max_array[a]);
            }
                    
                    */
            
            System.out.println(max_array[48]);
            
        }
        
    }
    
    
}

class Interval implements Comparable<Interval>{
    
    int start;
    int end;
    int value;

    public Interval(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return start + " " + end + " " + value;
    }

    @Override
    public int compareTo(Interval o) {
        
        return Integer.compare(this.end, o.end);
        
    }
    
}