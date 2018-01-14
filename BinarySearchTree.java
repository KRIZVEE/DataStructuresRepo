import java.util.Scanner;

class Node {
	Node left, right;
	int data;

	Node(int value) {
		this.data = value;
	}
}

// Class BST for insert, search, minValue, maxValue, PreOrder, InOrder,
// PostOrder
class BST {

	Node root;

	public void insert(int item) {
		Node newNode = new Node(item);
		if (root == null) {
			root = newNode;
		} else {
			Node ptr = root;
			Node parent;
			while (true) {
				parent = ptr;
				if (item < ptr.data) {
					ptr = ptr.left;
					if (ptr == null) {
						parent.left = newNode;
						break;
					}
				} else {
					ptr = ptr.right;
					if (ptr == null) {
						parent.right = newNode;
						break;
					}
				}

			}
		}
		System.out.println("ELement Inserted Successfully.....");

	}

	public void search(int key) {
		Node ptr = root;
		while (ptr != null) {
			if (key == ptr.data) {
				System.out.println("Element found");
				break;
			} else if (key <= ptr.data) {
				ptr = ptr.left;
			} else {
				ptr = ptr.right;
			}
		}
		if (ptr == null) {
			System.out.println("Element not found");
		}
	}

	public void minValue() {
		Node ptr = root, parent = ptr;
		while (ptr != null) {
			parent = ptr;
			ptr = ptr.left;
		}
		System.out.println("The minimum value is : " + parent.data);
	}

	public void maxValue() {
		Node ptr = root, parent = ptr;
		while (ptr != null) {
			parent = ptr;
			ptr = ptr.right;
		}
		System.out.println("The maximum value is : " + parent.data);
	}

	public void preOrderTraversal(Node node) {

		if (node != null) {
			System.out.print(node.data + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}

	}

	public void inOrderTraversal(Node node) {

		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.data + " ");
			inOrderTraversal(node.right);
		}

	}

	public void postOrderTraversal(Node node) {

		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.data + " ");
		}

	}

}

public class BinarySearchTree {

	public static void main(String[] args) {
		BST objBST = new BST();
		Scanner sc = new Scanner(System.in);
		int option, insertionElement, searchElement;
		// String ch ="";
		System.out.println("Implementation of a Binary Search Tree");
		do {
			System.out.println(" 1. Insertion\n" + " 2. Search\n" + " 3. MinValue\n" + " 4. MaxValue\n"
					+ " 5. PreOrder Traversal\n" + " 6. InOrder Traversal\n" + " 7. PostOrder Traversal\n "
					+ "8. EXIT ");
			System.out.println("Please select one of the above given options. ");
			option = sc.nextInt();

			switch (option) {
			case 1:
				System.out.println("Please enter element to be inserted");
				insertionElement = sc.nextInt();
				objBST.insert(insertionElement);
				break;

			case 2:
				System.out.println("Please enter element to be searched");
				searchElement = sc.nextInt();
				objBST.search(searchElement);
				break;

			case 3:
				objBST.minValue();
				break;

			case 4:
				objBST.maxValue();
				break;

			case 5:
				System.out.println("The PreOrderTraversal of a Binary Search tree is as follow :");
				objBST.preOrderTraversal(objBST.root);
				break;

			case 6:
				System.out.println("The InOrderTraversal of a Binary Search tree is as follow :");
				objBST.inOrderTraversal(objBST.root);
				break;

			case 7:
				System.out.println("The PostOrderTraversal of a Binary Search tree is as follow :");
				objBST.postOrderTraversal(objBST.root);
				break;

			case 8:
				System.out.println("Thank You, see you again");
				break;

			default:
				break;
			}
			// System.out.println("Do you want");
		} while (option != 8);

	}
}
