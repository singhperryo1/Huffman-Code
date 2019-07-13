/*
Singh, Gagandeep
Date: 05/08/19

Singh, Chahatpreet
 */

/**
 *
 * @author Singh Gagan
 */
public class Tree {
    private Node root;
    Tree()              //default constructor 
    {
        root =null; 
    }
    //setters and getters 
    public void setRoot(Node a)
    {
        root = a ; 
    }
    public void setLchild(Node l)
    {
        root.setL(l);
    }
    public void setRchild(Node r)
    {
        root.setR(r);
    }
    public Node getRoot()
    {
        return root; 
    }
    public Node getLchild()
    {
        return root.getLeft(); 
    }
    public Node getRchild()
    {
        return root.getRight(); 
    }
}
