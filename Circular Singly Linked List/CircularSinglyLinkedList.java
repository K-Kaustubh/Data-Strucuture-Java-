 import java.io.*;

 import java.util.Scanner;

 public class CircularSinglyLinkedList {

	 //Creation of a node
	 class Node{
		 int data;
		 Node next;
		 public Node(int d) {
			 this.data=d;
			 this.next=null;
		 }
	 }
	 Node tail=null;
	 
	 /* Add at first */
	 public void addFirst(int new_data)
	 {
		 Node new_node=new Node(new_data);
		 if(tail==null) { 				//if the list is empty
			 tail=new_node;
			 tail.next=tail;
		 }
		 else {							 //if the list is not empty
			 new_node.next=tail.next;
			 tail.next=new_node;
		 }
	 }
	 
	 /* Add at Last*/
	 public void addLast(int new_data)
	 {
		 Node new_node = new Node(new_data);
		 if(tail==null) { 						//if list is empty
			 tail=new_node;
			 tail.next=tail;
		 }
		 else { 								//if list is not empty
			 new_node.next=tail.next;
			 tail.next=new_node;
			 tail=new_node;						 //move tail to newly added node
		 }
	 }

	 public void addAfterKey(int new_data, int key) {
		 if (tail == null) { //if list is empty
			  System.out.println("Empty List");
			  return;
		 }
		 Node new_node=new Node(new_data); // Create new node and put in the data
		 Node curr = tail; //copy the tail node address in “curr” to traverse the list
		 do{
			 if(curr.data==key) { //node with given key is found
				 new_node.next=curr.next; //copy next node address to next of new node
				 curr.next=new_node; //add new node after current node
				 return;
			 }
			 curr=curr.next; //move to next node if key not found
		 } while (curr!= tail) ;
		 System.out.println("Key not found"); //if given key is not found in the list curr will reach to null.
	 }
	 
	 public void addBeforeKey(int new_data, int key) {
		 if (tail == null) { //if list is empty
			 System.out.println("Empty List");
			 return;
		 }
		 Node new_node=new Node(new_data); // Create new node and put in the data
		 Node curr = tail; //copy the tail node address in “curr” to traverse the list
		 do{
			 if(curr.next.data==key) { //node with given key is found
				 new_node.next=curr.next; //copy next node address to next of new node
				 curr.next=new_node; //add new node after current node
				 return;
			 }
			 curr=curr.next; //move to next node if key not found
		 } while (curr!= tail) ;
		 System.out.println("Key not found"); //if given key is not found in the list curr will reach to null.
	 }

	 public void removeKey(int key) {
		 if(tail==null) { //Empty List
			 System.out.println("Empty List! No key available for deletion"); return;
		 }
		 if(tail.next==tail && key==tail.data) { //if there is only one node and key matching
			 tail=null; return;
		 }
		 Node curr=tail;
		 do{ //traverse till 2nd last node
			 if(curr.next.data==key) { //if data of next node is same as key
				 curr.next=curr.next.next; return;
			 }
			 curr=curr.next; //move to next node if key not found
		 }while(curr.next!=tail); //till 2nd last node
		 if(curr.next.data==key) { //if key is present at tail node
			 curr.next=curr.next.next;
			 tail=curr; return; //move tail to point 2nd last node
		 }
	 }

	 public void printList(CircularSinglyLinkedList List) {
		 if(tail==null) {
			 System.out.print("Empty List");
			 return;
		 }
		 Node curr=tail.next; //Initialize curr with first node’s address
		 do{
			 System.out.print(curr.data+" "); //print data of current node
			 curr=curr.next; //move curr to next node
		 } while(curr!=tail.next) ; //loop terminates when curr again reaches to first node
	 }
	 
	 /* Add at any position */
	 public void addAtPosition(int new_data, int pos) {
		 if(pos<1) return; //the first valid position is 1
		 Node new_node = new Node(new_data); // Create new node and put in the data
		 if (tail == null ) { //if list is empty
			 if(pos!=1) //position is not 1 , invalid position , exit from the function
				 return;
			 else{
				 tail = new_node; //make the new node as head node
				 return;
			 }
		 }
		 if(pos==1){
			 new_node.next = tail.next; // Copy Current head to next of new Node as head
			 tail.next = new_node; //move head to point new node
		 }
		 else{
			 Node curr = tail.next; //copy the head node address in “curr” to traverse the list
			 int i=1;
			 while (i<pos-1) {
				 curr = curr.next; //move curr to next till finding the correct node
				 i++;
			 }
			 new_node.next=curr.next; //copy the next of current node to next of new_node
			 curr.next = new_node; //make the next of current node as new node
		 }
		 return;
	 }

	 public void searchKey(int key) {
		 if(tail==null) {
			 System.out.println("Empty List"); return;
		 }
		 if(tail.data==key) { //if key is found at tail node then return
			 System.out.println("Search Successfull at last position"); return;
		 }
		 int pos=1;
		 Node curr=tail.next; //if key is not found at tail node then start with first node
		 while(curr!=tail) {
			 if(curr.data==key) {
				 System.out.println("Search Successfull at position"+pos); return;
			 }
			 curr=curr.next;
			 pos++;
		 }
		 System.out.println("Search Unsuccessfull");
		 return;
	 }

	 public void next(CircularSinglyLinkedList li) {
		 Node curr=tail;
		 int tmp=curr.data;
		 while(curr.next!=null) {
			 curr.data=curr.next.data;
			 curr=curr.next;
		 }
		 curr.data=tmp;
	 }
	 public static void main(String[] args) {
		 // TODO Auto-generated method stub
		 CircularSinglyLinkedList SLL=new CircularSinglyLinkedList(); //create a new singly linked list

		 System.out.println("Welcome to Circular Singly Linked List Implementation");
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