package datastructures;

public class Linkedlist1 {
	Node head;
	Node tail;

public void addFirst(int value)
{
	if(head==null && tail==null)
	{
		Node x=new Node(value);
		tail=x;
		head=x; 
		return;
	}
	Node x=new Node(value);
	x.next=head;
	head=x;
	
}
public void addLast(int value)
{
	if(head==null && tail==null)
	{
		Node x=new Node(value);
		tail=x;
		head=x; 
		return;
	}
	Node x=new Node(value);
	tail.next=x;
	tail=x;
}
public void insertAtPosition(int pos,int data)
{
	if(pos==0||pos==1)
	{
		addFirst(data);
		return;
	}
	Node temp=getReference(head,pos);
	Node copy=temp.next;                  ///singly linked list
	Node x=new Node(data);
	temp.next=x;
	x.next=copy;
}
public Node getReference(Node temp,int pos){          //head value or refernce 
	for(int i=1;i<pos-1;i++)
	{
		temp=temp.next;
	}
	return temp;
}
	       
            public void display()
	       {
	    	   display(head);
	       }
	       private void display(Node temp)
	       {
	    	   if(temp==null) 
	    	   {
	    		   System.out.print("list is empty");
	    	   }
	    	   else
	    	   {
	    		   while(temp!=null)
	    		   {
	    			   System.out.print(temp.data+"-->");
	    			   temp=temp.next;
	    		   }
	    	   }
	    	   System.out.print("End");
	       }
class Node 
	{
		int data;
		Node next;
		Node(int x)
		{
			data=x;
		}
	}
}
