/*
Singh, Gagandeep
Date: 05/08/19
 */
package huffmancode;

/**
 *
 * @author Singh Gagan
 */
public class PQT {
private Node start ; 
private int currentSize; 
PQT()                      //default constructor 
{
    start = null ;
    currentSize = 0 ; 
}
                         //setters and getters 
public void setStart(Node a)
{
    start = a ; 
}
public void setSize(int n)
{
    currentSize = n; 
}
public Node getStart()
{
    return start; 
}
public int getSize()
{
    return currentSize ; 
}
public Node remove()
{
    if(currentSize==0)
        return null ; 
   Node temp = start; 
   start = start.getNext(); 
   currentSize--; 
   return temp; 
}
public Node fetchStart()     //simply fetches start of the PQT 
{
     return start; 
}
public void displayPq()
{
    System.out.println("Priority Queue: "); 
    Node temp = start; 
    while(temp!=null)
    {
        temp.displayFields();
        temp = temp.getNext(); 
    }
}
public void insert(Node a)
{
    Node temp = a; 
    if(currentSize==0)
        start = temp ; 
    else if(temp.getFrequency()<=start.getFrequency())
    {
        temp.setNext(start);
        start = temp ; 
    }
    else 
    {
        Node pre = start; 
        Node curo = start.getNext(); 
        while(curo!=null)
        {
         if(temp.getFrequency()<curo.getFrequency())
             break ; 
         else 
         {
             pre = pre.getNext(); 
             curo = curo.getNext(); 
         }
        }
            pre.setNext(temp);
            temp.setNext(curo);
        }
    currentSize++; 
    }
}

