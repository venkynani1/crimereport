package terv.dsa;
import java.util.*;
class Seating
{
  // mech class
	static class Mechanical
	{
	    Node1 head1;
	    Node1 tail1;
		public void addlast1(int value)
		{
		    if(head1==null && tail1==null)
		    {
		        Node1 x=new Node1(value);
		        head1=x;
		        tail1=x;
		        return;
		    }
		     Node1 x=new Node1(value);
		     tail1.next1=x;
		     tail1=x;
		  
	
		}
		static class Node1
	    {
	        int data1;
	        Node1 next1; 
	        Node1(int x)
	        {
	            data1=x;
	        }
	    }
	}
	//biotech
	static class Biotech
	{
	    Node2 head2;
	    Node2 tail2;
	    static class Node2
	    {
	        int data2;
	        Node2 next2;
	        Node2 (int y)
	        {
	            data2=y;
	        }
	    }
	    public void addlast2(int value)
	    {
	        if(head2==null && tail2==null)
	        {
	            Node2 x=new Node2(value);
	            head2=x;
	            tail2=x;
	           return;
	        }
	        Node2 x=new Node2(value);
	        tail2.next2=x;
	        tail2=x;
	      
	    }
	    
	}
	void display(Mechanical.Node1 temp1,Biotech.Node2 temp2)
	{
	    while(temp1!=null || temp2!=null)
	    {
	        if(temp1!=null)
	        {
	            System.out.print(temp1.data1+" ");
	        temp1=temp1.next1;
	        }
	        else
	            System.out.print("_ ");
	        if(temp2!=null)
	        {
	            System.out.print(temp2.data2+" ");
	        temp2=temp2.next2;
	        }
	    }
	    System.out.print("End");
	}
}
public class Main
{
	    public static void main(String[] args)
	    {
	        Scanner v=new Scanner(System.in);
	        Seating obj = new Seating();
	        Seating.Mechanical m1=new Seating.Mechanical();
	        Seating.Biotech b1=new Seating.Biotech();
	         while(true)
	         {
	        	 int  data1=v.nextInt();
	            if(data1!=-1){
	            m1.addlast1(data1);
	            }
	            else
	             break;
	         }
	         while(true)
	         {
	        	 int data2=v.nextInt();
	            if(data2!=-1)
	            {
	                b1.addlast2(data2);
	            }
	            else
	              break;
	         }
	         obj.display(m1.head1,b1.head2);     
	    }

	}

