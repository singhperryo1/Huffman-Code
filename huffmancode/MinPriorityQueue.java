import java.util.ArrayList;

/*
Singh, Gagandeep
Date: 05/08/19
 */


/**
 *
 * @author Singh Gagan
 */
public class MinPriorityQueue {
private ArrayList<Tree> queue;
MinPriorityQueue()                      //default constructor 
{
     queue = new ArrayList<Tree>();
}
                         //setters and getters 

public Tree remove() //O(lg n) remove 
{
    if(queue.size() == 0)
        return null ; 
   Tree minTree =  queue.get(0);
   queue.set(0, queue.get(queue.size()-1));
   queue.remove(queue.size()-1);
   minheapify(0); 
   return minTree;
}

public void addTree(Tree t)
{
	queue.add(t);
}
private void swap(int fpos, int spos) 
{ 
    Tree tmp; 
    tmp = queue.get(fpos); 
    queue.set(fpos, queue.get(spos));
    queue.set(spos, tmp);
} 

private boolean isLeaf(int pos)
{
	if (pos >= (queue.size() / 2) && pos < queue.size()) { 
        return true; 
    } 
    return false; 
}

private Tree getLeft(int pos)
{
	return queue.get(2*pos+1);
}

private Tree getRight(int pos)
{
	return queue.get(2*pos+2);
}

public void minheapify(int targetIndex)
{
	if(queue.size() == 0)
		return;
	int parentFreq = queue.get(targetIndex).getRoot().getFrequency();	
	if(!isLeaf(targetIndex)) //node is not a  leaf are in the queue
	{	
		int leftFreq = getLeft(targetIndex).getRoot().getFrequency();
		if((2*targetIndex) + 2 < queue.size())//does have right right child
		{
			int rightFreq = getRight(targetIndex).getRoot().getFrequency();
			
			if( leftFreq <= rightFreq)//left is smallest Child
			{
				if(parentFreq <= leftFreq)
				{
					return;
				}
				else
				{
					swap(targetIndex, 2*targetIndex+1);
					minheapify(2*targetIndex+1);
				}
			}	
			else//right is smallest child
			{
				if(parentFreq <= rightFreq)
				{
					return;
				}
				else
				{
					swap(targetIndex, 2*targetIndex+2);
					minheapify(2*targetIndex+2);
				}
			}
		}
		else //have only left child
		{
			if(parentFreq <= leftFreq)
			{
				return;
			}
			else
			{
				swap(targetIndex, 2*targetIndex+1);
				minheapify(2*targetIndex + 1);
			}
		}			
  }
	
    
}
public Tree fetchStart()     //simply fetches start of the MinPriorityQueue 
{	
     return queue.get(0);
}

public void insert(Tree a) //O(lg n) insertion 
{
    queue.add(a);
    int index = queue.size()-1;//index of new node
    while((index-1)/2 >= 0 && queue.get((index-1)/2).getRoot().getFrequency() > queue.get(index).getRoot().getFrequency())//parent's frequency is smaller and parent is in heap
    {
    	swap(index, (index-1)/2);
    	index = (index-1)/2;   	
    }
}

	public void buildLinearTimeHeap()//linear time heap build up
	{
			for(int i = (queue.size()/2)-1; i >=0 ;i--)
				minheapify(i);
	}
	
	public int getSize()
	{
		return queue.size();
	}

}



