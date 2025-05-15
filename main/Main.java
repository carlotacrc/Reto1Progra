package Reto1Progra.main;
import java.io.*;
import java.util.Set;
import Reto1Progra.BinaryTree.BinaryTree;
import java.util.*;

public class Main {

       private static final Set<String> RESERVED_WORDS = new HashSet<>(Arrays.asList(
        "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp",
            "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void",
            "volatile", "while"));

    public static void main(String[] args) {

        String filePath = "data.txt"; 
        BinaryTree arbol = new BinaryTree();

     
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            
            String line;
            int numero = 1;

            while ((line = reader.readLine()) != null) {
                
                procesarLinea(line, numero, arbol);
                numero++;
            }

            arbol.inOrderTraversal();

        } catch (IOException e) {
           
            e.printStackTrace();
        }
    }

    public static void procesarLinea(String line, int lineNumber,BinaryTree tree){

        int i=0;

        while(i<line.length()){
            char c = line.charAt(i);

            if( c == '_' || c== '$' || (c >= 'a' && c<= 'z') || (c>= 'A' && c<= 'Z')){

                StringBuilder sb = new StringBuilder();
                sb.append(c);
                i++;
                

                while (i<line.length()) {
                    
                    c = line.charAt(i);

                    if(c == '_' || c== '$' || (c >= 'a' && c<= 'z') || (c<= 'A' && c>= 'Z') || (c>= '0' && c<= '9')){

                            sb.append(c);
                            i++;
                    } else{
                        break;
                    }   
                }

                String resul = sb.toString();
                if( !RESERVED_WORDS.contains(resul)){

                    tree.add(resul,lineNumber);
                }
            } else{
                i++;
            }
        }
    }
}