package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	private Node rootNode;
	
	private class Node {
		Node leftNode;
		Node rightNode;
		int data;
		
		public Node(int data) {
			// TODO Auto-generated constructor stub
			leftNode = null;
			rightNode = null;
			this.data = data;
		}
		
	}
	
	public BinaryTree() {
		// TODO Auto-generated constructor stub
		rootNode = null;
	}
	
//	�ݹ鴴��������-����1
	public void buildTree(Node node,int data) {
		if(rootNode == null) {
			rootNode = new Node(data);
		}else {
			if(data<node.data) {
				if(node.leftNode == null) {
					node.leftNode = new Node(data);
				}else {
					buildTree(node.leftNode,data);
				}
			}else {
				if (data>node.data) {
					if (node.rightNode == null) {
						node.rightNode = new Node(data);
					}else {
						buildTree(node.rightNode, data);
					}
				}
			}
		}
		
	}
	
//	�ݹ鴴��������-������
	public void insert(int data) {
		insertNode(rootNode,data);
		
	}
	
	public void insertNode(Node node,int data) {
		if(node == null) {
			node = new Node(data);
		}else if (data<node.data) {
			insertNode(node.leftNode, data);
		}else {
			insertNode(node.rightNode, data);
		}
	}
	
//	�ݹ���ҽ��
	public Node findNode(Node node,int data) {
		if(rootNode == null) {
			return null;
		}else {
			if(data == node.data) {
				return node;
			}else if (data<node.data) {
				return findNode(node.leftNode, data);
			}else {
				return findNode(node.rightNode, data);
			} 
		}
	}
	
//	�ǵݹ����
	public Node findNode2(int data) {
		Node nowNode = rootNode;
		while (nowNode != null) {
			if(data == nowNode.data) {
				return nowNode;
			}else if (data<nowNode.data) {
				nowNode = nowNode.leftNode;
			}else {
				nowNode = nowNode.rightNode;
			}
		}
		return null;
	}
	
//	ǰ��ݹ����
	public void preOrder(Node node) {
		if(node != null) {
			System.out.println(node.data);
			preOrder(node.leftNode);
			preOrder(node.rightNode);
		}
	}
	
//	ǰ��ǵݹ����
	
	public void preOrder2() {
		if(rootNode == null) {
			return;
		}
		Node p = rootNode;
		Stack<Node> stack = new Stack<Node>();
		stack.push(p);
		while (stack.isEmpty() != true) {
			p = stack.pop();
			System.out.println(p.data);
			if (p.rightNode != null) {
				stack.push(p.rightNode);
			}
			if (p.leftNode != null) {
				stack.push(p.leftNode);
			}
		}
	}
	
//	����ݹ����
	public void inOrder(Node node) {
		if (node != null) {
			inOrder(node.leftNode);
			System.out.println(node.data);
			inOrder(node.rightNode);
		}
	}
	
//	����ǵݹ����
	public void inOrder2() {
		if (rootNode == null) {
			return;
		}
		Node nowNode = rootNode;
		Stack<Node> stack = new Stack<Node>();
		while (stack.isEmpty() != true||nowNode != null ) {
			if(nowNode != null) {
				stack.push(nowNode);
				nowNode = nowNode.leftNode;
			}else {
				nowNode = stack.pop();
				System.out.println(nowNode.data);
				nowNode = nowNode.rightNode;
			}
			
		}
		
	}
	
//	����ݹ����
	public void posOrder(Node node) {
		if (node != null) {
			posOrder(node.leftNode);
			posOrder(node.rightNode);
			System.out.println(node.data);
		}
		
	}
	
//	�������
	public void levelorder() {
		if(rootNode == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		Node nowNode = rootNode;
		queue.add(nowNode);
		while (queue.isEmpty() != true) {
			nowNode = queue.remove();
			System.out.println(nowNode.data);
			if (nowNode.leftNode != null) {
				queue.add(nowNode.leftNode);
			}
			if (nowNode.rightNode != null) {
				queue.add(nowNode);
			}
		}
	}
	
//	������������
	public int findDeep(Node node) {
		if(node == null) {
			return 0;
		}
		int leftdeep = findDeep(node.leftNode)+1;
		int rightdeep = findDeep(node.rightNode)+1;
		return Math.max(leftdeep, rightdeep);
		
	}
	
	public static void main(String[] args) {
		int[] arr = {2,11,3,8,90,11,6};
		BinaryTree tree = new BinaryTree();
		for(int element:arr) {
//			tree.buildTree(tree.rootNode, element);
			tree.insert(element);
		}
		tree.preOrder(tree.rootNode);
		tree.inOrder(tree.rootNode);
		tree.posOrder(tree.rootNode);
		tree.levelorder();
		tree.preOrder2();
		tree.inOrder2();
		int deep = tree.findDeep(tree.rootNode);
		Node node = tree.findNode(tree.rootNode, 8);
		Node node2 = tree.findNode2(8);
	}

}
