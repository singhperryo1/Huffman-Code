/*
Singh, Gagandeep
Date: 05/08/19
 */
package huffmancode;

/**
 *
 * @author Singh Gagan
 */
public class Encode {
  String [] code = new String[300]; 
  public void buildCodeTable(String a, Node current)
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
       buildCodeTable(a+"0",current.getLeft()); 
       buildCodeTable(a+"1",current.getRight());   
  }
  }
}
  public String codeIt (String msg)
  {
      String output = ""; 
      for(int c =0; c <msg.length(); c++)
      {
          int index = (int) msg.charAt(c); 
          output += code[index];
          output += " "; 
      }
      return output; 
  }
    public void makeHuffmanTree(PQT p, Tree test)
    {                               //recieves PQT and make huffman tree                                     
                                  //while removing and inserting roots 
        if(p.getSize()==1)       //for special case of only one character
        {
        Node exception = new Node(); 
        exception.setFrequency(p.getStart().getFrequency());
        exception.setChar(p.getStart().getLetter());
        test.setRoot(exception);
        p.insert(test.getRoot());
        return ; 
        }
        
        while(true)
        {
        if(p.getSize()==1)
        break;
        Node  r1 =  p.remove(); 
        Node  r2 =   p.remove(); 
        Node newRoot = new Node();
        newRoot.setFrequency(r1.getFrequency()+r2.getFrequency());
        newRoot.setL(r1);
        newRoot.setR(r2);
        test.setRoot(newRoot);
        p.insert(test.getRoot()); 
    }
    }
    public void makeHuffmanPQT (LinkedList test, PQT p1) 
    {            //recieves list and PQT and make PQT containing tree roots
         for(int i = 0;i<test.getSize(); i++)
        {
        Tree origin = new Tree(); 
        Node cc = new Node();
        cc.nodeFromListH(test);
        origin.setRoot(cc);
        p1.insert(origin.getRoot());
        test.advance(); 
        }
    }
  public void printHuffmanCode(String input)
  {
      System.out.println("The Huffman Code for your message is: ");
      System.out.println(codeIt(input));
  }
}
