/*
Singh, Gagandeep
Date: 05/08/19
 */


/**
 *
 * @author Singh Gagan
 */
public class Encode {
  
  public static void buildCodeTable(String[] code, Node current, String a)
  {
       if(current.getLetter()!=0 && a=="")   //for special case of one character
       {
           int index= (int) current.getLetter();
           code[index]= "0";
           return;
       }  
  if(current!=null)
  {
	  if(current.getLetter()!=0)
	  {  
	       int index = (int) current.getLetter();
	       code[index]= a ; 
	  }           
	  else
	  {
	       buildCodeTable(code,current.getLeft(),a+"0"); 
	       buildCodeTable(code,current.getRight(),a+"1");   
	  }
  }
}
  public static void codeIt (String msg, String[]codeTable)
  {
      String output = ""; 
      for(int c =0; c <msg.length(); c++)
      {
          int index = (int) msg.charAt(c); 
          output += codeTable[index];
          output += " "; 
      }
     System.out.println(output);
  }
  
    public static void makeHuffmanTree(MinPriorityQueue queue)
    {                                     
        while(queue.getSize() > 1)
        {
	        Tree  r1 =  queue.remove(); 
	        Tree  r2 =   queue.remove(); 
	        Tree newTree = new Tree();
	        Node newNode = new Node();
	        newNode.setFrequency(r1.getRoot().getFrequency()+r2.getRoot().getFrequency());
	        newNode.setL(r1.getRoot());
	        newNode.setR(r2.getRoot());
	        newTree.setRoot(newNode);
	        queue.insert(newTree);
        }
    }
    public static void makeHuffmanPQT (int[] asciiTable, MinPriorityQueue queue) 
    {            
         for(int i = 0 ; i < asciiTable.length ; i++)
        {
        	 if(asciiTable[i]!=0)
        	 {
		        Tree treeInQueue = new Tree(); 
		        Node node = new Node();
		        node.setFrequency(asciiTable[i]);
		        node.setChar((char)i);
		        treeInQueue.setRoot(node);
		        queue.addTree(treeInQueue);
        	 }
        }
         queue.buildLinearTimeHeap();
    }
}
