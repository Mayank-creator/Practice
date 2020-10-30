package com.test.client;

public class BinaryTree {
	Node root;

	class Node {
		int key;
		Node left;
		Node right;

		Node(int key) {
			this.key = key;
			this.left = this.right = null;
		}
	}

	/**
	 * insert value in Binary tree
	 * 
	 * @param key
	 * @return Nodew
	 */
	public void insert(int key) {
		root = insertRec(root, key);
	}

	private Node insertRec(Node root, int key) {

		if (root == null) {
			root = new Node(key);
			return root;
		}
		if (key < root.key) {
			root.left = insertRec(root.left, key);
		} else if (key > root.key) {
			root.right = insertRec(root.right, key);
		}
		return root;
	}

	/**
	 * Inorder traversal
	 */
	public void inorderTraversal() {
		inorderTraversal(root);
	}

	private void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.println(root.key);
			inorderTraversal(root.right);
		}
	}

	public static void main(String... args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(50);
		binaryTree.insert(30);
		binaryTree.insert(70);
		binaryTree.inorderTraversal();
	}
}
