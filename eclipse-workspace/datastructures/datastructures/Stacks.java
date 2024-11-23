package datastructures;



public class Stacks {
	Node top;
	public void push(int data)
	{
		Node x=new Node(data);
		x.next=top;
		top=x;
	    
	}
	public int pop()
	{
		if(top==null) {
			System.out.print("empty stack");
			return -1;
			}
			else
			{
				int data=top.data;
				Node copy=top.next;
				top.next=null;
				top=copy;
				return data;
			}
		}
	public int peek()
	{
		return top.data;
	}
	
	public void display()
	{
		Node temp=top;
		while(temp!=null)
		{
			System.out.println(temp.data);
			System.out.println("^");
			temp=temp.next;
		}
		
	}
	class Node
	{
		int data;
		Node next;
		public Node(int data)
		{
	          this.data=data;
		}
	}

}
