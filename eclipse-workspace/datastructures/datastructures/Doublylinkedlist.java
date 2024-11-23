package datastructures;

public class Doublylinkedlist {

	Node head;
	Node tail;
	public void replace(int pos)                /////
	{
		Node temp=getreference(head,pos+1);
		temp.data=(temp.data)*10;
	}
	public void addFirst(int value)
	{
	  addFirst(head,value);
	}
	private void addFirst(Node temp,int value)               ////add at first
	{
		if(head==null && tail==null)       //checks whether list is empty
		{
			Node x=new Node(value);
			head=x;
			tail=x;
			return;
		}
		Node x=new Node(value);
		x.next=head;
		head.prev=x;
		x.prev=null;
		head=x;
	}
	public void addLast(int value)           ///add at last
	{
		addLast(head,value);
	}
	private void addLast(Node temp,int value)
	{
		if(head==null && tail==null)
		{
			Node x= new Node(value);
			head=x;
			tail=x;
			return;
		}
		Node x=new Node(value);
		while(temp.next!=null)
		{                                                       /////////
			temp=temp.next;
		}
		temp.next=x;
		x.prev=temp;
		x.next=null;
		tail=x;
	}
	public void insertatposition(int pos,int data)
	{
		if(pos==0||pos==1)
		{
			addFirst(data);
			return;
		}
		Node temp=getreference(head,pos);
		 Node copy=temp.next;
		 Node x=new Node(data);
		 temp.next=x;
		 x.prev=temp;
		 x.next=copy;
		 copy.prev=x;
		 
		
	}
public Node getreference(Node temp,int pos)         ///get the reference node
	
	{
		for(int i=1;i<pos-1;i++)
		{
			temp=temp.next;
		}
		return temp;
	} 
	public void deletefirst()                ////delete at first
	{
		deletefirst(head);
	}
	private void deletefirst(Node temp)
	{
		if(head==tail)
	{
		System.out.print("emptylist");
		head=null;
		tail=null;
		return;
	}
		
		
		Node copy=temp.next;
		temp.next=null;
		if(copy!=null)
		copy.prev=null;
		head=copy;
	}
	
	public void deletelast()       ///////delete at last
	{
		deletelast(head);
	}
	private void deletelast(Node temp)
	{
		if(head== tail) {
			System.out.print("empty list");
			head = null;tail=null;
			return;
		}
		
		while(temp.next!=tail)
		{
			temp=temp.next;
		}
		Node copy=temp.prev;
		temp.prev=null;
		if(copy!=null)
		copy.next=null;
		tail=copy;
	}
	public void deleteatposistion(int pos)
	{
		deleteatposition(head,pos);
	}
	private void deleteatposition(Node temp,int pos)
	{
		if(pos==1)
		{
			deletefirst();
			return;
		}
		int i=1;
		if(pos==i)
		{
			Node copy1=temp.prev;
			Node copy2=temp.next;
			temp.next=null;
			temp.prev=null;
			copy1.next=copy2;
			copy2.prev=copy1;
		}
		i++;
	}
    public void display()
   {
	   display(head);
   }
   private void display(Node temp)
   {
	   if(temp==null) 
	   {
		   System.out.println("list is empty");
	   }
	   else
	   {
		   while(temp!=null)
		   {
			   System.out.print(temp.data+"-->");
			   temp=temp.next;
		   }
	   }
	   System.out.println("End");
   }
	class Node
	{
		int data;
		Node next;
		Node prev;
		Node(int d)     //create a constructor
		{
			data=d;   ///if use same variablle this.data=data
		}
	}
}
