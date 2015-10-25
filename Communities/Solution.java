/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ugurdonmez
 */
public class Solution {
    
    public static void main ( String [] args ) {
        
        Scanner sc = new Scanner(System.in);
        
        int name_size = sc.nextInt();
        int cycle_size = sc.nextInt();
        
        
        
    }
    
    
}

class Graph {
    
    int node_size;
    ArrayList<Integer> cycles;
    HashMap<String, Node> nodes;
    
    
    
    public Graph(int node_size, Scanner scanner) {
        
        this.node_size = node_size;
        nodes = new HashMap<>();
        cycles = new ArrayList<>();
        
        while ( scanner.hasNext() ) {
            
            if ( scanner.next().equals("END") ) {
                break;
            }
            
            String name1 = scanner.next();
            String name2 = scanner.next();
            
            if ( nodes.containsKey(name1) ) {
                nodes.get(name1).adjs.add(name2);
            } else {
                Node node = new Node(name1);
                node.adjs.add(name2);
            }
            
        }
        
    }
    
    public void findCycles() {
        
        Node node = findUnvisitedNode();
        
        if ( node == null ) {
            return;
        }
        
        
        
    }
    
    public void findCycleSize(Node node) {
        
        int size = 0;
        
        while (  )
        
    }
    
    private Node findUnvisitedNode() {
        
        for ( Node n : nodes.values() ) {
            
            if ( n.type == DFSType.EMPTY ) {
                return n;
            }
            
        }
        
        return null;
    }
    
}

enum DFSType {
    VISITING, VISITED, EMPTY;   
}

class Node {
    
    String name;
    DFSType type;
    Node back;
    
    ArrayList<String> adjs;

    public Node(String name) {
        this.name = name;
        this.type = DFSType.EMPTY;
        this.adjs = new ArrayList<>();
    }
    
    
    
    
}