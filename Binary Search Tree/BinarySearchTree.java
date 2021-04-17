import java.util.Scanner;

public class BinarySearchTree {
/* Class containing left and right child of current node and key value*/
	    class Node {
	        int key;
	        Node left, right;
	 
	        public Node(int item)
	        {
	            key = item;
	            left = right = null;
	        }
	    }
	 	    // Root of BST
	  static Node root= null;
	  
	    /* A recursive function to delete an existing key in BST*/
	    Node deleteKey(Node root, int key)
	    {
	        /* Base Case: If the tree is empty */
	        if (root == null)
	            return root;
	 
	        /* Otherwise, recur down the tree */
	        if (key < root.key)
	            root.left = deleteKey(root.left, key);
	        else if (key > root.key)
	            root.right = deleteKey(root.right, key);
	 
	        // if key is same as root's 
	        // key, then This is the
	        // node to be deleted
	        else {
	            // node with only one child or no child
	            if (root.left == null)
	                return root.right;
	            else if (root.right == null)
	                return root.left;
	 
	            // node with two children: Get the inorder
	            // successor (smallest in the right subtree)
	          //  root.key = minValue(root.right);
	            Node succ = root.right;
		        while (succ.left != null) 
		        {
		            succ = succ.left;
		            //root = root.right.left;
		        }
	            // Delete the inorder successor
		        root.key= succ.key;
	            root.right = deleteKey(root.right, succ.key);
	        }
	 
	        return root;
	    }
	 
	     
	    /* A recursive function to 
	       insert a new key in BST */
	    Node insert(Node root, int key)
	    {
	 
	        /* If the tree is empty,
	          return a new node */
	        if (root == null) {
	            root = new Node(key);
	           return root;
	        }
	 
	        /* Otherwise, recur down the tree */
	        if (key < root.key)
	            root.left = insert(root.left, key);
	        else if (key > root.key)
	            root.right = insert(root.right, key);
	 
	        /* return the (unchanged) node pointer */
	        return root;
	    }
	 
	    // search
	    static void search (Node root, int key)
	    {
	    		if (root == null) {
	           
	           System.out.println("Not found");
	           return ;
	        }
	         
	        if (key == root.key)
               System.out.println("Search successfull");
	        else if (key < root.key)
	            search(root.left, key);
	        else // (key > root.key)
	            search(root.right, key);
	        
	        	
	        	
	    }
	    // A utility function to do inorder traversal of BST
	    void inorder(Node root)
	    {
	        if (root != null) {
	            inorder(root.left);
	            System.out.print(root.key + " ");
	            inorder(root.right);
	        }
	    }
	    // A utility function to do preorder traversal of BST
	    void preorder(Node root)
	    {
	        if (root != null) {
	            
	            System.out.print(root.key + " ");
	            preorder(root.left);
	            preorder(root.right);
	        }
	    }
	    // A utility function to do postorder traversal of BST
	    void postorder(Node root)
	    {
	        if (root != null) {
	            postorder(root.left);
	            postorder(root.right);
	            System.out.print(root.key + " ");
	        }
	    }
	 
	    
	    
	    // Driver Code

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree tree = new BinarySearchTree();
		System.out.println("Welcome to BST Linked List Implementation");
		while(true) {
			System.out.println();
			System.out.println("***List of operation to be performed***");
			System.out.println("1.Insertion");
			System.out.println("2.Deletion");
			System.out.println("3.Search");
			System.out.println("4.Inorder Traversal");
			System.out.println("5.Preorder Traversal");
			System.out.println("6.Post order Traversal");
			
			System.out.println("7.Exit");
			
			System.out.println("Enter your selected option");
			
		    Scanner sc=new Scanner(System.in);
		    int op=sc.nextInt();
		    
		    switch(op) {
		    case 1:System.out.println("Enter the value to be entered");
		    		root = tree.insert(root, sc.nextInt());
		    	   break;
		    case 2:System.out.println("Enter the value to be deleted");
		    	root = tree.deleteKey(root,sc.nextInt());
	    	       break;
		    case 3:System.out.println("Enter the value to search");
	    	       search(root,sc.nextInt());
	    	       break;
		    case 4: System.out.println(
		            "Inorder traversal of the given tree");
		    	tree.inorder(root);
 	               break;
		    case 5:System.out.println(
		            "Preorder traversal of the given tree");
		    	tree.preorder(root);
                   break;
		    case 6:System.out.println(
		            "Postorder traversal of the given tree");
		    	tree.postorder(root);
                   break;
		    case 7:System.exit(0);
		            return; 
		  
		    }
	}       
      
    }
	

}
