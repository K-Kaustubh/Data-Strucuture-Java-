import java.io.*;
import java.util.*;

public class SinglyLinkedList {

 //Creation of a node
	class Node{
	 
	 int data;
	 Node next;
	 
	 	public Node(int d) {

		 	this.data=d;
		 	this.next=null;
	 	}
	}
Node head=null;

	//Insert at front   
	public void addFirst(int new_data) {

		Node new_node=new Node(new_data); 										// Create new node and put in the data
		new_node.next = head;													 // Copy Current head to next of new Node as head
		head = new_node;															 //Move the head to point to new Node
		return;
	}
	//Insert at last   
	public void addLast(int new_data) {

		Node new_node=new Node(new_data); 									// Create new node and put in the data
		if (head == null) { 												//if list is empty
			head = new_node;												 //make the new node as head node
			return;
		}
		Node curr = head; 													//copy the head node address in “curr” to traverse the list
		while (curr.next != null)
		curr = curr.next;													 //move curr to next till finding the last node
		curr.next = new_node; 												//add new node at end
		return;
	}

	public void addAfterKey(int new_data, int key) {
		
		Node new_node=new Node(new_data); 									// Create new node and put in the data
		if (head == null) { 												//if list is empty
			System.out.println("Empty List");
			return;
		}
		Node curr = head;													 //copy the head node address in “curr” to traverse the list
		while (curr!= null) {
			if(curr.data==key) { 											//node with given key is found
				new_node.next=curr.next;										 //copy next node address to next of new node
				curr.next=new_node;												 //add new node after current node
				return;
			}
			curr=curr.next; 												//move to next node if key not found
		}
		System.out.println("Key not found");
	}

	public void addBeforeKey(int new_data, int key) {
		
		if(head == null) { 													//if list is empty
			System.out.println("Empty List");
			return;
		}
		Node new_node=new Node(new_data); 									// Create new node and put in the data
		if(key==head.data){ 												//if key is the first node
			new_node.next=head;
			head=new_node; 													//add at first
			return;
		}
		Node curr = head;													 //copy the head node address in “curr” to traverse the list
		while (curr.next!= null) {
			if(curr.next.data==key) {										 //node with given key is found
				new_node.next=curr.next;									 //copy next node address to next of new node
				curr.next=new_node;											 //add new node after current node
				return;
			}
			curr=curr.next;													//move to next node if key not found
		}
		return;
	}

	public void removeKey(int key) {
		
		if(head==null) { 													//Empty List
			System.out.println("Empty List!No key available for deletion");
			return;
		}
		if(key==head.data) {												 //key if the first node
			head=head.next;
			return;
		}
		Node curr=head;
		while(curr.next!=null) { 											//traverse till 2nd last node
			if(curr.next.data==key) {										 //if data of next node is same as key
				curr.next=curr.next.next;
				return;
			}
			curr=curr.next;													 //move to next node if key not found
		}
	}

	public void printList(SinglyLinkedList List) {
		
		Node curr=head;
		if(head==null) {
			System.out.print("Empty List");
			return;
		}
		while(curr!=null) {
			System.out.print(curr.data+" ");
			curr=curr.next;
		}
		System.out.println();
	}
	
 /* Add at any position */
	public void addAtPosition(int new_data, int pos) {
		
		if(pos<1) return; 												//the first valid position is 1
		Node new_node = new Node(new_data);									 // Create new node and put in the data
		if (head == null ) { 											//if list is empty
			if(pos!=1) 													//position is not 1 , invalid position , exit from the function
				return;
			else{
				head = new_node;										 //make the new node as head node
				return;
			}
		}
		if(pos==1){
			new_node.next = head;										 // Copy Current head to next of new Node as head
			head = new_node; 												//move head to point new node
		}
		else{
			Node curr = head; 												//copy the head node address in “curr” to traverse the list
			int i=1;
			while (i<pos-1) {
				curr = curr.next;														 //move curr to next till finding the correct node
				i++;
			}
			new_node.next=curr.next; 										//copy the next of current node to next of new_node
			curr.next = new_node; 											//make the next of current node as new node
		}
		return;
	}

	public void searchKey(int key) {
		
		if(head==null) {
			System.out.println("Empty List");
			return;
		}
		int pos=1;
		Node curr=head;
		while(curr!=null) {
			if(curr.data==key) {
				System.out.println("Search Successfull at position"+pos);
				return;
			}
			curr=curr.next;
			pos++;
		}
		System.out.println("Search Unsuccessfull");
		return;
	}
	
	public void next(SinglyLinkedList li) {
		
		Node curr=head;
		int tmp=curr.data;
		while(curr.next!=null) {
			curr.data=curr.next.data;
			curr=curr.next;
		}
		curr.data=tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SinglyLinkedList SLL=new SinglyLinkedList(); //create a new singly linked list
		System.out.println("Welcome to Singly Linked List Implementation");
		while(true) {
			System.out.println();
			System.out.println("***List of operation to be performed***");
			System.out.println("1.Addition At First");
			System.out.println("2.Addition At Last");
			System.out.println("3.Addition At Any Position");
			System.out.println("4.Addition After a given Key");
			System.out.println("5.Addition Before a given Key");
			System.out.println("6.Deletion of a given key");
			System.out.println("7.Search a Key");
			System.out.println("8.Display the list");
			System.out.println("9.Exit");
			System.out.println("Enter your selected option");
			
			Scanner sc=new Scanner(System.in);
			int op=sc.nextInt();
			
			switch(op) {
			case 1:System.out.println("Enter the value to be entered");
			SLL.addFirst(sc.nextInt());
			break;
			
			case 2:System.out.println("Enter the value to be entered");
			SLL.addLast(sc.nextInt());
			break;
			
			case 3:System.out.println("Enter the value to enter and position");
			SLL.addAtPosition(sc.nextInt(),sc.nextInt());
			break;
			
			case 4:System.out.println("Enter the value to enter and key after which to insert");
			SLL.addAfterKey(sc.nextInt(),sc.nextInt());
			break;
			
			case 5:System.out.println("Enter the value to enter and key before which to insert");
			SLL.addBeforeKey(sc.nextInt(),sc.nextInt());
			break;
			
			case 6:System.out.println("Enter the value to be deleted");
			SLL.removeKey(sc.nextInt());
			break;

			case 7:System.out.println("Enter the value to be searched");
			SLL.searchKey(sc.nextInt());
			break;

			case 8:SLL.printList(SLL);
			break;

			case 9:SLL.next(SLL);
			break;
			
			case 10:return;	
			}		
		}
	}
}
