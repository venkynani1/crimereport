package datastructures;
public class Queue {
   Node first;
   Node last; 
   public void enqueue(int data)
   {
	   if(first==null &last ==null)
	   {
		   Node x=new Node(data);
		   first=x;
		   last=x;
		   return;
		   
	   }
	   else
	   {
		   Node x=new Node(data);
		   last.next=x;
		   last=x;
	   }
   }
	    public void dequeue()
	   {
	    	dequeue(first);
		  
	   }
	    private void dequeue(Node temp)
	    {
	    	
	    	Node copy=temp.next;
	    	temp.next=null;
	    	first=copy;
	    	return;
	    }
	   
	    public void display()
	       {
	    	   display(first);
	       }
	       private void display(Node temp)
	       {
	    	   if(temp==null) 
	    	   {
	    		   System.out.print("list is empty");
	    	   }
	    	   else
	    	   {
	    		   while(temp.next!=null)
	    		   {
	    			   System.out.print(temp.element+"<--");
	    			   temp=temp.next;
	    		   }
	    	   }
	    	   System.out.println("end!!");
	       }
   
   class Node
   {
	   Node first;
	   Node last;
	   int element;
	   Node next;
	   Node(int x)
	   {
		   element=x;
	   }
   }
	
}
