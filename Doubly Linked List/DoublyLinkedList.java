import java.util.Scanner;

public class DoublyLinkedList {
	class Node{
		
		int data;
		Node next;
		Node prev;
		public Node(int d) {
			this.data=d;
			this.next=null;
			this.prev=null;
	}
}

	Node head=null;
	Node Prev=null;

	/* Add at first */
	
	public void addFirst(int new_data)
	{
		Node new_node = new Node(new_data);
		new_node.prev = null; 					//Assign newNode’s previous pointer to be null
		new_node.next = head; 					//Assign newNode’s next pointer to current head

		// List is empty

		if(head == null)
			head = new_node;
		else
			head.prev = new_node;
		head = new_node;
	}

		/* Add at Last*/

	public void addLast(int new_data)
	{
		Node new_node = new Node(new_data);
		new_node.prev = null;
		new_node.next = null;
		
		if (head == null)							 //if list is empty
		{
			new_node.next=head;
			head = new_node; 						//make the new node as head node
			return;
		}
		Node curr = head;
		while (curr.next != null)
			curr = curr.next;
		curr.next = new_node;
		new_node.prev = curr;
		return;
	}

	public void addAfterKey(int new_data, int key) {
		
		if (head == null) {
			System.out.println("Empty List");
			return;
		}
		Node new_node=new Node(new_data);
		Node curr = head;
		while (curr!= null) {
			if(curr.data==key) { 						//node with given key is found
				new_node.next=curr.next;
				curr.next.prev=new_node;
				curr.next=new_node; 					//add new node after current node
				new_node.prev=curr;
				return;}
			curr=curr.next; 							//move to next node if key not found
		}
		System.out.println("Key not found");
	}


	public void addBeforeKey(int new_data, int key) {
		
		if(head == null) {								 //if list is empty
			System.out.println("Empty List");
			return;
		}
		
		Node new_node=new Node(new_data);
		if(key==head.data){								//if key is the first node
			new_node.next=head;
			head.prev = new_node;
			head=new_node;									 //add at first
			return;
		}
		Node curr = head;
		while (curr.next!= null) {
			if(curr.next.data==key) { 						//node with given key is found
				new_node.next=curr.next;
				curr.next.prev=new_node;
				curr.next=new_node;
				new_node.prev=curr;
				return;
			}
			curr=curr.next;										 //move to next node if key not found
		}
	}

	public void removeKey(int key) {

		if(head==null) {
			System.out.println("Empty List!No key available for deletion");
			return;
		}
		if(key==head.data) {
			head=head.next;
			head.prev= null;
			return;
		}
		Node curr=head;
		while(curr.next!=null) {
			if(curr.next.data==key) {
				curr.next=curr.next.next;
				curr.next.prev = curr;
				return;
			}
			curr=curr.next;
		}
	}



	public void printList(DoublyLinkedList List) { 					//pass the list object as argument

		Node curr=List.head; 										//copy head node address in curr
		while(curr!=null) { 										//traverse the list till reaching null
			System.out.print(curr.data+" "); 						//print data at node
			curr=curr.next; 									//move to next node
		}
	}

	/* Add at any position */
	
	public void addAtPosition(int new_data, int pos) {
		if(pos<1) return; 										//the first valid position is 1
		Node new_node = new Node(new_data);
		if (head == null ) { 									//if list is empty
			if(pos!=1) return;
			else{
				new_node.next=head;
				head = new_node; 								//make the new node as head node
				return;
			}
		}
		if(pos==1){
			new_node.next = head;
			head.prev=new_node;
			head = new_node; 									//move head to point new node
		}
		else{
			Node curr = head;
			int i=1;
			while (i<pos-1){
				curr = curr.next; 								//move curr to next till finding the correct node
				i++;
			}
			new_node.next=curr.next; 							//copy the next of current node to next of new_node
			curr.next.prev=new_node;
			curr.next = new_node; 								//make the next of current node as new node
			new_node.prev=curr;
		}
		return;

 }

	public void searchKey(int key) {

		if(head==null) { 										//Empty List Checking
			System.out.println("Empty List");
			return;
		}
		Node curr=head;
		while(curr!=null) {										//traversal of list till last
			if(curr.data==key) {
				System.out.println("Search Successful");
				return;
			}
			curr=curr.next;
		}
		System.out.println("Search Unsuccessfull");
		return;
	}

	public void next(DoublyLinkedList li) {

		Node curr=head;
		int tmp=curr.data;
		while(curr.next!=null) {
			curr.data=curr.next.data;
			curr=curr.next;
		}
		curr.data=tmp;
	}

	public static void main(String[] args) {
		DoublyLinkedList DLL=new DoublyLinkedList(); //create a new singly linked list
		System.out.println("Welcome to Doubly Linked List Implementation");
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
			 DLL.addFirst(sc.nextInt());
			 break;
			 
			 case 2:System.out.println("Enter the value to be entered");
			 DLL.addLast(sc.nextInt());
			 break;

			 case 3:System.out.println("Enter the value to enter and position");
			 DLL.addAtPosition(sc.nextInt(),sc.nextInt());
			 break;

			 case 4:System.out.println("Enter the value to enter and key after which to insert");
			 DLL.addAfterKey(sc.nextInt(),sc.nextInt());
			 break;

			 case 5:System.out.println("Enter the value to enter and key before which to insert");
			 DLL.addBeforeKey(sc.nextInt(),sc.nextInt());
			 break;

			 case 6:System.out.println("Enter the value to be deleted");
			 DLL.removeKey(sc.nextInt());
			 break;

			 case 7:System.out.println("Enter the value to be searched");
			 DLL.searchKey(sc.nextInt());
			 break;

			 case 8:DLL.printList(DLL);
			 break;

			 case 9:DLL.next(DLL);
			 break;
			 
			 case 10:return;
			 }
			 
		}

	}

}