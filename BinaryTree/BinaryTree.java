package Reto1Progra.BinaryTree;

import java.util.ArrayList;

public class BinaryTree {

    private class Node {

        public String indentificador;
        public ArrayList<Integer> lineas;
        public BinaryTree izq;
        public BinaryTree der;

        Node(String identifier, int lineNumber){

            indentificador = identifier;
            lineas = new ArrayList<Integer>();
            lineas.add(lineNumber);
            izq = new BinaryTree();
            der = new BinaryTree();
        }
    }

    private Node root;

    public void add (String identifier, int lineNumber){

        if(root == null){

            root = new Node(identifier,lineNumber);
        }

        int x = root.indentificador.compareTo(identifier);

        if( x > 0){

            root.izq.add(identifier,lineNumber);
        }
        if( x < 0){
            
            root.der.add(identifier,lineNumber);
        }
        if( x == 0){
            
            root.lineas.add(lineNumber);
        }
    }
    
    public void inOrderTraversal(){

        if( root.izq.root != null){
            
            root.izq.inOrderTraversal();
        }
        System.out.print(root.indentificador + " -> " + root.lineas.get(0));
        
        for(int i=1;i<root.lineas.size();i++){
            
            System.out.print( ", " + root.lineas.get(i));
        }
        System.out.println("");

        if( root.der.root != null){
            
            root.der.inOrderTraversal();
        }
    }
}
