/**
 * 
 */
package com.bits.daa;

/**
 * @author MMaddikera
 * Given two BSTs, check whether the elements of them are the same or not
 *
 */
public class TwoIdenticalBST {

	public static void main(String args[]){
		  //Two BSTs with data 10 5 20 15 30 and 10 20 15 30 5 should return true 
		  //and the dataset with 10 5 20 15 30 and 10 5 30 20 5 should return false. 
		  //Note: BSTs data can be in any order.
		BST a = new BST();
		a.insert(10);
		a.insert(5);
		a.insert(20);
		a.insert(15);
		a.insert(30);
/*		BST b = new BST();
		b.insert(10);
		b.insert(20);
		b.insert(15);
		b.insert(30);
		b.insert(5);
*/		
		BST c = new BST();
		c.insert(10);
		c.insert(5);
		c.insert(30);
		c.insert(20);
		c.insert(5);
		TwoIdenticalBST t = new TwoIdenticalBST();
//		System.out.println(t.identicalBSTs(a.root, b.root));
		System.out.println(t.identicalBSTs(a.root, c.root));

	}
	
	/**
	 * Method for finding two BST are identical or not
	 * @return boolean
	 * 
	 */
	public boolean identicalBSTs(Node rootA, Node rootB){
		if((rootA==null)&&(rootB==null)){
			return true;
		}else if((rootA!=null && rootB==null)||(rootA==null && rootB!=null)){
			return false;
		}else if(rootA.data==rootB.data){
			return identicalBSTs(rootA.left, rootB.left) && identicalBSTs(rootA.right, rootB.right);
		}else{
			return false;
		}
	}

}

class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}
class BST{
	public Node root=null;
	public boolean find(int id){
		Node current = root;
		while(current!=null){
			if(current.data==id){
				return true;
			}else if(current.data>id){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	public void insert(int id){
		Node newNode = new Node(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id<current.data){
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
}