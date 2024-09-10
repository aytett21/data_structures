/*
*Adjoa Tettey-Fio
*ArrayList
*Sep 22
*/

import java.util.ArrayList;
import java.util.Iterator;

class Array {

	//variables private to this class

	//array of elements
	private int arr[];

	//size of array
	private int capacity;

	//number of elements in array
	private int currentsize;

	//class constructor
	//creates array of with a size of 1 and 
	public Array(){
		arr = new int[1];
		capacity = 1;
		currentsize = 0;

	}

	void push(int data) { //this function takes one element and inserts it at the last
		//check if array is full. if it is, create an array that's twice as big
		if (capacity == currentsize){
			int temparr[] = new int[capacity * 2];

			//copy elements to new array
			for (int i = 0; i < capacity; i++){
				temparr[i] = arr[i];
			}

			//update capacity for new, larger array
			capacity *= 2;
			//update array object with temporary array values
			arr = temparr;
		}

		//insert new data and increase current size
		arr[currentsize] = data;
		currentsize++;
	}

	void push(int data, int index) { //inserts data at the specified index
		//i should throw an exception here for if the index called is invalid


		//if the index we are adding is the same as the capacity, then call above push function so that array size can be updated to fit new data
		if(index == capacity){
			push(data);
		}
		else{ 
			arr[index] = data;
		}
	}

	int get(int index) { //is used to get the element at the specified index
		//again i should throw an exception for if the index is invalid
		//check to see if index is less than current size
		if(index < currentsize){
			return arr[index];
		}
		//if index isn't valid funtion will exit
		return -1;
	}

	void pop() { //deletes the last element
		//need to check if array is empty

		//set last element in array to null
		//arr[currentsize] = null;

		//decrease current size by one
		currentsize--;
	}

	int size() { //It returns the size of the ArrayList i.e, number of elements in the ArrayList
		return currentsize;
	}

	int getcapacity() { //returns the capacity of the ArrayList
		return capacity;
	} 

	void print() { //print array elements
		for (int i = 0; i < currentsize; i++){
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

	 public static void main(String args[])
    {
        Array v
            = new Array();
        v.push(10);
        v.push(20);
        v.push(30);
        v.push(40);
        v.push(50);
  
        System.out.println("ArrayList size: "
                           + v.size());
        System.out.println(
            "ArrayList capacity: "
            + v.getcapacity());
        System.out.println(
            "ArrayList elements: ");
        v.print();
  
        v.push(100, 1);
  
        System.out.println(
            "\nAfter updating 1st index");
  
        System.out.println(
            "ArrayList elements: ");
        v.print();
        System.out.println(
            "Element at 1st index: "
            + v.get(1));
  
        v.pop();
  
        System.out.println(
            "\nAfter deleting the"
            + " last element");
  
        System.out.println(
            "ArrayList size: "
            + v.size());
        System.out.println(
            "ArrayList capacity: "
            + v.getcapacity());
  
        System.out.println(
            "ArrayList elements: ");
        v.print();
    }

} 