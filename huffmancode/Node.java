/*
Singh, Gagandeep
Date: 05/08/19
 */
package huffmancode;

/**
 *
 * @author Singh Gagan
 */
public class Node {
    private char letter;
    private int frequency ; 
    private Node next;
    private Node left; 
    private Node right; 
    
    Node()                     //default constructor 
    {  
        frequency = 0 ; 
        next = null ; 
        left = null; 
        right = null; 
    }
    
    //setters and getters 
    public void setChar (char input)
    {
        letter = input; 
    }
    public void setFrequency (int count)
    {
        frequency = count ; 
    }
    public void setNext (Node next)
    {
        this.next = next ; 
    }
    public char getLetter()
    {
        return letter; 
    }
    public int getFrequency()
    {
        return frequency ; 
    }
    public Node getNext()
    {
        return next; 
    }
     public void setL(Node l)
    {
        left = l ; 
    }
    public void setR (Node r)
    {
        right = r; 
    }  
    public Node getLeft()
    {
        return left; 
    }
    public Node getRight()
    {
        return right; 
    }
    public void nodeFromListH(LinkedList a) //recieves a linked list
    {                                       //put head data fields into node
     setChar(a.getHead().getLetter());
     setFrequency(a.getHead().getFrequency()); 
    }
    public void displayFields()
    {
        System.out.println("Character"+"        "+"Frequency"); 
        System.out.println(getLetter()+ "                 " + getFrequency());
    }
}
