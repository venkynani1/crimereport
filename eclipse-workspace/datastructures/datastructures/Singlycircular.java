package datastructures;


public class Singlycircular {
	Node head;
	Node tail;
	public void add(int data)
	{
		if(head==null && tail==null)
		{
	      Node x=new Node(data);
	      x.next = x;
	      head=x;
	      tail=x;
	      return;
		}
		else
		{
			Node x=new Node(data);
			x.next=head;
			tail.next = x;
			head = x;
           
		}
	}
	public void delete()
	{
		if(head==null && tail ==null)
		{
			System.out.print("empty list");
		}
			Node copy=head.next;
		head.next=null;                    ///head=head.next; tail.next=head;//
		tail.next=copy;
		head=copy;
	
	}
	public void display()
	{
		if(head==null)
		{
			System.out.print("emptylist");
		}
		Node temp=head;
		do
		{       
			System.out.print(temp.data+"-->");
			temp=temp.next;
		    
		}while(temp!=head);
		System.out.println("end");
	}
	class Node
	{
		int data;
		Node head;
		Node next;
		Node tail;
		Node(int x)
		{
			data=x;
		}
	}
}
