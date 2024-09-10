/*
*Adjoa Tettey-Fio
*DoublyLinkedList
*Oct 22
*/


import java.util.ArrayList;
import java.util.Iterator;

class DoublyLinkedList{
	//create head and pointer (next and prev) nodes
	class Node{
		int data;
		Node prev;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	Node head, tail = null;

	//add new node to front of list
	public void push(int new_data){
		//create new node
		Node new_node = new Node(new_data);

		//make the current head the new node's next (because new node will be head) and make the new node's prev null
		new_node.next = head;
		new_node.prev = null;

		//link prev of old head to new head
		if(head != null){
			head.prev = new_node;
		}

		//make the new node the head
		head = new_node;

		//return list but it will need to be an argument for the method
	}

	//insert new node after given node
	public void InsertAfter(Node prev_node, int new_data){
		//check if previous node is null
		if(prev_node == null){
			System.out.println("previous node is null :/");
			//why do i need to return here but not at other spots?
			return;
		}

		//create new node
		Node new_node = new Node(new_data);

		//make next of new node the next of previous node
		new_node.next = prev_node.next;

		prev_node.next = new_node;

		//make previous node of new node the original previous node
		new_node.prev = prev_node;

		
		if(new_node.next != null){
			//change previous of new_node's next node
			new_node.next.prev = new_node;
		}

	}

	//insert new node before given node
	public void InsertBefore(Node next_node, int new_data){
		//check if given node is null
		if(next_node == null){
			System.out.println("given next node is null :/");
			return;
		}

		//create new node
		Node new_node = new Node(new_data);

		//make previous of new node the previous of the next node
		new_node.prev = next_node.prev;

		//make previous of next node the new node
		next_node.prev = new_node;

		//make next of new node the next of the next node
		new_node.next = next_node;

		//check if new node was added as head
		if(new_node.prev != null){
			new_node.prev.next = new_node;
		}
		else{ //if new node's previous is null then it's head
			new_node = head;
		}
	}


	//add node to end
	public void append(int new_data){
		Node new_node = new Node(new_data);

		//if head is null (aka list is empty) make new node head
		if(head == null){
			//head and tail will both point to new node
			head = tail = new_node;
			//head's previous is null
			head.prev = null;
			//head's next is null
			head.next = null;
			return;
		}

		//if()

		//make last node's next equal new node
		tail.next = new_node;
		//make new node's prev the current tail
		new_node.prev = tail;
		//make tail the new node bc it's at the end
		tail = new_node;
		//make tail's next null
		tail.next = null;

	}

	public void deleteNode(Node del){
		if(head == null || del == null){
			return;
		}

		//if deleted node is head make it's next node the new head
		if(del == head){
			head = del.next;
		}

		//check that deleted node is not last node
		if(del.next != null){
			del.next.prev = del.prev;
		}

		//check that deleted node is not first node
		if(del.prev != null){
			del.prev.next = del.next;
		}

		del = null;

		return;
	}

	public void deleteNodeAtGivenPos(int n){
		if(head == null || n<=0){
			return;
		}

		Node curr_node = head;
		int i;

		for(i = 1; curr_node != null && i < n; i++){
			curr_node = curr_node.next;
		}

		if(curr_node == null){
			return;
		}

		deleteNode(curr_node);
		return;
	}


	public void printlist(){
		Node current = head;
		System.out.println("forward traversal");
		while(current != null){
			System.out.println(current.data + " ");
			current = current.next;
		}

		System.out.println();
		current = tail;
		System.out.println("backward traversal");
		while(current != null){
			System.out.println(current.data + " ");
			current = current.prev;
		}
		return;
	}


	// Driver code
    public static void main(String[] args)
    {
        /* Start with the empty list */
        DoublyLinkedList dll = new DoublyLinkedList();
 
        // Insert 6. So linked list becomes 6->NULL
        dll.append(6);
        //dll.printlist();
 
        // Insert 7 at the beginning. So
        // linked list becomes 7->6->NULL
        dll.push(7);
        //dll.printlist();
 
        // Insert 1 at the beginning. So
        // linked list becomes 1->7->6->NULL
        dll.push(1);
        
 
        // Insert 4 at the end. So linked
        // list becomes 1->7->6->4->NULL
        dll.append(4);
        

 
        // Insert 8, after 7. So linked
        // list becomes 1->7->8->6->4->NULL
        dll.InsertAfter(dll.head.next, 8);
         
        // Insert 5, before 8.So linked
        // list becomes 1->7->5->8->6->4
        dll.InsertBefore(dll.head.next.next, 5);
        dll.printlist();


        // delete node at the given position 'n'
        dll.deleteNodeAtGivenPos(2);
        System.out.println("Doubly linked "
                           +"list after deletion:");
        dll.printlist();
 
        System.out.println("Created DLL is: ");
        dll.printlist();
    }



}