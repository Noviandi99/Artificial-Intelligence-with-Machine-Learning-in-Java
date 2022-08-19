package AIML;

public class InorderTree {
	Node node;

	public InorderTree() {
		// TODO Auto-generated constructor stub
	}
	void TraversalInorder(Node root) {
		Node current, pre;
		if (root==null)
			return;
		current = root;
		while (current != null) {
			if(current.left == null)
			{
				System.out.print(current.data+ " ");
				current = current.right;
			} else
			{
				pre = current.left;
				while (pre.right != null && pre.right != current)
					pre = pre.right;
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				}
				else
				{
					pre.right = null;
					System.out.print(current.data+ " ");
					current = current.right;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		InorderTree tree = new InorderTree();
		tree.node = new Node(1);
		tree.node.setLeft(new Node(2));
		tree.node.setRight(new Node(3));
		tree.node.left.setLeft(new Node(4));
		tree.node.left.setRight(new Node(5));
		tree.node.right.setLeft(new Node(6));
		tree.node.right.setRight(new Node(7));

		
		tree.TraversalInorder(tree.node);
	}

}
