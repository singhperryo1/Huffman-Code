

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
        if(message.isEmpty())
        	System.exit(0);
    //-----------------------------------------------// 
     
       int[] asciiTable = new int[256]; //total number of character possible
       for(int i = 0; i < message.length(); i++)
       {
    	   asciiTable[(int)message.charAt(i)]++;
       }
       
    //-----------------------------------------------//
        MinPriorityQueue queue =  new MinPriorityQueue(); 
        String[] codeTable = new String[256];
    //---------------------------------------------//
          Encode.makeHuffmanPQT(asciiTable, queue);   //builds MinPriorityQueue with all tree root in it           
          Encode.makeHuffmanTree(queue); 
          Encode.buildCodeTable(codeTable,queue.fetchStart().getRoot(),""); //contains huffman codes of char 
          
          System.out.println(" Your Huffman code is : ");
          Encode.codeIt(message, codeTable);  
}

	
}