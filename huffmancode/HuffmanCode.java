/*
Singh, Gagandeep
Date: 05/08/19
 */
package huffmancode;
import java.util.Scanner ; 
public class HuffmanCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        System.out.println("WELCOME TO THE HUFFMAN CODE CONVERTER "); 
        System.out.println("Please enter your message here: ");   
        String message;                                               
        message = scan.nextLine();
    //-----------------------------------------------// 
        LinkedList list = new LinkedList(); 
        list.insertMsg(message);
        list.display();           //displays char(s) of messge with frequency
    //-----------------------------------------------//
        PQT p1 =  new PQT();
        LinkedList temp = list;
        Tree test = new Tree(); 
    //---------------------------------------------//
        Encode go = new Encode();
        go.makeHuffmanPQT(temp, p1);   //builds PQT with all tree root in it
        p1.displayPq();               
        go.makeHuffmanTree(p1, test); 
        go.buildCodeTable("",test.getRoot()); //contains huffman codes of char 
        go.printHuffmanCode(message);  
}
}