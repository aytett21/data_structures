/*
*Adjoa Tettey-Fio
*Queue.Java
*Feb 24
*/

import java.util.ArrayList;
import java.util.Iterator;

class Queue {

	//new queue
	public int arr[];

	//pointer to front of queue where items are deleted
	public int front;

	//pointer to rear where items are added
	public int rear;

	//capacity of queue
	public int size;

	public Queue(int size){
		arr = new int[size];
		this.size = size;
		front = -1; //where items are removed
		rear = -1; //where items are added
	}

	public void Enqueue(int data){
		//check if stack is full
		if(rear == size-1){
			System.out.println("Queue is full.");
			return;
		}

		//if queue is empty, inserting first element
		if(front == -1){
			front = 0;
		}
		rear++;
		arr[rear] = data;
		return;
	}

	public int Dequeue(){
		//check if queue empty
		if(front < 0){
			System.out.println("Queue is empty.");
			return 0;
		}

		//placeholder for removed item
		int item = arr[front];
		front++;

		//if queue is full
		if(front == size-1){
			front = -1; 
			rear = -1;
		}

		System.out.println("Removed " + item);
		return item;
	}

	public void Display(){
		if(front < 0){
			System.out.println("Queue is empty.");
			return;
		}

		System.out.print("Elements in queue: ");
		for(int i = front; i <= rear; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return;
	}

	//returns front of queue where elements are deleted
	public int Peek(){
		System.out.println(arr[front]);
		return arr[front];
	}

	public static void main(String[] args){
		Queue q = new Queue(Integer.parseInt(args[0]));

		q.Dequeue();

	    // Enqueue 5 elements
	    q.Enqueue(1);
	    q.Enqueue(2);
	    q.Enqueue(3);
	    q.Enqueue(4);
	    q.Enqueue(5);

	    q.Peek();

	    // 6th element can't be added to because the queue is full
	    q.Enqueue(6);

	    q.Display();

	    // deQueue removes element entered first i.e. 1
	    q.Dequeue();
	    q.Peek();


	    // Now we have just 4 elements
	    q.Display();
	}
}