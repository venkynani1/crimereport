package datastructures;

import java.util.*;
class Node
{
    int data;
    Node left;
    Node right;
    public Node(int data)
    {
        this.data=data;
    }
}
class Tree
{
    Node root;
    public void insert(int value)
    {
        if(root==null)
        {
         root=insert(root,value);
         System.out.println("inserted");
        }
    }
    private Node insert(Node temp,int data)
    {
        if(temp==null)
        {
            Node x=new Node(data);
            return x;
        }
        if(data<temp.data)
        {
        	System.out.println("going left");
            temp.left=insert(temp.left,data);
        }
        else if(data>temp.data)
        {
        	System.out.println("going right");
            temp.right=insert(temp.right,data);
        }
        return temp;
    }
    public void inorder()
    {
    	inorder(root);
    }
    private void inorder(Node temp)
    {
    	if(temp!=null)
    	{
    		inorder(temp.left);
    		System.out.println(temp.data);
    		inorder(temp.right);
    	}
    }
    public void find(int num)
    {
        find(root,num);
    }
    private void find(Node temp,int num)
    {
        boolean flag = false;
        while(temp !=null)
        {
            if(temp.data>num)
            {
                System.out.print(temp.data+" ");
                temp=temp.right;
            }
            else if(temp.data<num)
            {
                System.out.print(temp.data+" ");
                temp=temp.left;
            }
            else if(temp.data==num)
            {
                System.out.print(temp.data);
                flag = true;
                break;
            }
        }
        if(flag == false)
            System.out.print("not found");
    }
}
