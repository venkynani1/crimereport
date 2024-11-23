package terv.dsa;

import java.util.Scanner;

public class Checkout {


	    public static void main(String[] args)
	    {
	        Scanner v=new Scanner(System.in);
	        List l1=new List();
	        int tc=v.nextInt();
	        int n=v.nextInt();
	        for(int i=1;i<=n;i++)
	        {
	            int a=v.nextInt();
	            l1.addlast(a);
	        }
	        l1.display();
	        
	    }
	}

	


