/*
*Adjoa Tettey-Fio
*Stacks
*Feb 24
*/

import java.util.ArrayList;
import java.util.Iterator;

class Stack {

	//elements of stack
	public int arr[];

	//stores index of top element
	public int top;

	//size of stack
	public int size;

	public Stack(int size){
		arr = new int[size];
		this.size = size;
		top = -1;
	}

	public void Push(int data){
		//if stack is full end function
		if(top >= size){
			System.out.println("Stack is full");
		return;
		}
		top++;
		arr[top] = data;
		System.out.println("Size: " + size + ", Top (index of top element): " + top);

		return;
	}

	public int Pop(){
		//if top index is less than zero
		if(top < 0){
			System.out.println("Statck is empty");
			 return 0;
		}

		//
		int item = arr[top];
		arr[top] = 0;
		top--;
		return item;
	}

	public int Peek(){
		return arr[top];
	}

	public int Size(){
		return size;
	}

	//returns item at specified index
	// public int GetItemfromInd(int data){
	// 	return
	// }

	//returns item in stack that matches user input
	public int FindItem(int data){
		for( int i = 0; i <= top; i++){
			if(arr[i] == data){
				System.out.println("Match found :) at index " + i);
				return arr[i];
			}
			if(i == top){
				System.out.println("No matches found :(");
				return 0;
			}
		}
		return 0;

	}

	public void Print(){
		for( int i = 0; i <= top; i++){
			System.out.print(arr[i] +  ", ");
		}
	}

	public static void main(String[] args){
		Stack s = new Stack(Integer.parseInt(args[0])); 
	    s.Push(10); 
	    s.Push(20); 
	    s.Push(30); 
	    s.FindItem(15);
	    System.out.println(s.Pop() + " Popped from stack"); 
	    System.out.println("Top element is: " + s.Peek()); 
	    System.out.print("Elements present in stack :"); 
	    s.Print(); 
	}


}



