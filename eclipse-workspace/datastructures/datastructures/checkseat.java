package datastructures;

import java.util.Scanner;

import datastructures.Seating.Biotech;
import datastructures.Seating.Mechanical;

public class checkseat{

	
	
	    public static void main(String[] args)
	    {
	        Scanner v=new Scanner(System.in);
	        Seating obj = new Seating();
	        Mechanical m1=new Mechanical();
	        Biotech b1=new Biotech();
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

