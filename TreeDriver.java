package AIML;

public class TreeDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Creating Tree");
		BTree tree = new BTree();
		System.out.println("Count nodes in empty tree");
		System.out.println(tree.countNodes());
		System.out.println("Creat Nodes with data 1");
		Node root = new Node(1);
		System.out.println("Set node as root");
		tree.setRoot(root);
		System.out.println("Count nodes in tree with only root added");
		System.out.println(tree.countNodes());
		
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
        
        System.out.println("Set the current node to be the root");
        tree.setCurrent(tree.getRoot());
        
        System.out.println("Display the current node");
        System.out.println(tree.getCurrent().getData());
        
        Node currentNode = tree.getCurrent();
        
        System.out.println("Count nodes in tree with 7 nodes added");
        System.out.println(tree.countNodes());
        
        System.out.println("\nDisplay the nodes as tree diagram");
        tree.print();

        System.out.println("In Order print");
        tree.printInorder();
        System.out.println("\nPre order print");
        tree.printPreOrder();
        System.out.println("\nPost order print");
        tree.printPostOrder();
	}

}
