package AIML;

public class NodeDriver {

	public NodeDriver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(25);
	      Node node15 = new Node(15);
	      Node node50 = new Node(50);
	      Node node10 = new Node(10);
	      Node node4 = new Node(4);
	      Node node12 = new Node(12);
	      Node node22 = new Node(22);
	      Node node18 = new Node(18);
	      Node node24 = new Node(24);
	      Node node35 = new Node(35);
	      Node node31 = new Node(31);
	      Node node44 = new Node(44);
	      Node node70 = new Node(70);
	      Node node66 = new Node(66);
	      Node node90 = new Node(90);
	      
	      root.setLeft(node15);
	      node15.setLeft(node10);
	      node10.setLeft(node4);
	      node10.setRight(node12);
	      node15.setRight(node22);
	      node22.setLeft(node18);
	      node22.setRight(node24);
	      root.setRight(node50);
	      node50.setLeft(node35);
	      node35.setLeft(node31);
	      node35.setRight(node44);
	      node50.setRight(node70);
	      node70.setLeft(node66);
	      node70.setRight(node90);
	      
	    //tree traversal  
	    System.out.print("Inorder Traversal = ");
	    root.printInorder(root);
        System.out.println();
        System.out.print("Postorder Traversal = ");
	    root.printPostorder(root);
	    System.out.println();
	    System.out.print("Preorder Traversal = ");
	    root.printPreorder(root);
        System.out.println();
        
        System.out.println();
        root.print();
	}

}
