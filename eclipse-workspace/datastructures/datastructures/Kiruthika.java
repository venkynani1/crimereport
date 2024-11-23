package datastructures;

import java.util.Scanner;
public class Kiruthika
{
    public static void main(String[] args)
    {
        Scanner v=new Scanner(System.in);
        Tree t1=new Tree();
        int num=v.nextInt();
        while(true)
        {
            if(num ==-1)
              break;
            else
              t1.insert(num);
            num=v.nextInt();
        }
        int x = v.nextInt();
        t1.find(x);
        t1.inorder();
    }

}