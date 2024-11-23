package terv.dsa;
import java.util.*;

public class List {
    Node head;
    Node tail;
    public void addlast(int value)
    {
        if(head==null && tail==null)
        {
            Node x=new Node(value);
            head=x;
            tail=x;
        }
        else
        {
            Node x=new Node(value);
            tail.next=x;
            tail=x;
        }
    }
    public void display()
    {
        display(head);
    }
    private void display(Node temp)
    {
        while(temp!=null)
        {
            System.out.print(temp.data+">");
            temp=temp.next;
        }
        System.out.print("end");
    }
    
}

class Node{
    int data;
    Node next;
    public Node(int data)    ///constructor name should be class name  
    {
        this.data=data;
    }
}



