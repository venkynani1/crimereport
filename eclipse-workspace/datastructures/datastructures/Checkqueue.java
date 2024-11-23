package datastructures;

public class Checkqueue {

	public static void main(String[] args) {
		Queue q1=new Queue();
		q1.enqueue(50);
		q1.enqueue(51);
	    q1.enqueue(52);
	    q1.enqueue(53);
	    q1.display();
	    q1.dequeue();
	    q1.display();
	}

}
