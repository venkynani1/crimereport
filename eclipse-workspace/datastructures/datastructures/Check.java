package datastructures;

public class Check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linkedlist1 l1 = new Linkedlist1();
		l1.addLast(555);
		l1.addFirst(50);
        l1.addFirst(100);
        l1.addLast(60);
        l1.addFirst(85);
        l1.addFirst(20);
      
        l1.insertAtPosition(2,100);
        l1.display();
	}

}
