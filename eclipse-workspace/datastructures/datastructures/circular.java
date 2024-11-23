package datastructures;

public class circular {
	Node head;
	public void add(int data)
	{
		if(head==null )
		{
			Node x=new Node(data);
			
			x.prev=x;
			x.next=x;
			head=x;
			
		}
		     
		      Node x=new Node(data);
			  x.next=head;
		      Node copy=head.prev;
		      x.prev=copy;
		      copy.next=x;
		      head.prev=x;
		      head=x;
	}
	public void delete()
	{
		if(head==null)
		{
			
		}
		Node copy1=head.prev;
		Node copy2=head.next;
		head.prev=head.next=null;
		copy2=head.prev;
		copy1=head.next;
		
	} 
	public void display()
	{
		if(head==null)
		{
			System.out.print("empty list");
		}
		else
		{
			Node temp=head;
			do
			{
				temp=temp.next;
				System.out.print(temp.data+"-->");
			}while(temp.next!=head);
			System.out.print("end");
		}
	}
		class Node
		{
			Node prev;
			int data;
			Node next;
			public Node(int x)
			{
			   data=x;
			}
		}
	

}
