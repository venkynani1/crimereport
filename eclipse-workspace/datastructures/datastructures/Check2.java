package datastructures;

public class Check2 {

	public static void main(String[] args) {
      Doublylinkedlist l2=new Doublylinkedlist();
      l2.addFirst(50);
      l2.addLast(500);
      l2.addLast(200);
      l2.display();
      l2.insertatposition(2, 1000);
      l2.display();
      l2.deletefirst();
      l2.deleteatposistion(2);
      l2.display();l2.deleteatposistion(1);
      l2.display();
	}
}
