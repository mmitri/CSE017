import java.util.ArrayList;
/**
 * Generic class BST
 * Implementation of the Binary Search Tree data structure
 * @author Houria Oudghiri
 * Data of creation: December 10, 2021
 * @param <E> implements the interface Comparable
 */
public class BST<E extends Comparable<E>> {
	private TreeNode root;
	private int size;
	/**
	 * Inner class TreeNode
	 * Attributes of the node
	 */
	private class TreeNode{
		E value;
		TreeNode left;
		TreeNode right;
		TreeNode(E val){
			value = val;
			left = right = null;
		}
	}
	/**
	 * Default Constructor
	 * creates an empty BST
	 */
	public BST(){
	     root = null;
	     size = 0; 
	}
	/**
	 * Method that returns the size of the BST
	 * @return The number of nodes in the BST
	 */
	public int size() {
	  return size; 
	}
	/**
	 * Predicate to indicate if the BST is empty
	 * @return true is the BST is empty
	 */
	public boolean isEmpty() {
	    return (size == 0); 
	}
	/**
	 * Method to clear the BST
	 */
	public void clear() {
	    root = null; size=0;
	}
	/**
	 * Search method in the BST
	 * @param item: value being searched
	 * @return true if item is found in the BST
	 *         comparison made using compareTo()
	 */
	public boolean contains(E item) {
		TreeNode node = root;
		while (node != null) {
			if(item.compareTo(node.value) < 0)
				node = node.left;
			else if (item.compareTo(node.value)> 0)
				node = node.right;
			else
				return true;
		}
		return false;
	}
	
	/**
	 * Method to add a new node to the BST
	 * @param item value of the node to be added to the BST
	 * @return true is new node added successfully, 
	 *         false if there is already a node with value item
	 */
	public boolean add(E item) {
		if (root == null)
			root = new TreeNode(item);
		else {
			TreeNode parent, node;
			parent = null; node = root;
			while (node != null) {
				parent = node;
				if(item.compareTo(node.value) < 0) {
					node = node.left; }
				else if (item.compareTo(node.value) > 0) {
					node = node.right; }
				else
					return false;
			}
			if (item.compareTo(parent.value)< 0)
				parent.left = new TreeNode(item);
			else
				parent.right = new TreeNode(item);
		}
		size++;
		return true; 
	}
	/**
	 * Method to remove a node from the BST
	 * @param item value of the node to be removed
	 * @return true if the node with the value equal to item
	 *         is found and removed, false otherwise
	 */
	public boolean remove(E item) {
		TreeNode parent, node;
		parent = null;
		node = root;
		while (node != null) {
			if (item.compareTo(node.value) < 0) {
				parent = node;
				node = node.left;
			} else if (item.compareTo(node.value) > 0) {
				parent = node;
				node = node.right;
			} else
				break;
		}
		if (node == null) // item not in the tree
			return false;
		// Case 1: node has no children
		if (node.left == null && node.right == null) {
			if (parent == null) {
				root = null;
			} else {
				changeChild(parent, node, null);
			}
		}
		//case 2: one right child
		else if (node.left == null) {
			if (parent == null) {
				root = node.right;
			} else {
				changeChild(parent, node, node.right);
			}
		}
		//case 2: one left child
		else if (node.right == null) {
			if (parent == null) {
				root = node.left;
			} else {
				changeChild(parent, node, node.left);
			}
		}
		//Case 3: node has two children
		else {
			TreeNode rightMostParent = node;
			TreeNode rightMost = node.left;
			while (rightMost.right != null) {
				rightMostParent = rightMost;
				rightMost = rightMost.right;
			}
			node.value = rightMost.value;
			changeChild(rightMostParent, rightMost, rightMost.left);
		}
		size--;
		return true;
	}
	/**
	 * Private method used by the method remove
	 * Replaces node, the child of parent, with newChild
	 * @param parent: the parent of node
	 * @param node: the child of parent to be replaced
	 * @param newChild: the new child of parent
	 */
	private void changeChild(TreeNode parent, 
							 TreeNode node, 
							 TreeNode newChild) {
		if (parent.left == node)
			parent.left = newChild;
		else
			parent.right = newChild;
	}
	/**
	 * Method to traverse the BST using inorder traversal
	 * Prints the nodes of BST inorder
	 */
	public void inorder() {
		inorder(root);
	}
	/**
	 * Recursive helper method for inorder method
	 * @param node: current node in the BST
	 */
	private void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.value + " ");
			inorder(node.right);
		}
	}
	/**
	 * Method to traverse the BST using preorder traversal
	 * Prints the nodes of BST in preorder
	 */
	public void preorder() {
		preorder(root);
	}
	/**
	 * Recursive helper method for preorder method
	 * @param node: current node in the BST
	 */
	private void preorder(TreeNode node) {
		if (node != null) {
			System.out.print(node.value + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}
	/**
	 * Method to traverse the BST using postorder traversal
	 * Prints the nodes of BST in postorder
	 */
	public void postorder() {
		postorder(root);
	}
	/**
	 * Recursive helper method for postorder method
	 * @param node: current node in the BST
	 */
	private void postorder(TreeNode node)  {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.value + " ");	
		}
	}
	/**
	 * Search method in the BST
	 * @param item: value being searched
	 * @return value of the node that has the value item
	 *         null if no node with value item is found
	 */
	 public E find(E item) {
		return find(item, root);
	}
	public E find(E item, TreeNode node) {
		if (node != null) {
			if(item.compareTo(node.value) < 0)
				return find(item, node.left);
			else if (item.compareTo(node.value)> 0)
				return find(item, node.right);
			else
				return node.value;
		}
		return null;
	}
	
	/**
	 * Method to return the values of the BST nodes
	 * in an array list using the inorder traversal
	 * @return array list that contains the values of the BST nodes
	 * Complexity = O()
	 */
	public ArrayList<E> toList(TreeNode node){
		if(node != null){
			inorder(node.left);
			System.out.println(node.value + " ");
			inorder(node.right);
		}
		return null;
	}
}

