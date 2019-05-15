/*
Singh, Gagandeep
Date: 05/08/19
 */
package huffmancode;

/**
 *
 * @author Singh Gagan
 */
public class LinkedList {
    private Node head ; 
    private int size ; 
    LinkedList()             //default constructor 
    {
     head = null ; 
     size = 0 ;  
    }
                           //setters and getters 
    public void SetHead (Node h)
    {
        head = h ; 
    }
    public void setSize(int n) 
    {
        size = n ; 
    }
    public Node getHead()
    {
        return head ; 
    }
    public int getSize()
    { 
        return size;
    }
    public Node search (char a)
    {
        
        Node temp = head; 
        while(temp!=null)
        {
            if(temp.getLetter()==a)
                return temp; 
            temp = temp.getNext(); 
        }
        return null; 
    }
    public void advance() //advances head of the List to the next node   
    {
        if(head.getNext()!=null)
        {
       Node temp = head; 
       temp = temp.getNext(); 
       SetHead(temp);
        }
    }
    public void insert (char a,int f)    //inserts the char value,
    {                                   //increments the frequency when a
        if(search(a)!=null)             //duplicate is inserted 
        {
     int count = search(a).getFrequency()+f; //adds the frequency of duplicates 
     search(a).setFrequency(count);
        return; 
        }
        Node temp = new Node();   
        temp.setChar(a);
        temp.setFrequency(f);
        if(getSize()==0)
        {
            head =temp;
         temp.setNext(null);
        }
        else
        {
           temp.setNext(head);
           head = temp ;
        }
        size++; 
    }
    public void insertMsg (String msg)
    {
        for(int i=0; i<msg.length();i++)
        {
            insert(msg.charAt(i),1);
        }
    }
    public void display()     
    {
        System.out.println("The Frequency Table"); 
        System.out.println("Character        Count"); 
        Node temp = head; 
        while(temp!=null) 
        {
            System.out.println(temp.getLetter()+"                 "+temp.getFrequency());
            temp = temp.getNext(); 
        }
    }
            
}
