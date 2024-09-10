/*
*Adjoa Tettey-Fio
*SinglyLinkedList
*Oct 22
*/

import java.util.ArrayList;
import java.util.Iterator;

class SinglyLinkedList{
	//create head and pointer nodes

	Node head;

	static class Node{
		int data;
		Node next;

		Node(int d){
			data = d;
			next = null;
		}
	}

	public static SinglyLinkedList insert(SinglyLinkedList list, int data){
		//create new node
		Node new_node = new Node(data);
		new_node.next = null;

		//if list is empty make new node head
		if (list.head == null){
			list.head = new_node;
		}

		else{
			//search until last node
			Node last = list.head; //start at head
			while(last.next != null){ 
				last = last.next; //move to next node
			}
			//insert new node at end
			last.next = new_node;
		}

		return list;

	}

	public static void printList(SinglyLinkedList list){
		//start at head
		Node curr_Node = list.head;

		System.out.println("Singly Linked List: ");

		//traverse until end of list		
		while(curr_Node != null){
			System.out.print(curr_Node.data + " ");

			//move to next node
			curr_Node = curr_Node.next;
		}

		System.out.println("\n");
	}

	public static SinglyLinkedList deleteByKey(SinglyLinkedList list, int key){
		//store head node data and info about previous node to link when key node is deleted
		Node curr_Node = list.head, prev = null;

		//if node to be deleted is head node
		if(curr_Node != null && curr_Node.data == key){
			list.head = curr_Node.next;
			//how would we free up data here
			System.out.println("deleted :)");
			return list;
		}

		//if key is somewhere else in list
		//search for node
		//while current node isn't null and current node data does not equal key node
		while(curr_Node != null && curr_Node.data != key){
			//move to next node
			prev = curr_Node;
			curr_Node = curr_Node.next;
		}

		//once key node is found it should not be null
		if(curr_Node != null){
			//unlink current key node from list and link previous node to next node
			prev.next = curr_Node.next;
			System.out.println(key + " found and deleted :)");
		}

		//if key isn't found
		if(curr_Node == null){
			System.out.println(key + " not found :(");
		}

		return list;
	}

	public static SinglyLinkedList deleteAtPosition(SinglyLinkedList list, int index){
		//store head node data and info about previous node for deletion
		Node curr_Node = list.head, prev = null;

		//if index is 0 delete head node
		if(index == 0 && curr_Node != null){
			list.head = curr_Node.next;

			System.out.println("index " + index + " deleted :)");
			return list;
		}

		//counter for index
		int counter = 0;
		while(curr_Node != null){
			if (counter == index){
				prev.next = curr_Node.next;
				//again data management how do we free up space

				System.out.println("index " + index + " deleted :)");
				break;
			}

			

			else{
				prev = curr_Node;
				curr_Node = curr_Node.next;
				counter++;
			}
		}

		if(curr_Node == null){
			System.out.println(index + " position element not found :(");

		}

		return list;
	}

	 // method to create a Singly linked list with n nodes
    public static void main(String[] args)
    {
        /* Start with the empty list. */
        SinglyLinkedList list = new SinglyLinkedList();
 
        //
        // ******INSERTION******
        //
 
        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);
 
        // Print the LinkedList
        printList(list);
 
        //
        // ******DELETION BY KEY******
        //
 
        // Delete node with value 1
        // In this case the key is ***at head***
        deleteByKey(list, 1);
 
        // Print the LinkedList
        printList(list);
 
        // Delete node with value 4
        // In this case the key is present ***in the
        // middle***
        deleteByKey(list, 4);
 
        // Print the LinkedList
        printList(list);
 
        // Delete node with value 10
        // In this case the key is ***not present***
        deleteByKey(list, 10);
 
        // Print the LinkedList
        printList(list);
 
        //
        // ******DELETION AT POSITION******
        //
 
        // Delete node at position 0
        // In this case the key is ***at head***
        deleteAtPosition(list, 0);
 
        // Print the LinkedList
        printList(list);
 
        // Delete node at position 2
        // In this case the key is present ***in the
        // middle***
        deleteAtPosition(list, 2);
 
        // Print the LinkedList
        printList(list);
 
        // Delete node at position 10
        // In this case the key is ***not present***
        deleteAtPosition(list, 10);
 
        // Print the LinkedList
        printList(list);
    }


}