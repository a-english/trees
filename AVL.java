//import java.awt.print.Printable;

public class AVL<T extends Comparable<T>> extends BinarySearchTree<T>{
	
	public void add(T x) {
		root=insert(x, root);
	}
	
	
	private BinaryNode<T> insert(T x, BinaryNode<T> leaf)
	 {
		 if(leaf==null)
			 return new BinaryNode<T>(x);
		  int compareResult=x.compareTo(leaf.value);

		  System.out.print("Balance at "+leaf.value+": "+(height(leaf.right)-height(leaf.left))+"\n");
		  if(compareResult<0) {
			  leaf.left=insert(x, leaf.left);
			  if(height(leaf.left)-height(leaf.right)==2) {
				  if (height(leaf.left.left)-height(leaf.left.right)>0)
					  leaf=singleRightRotation(leaf);
				  else
					  leaf=doubleLeftRightRotation(leaf);
			  }
		  }
		  else if(compareResult>0) {
			  leaf.right=insert(x, leaf.right);
			  if(height(leaf.right)-height(leaf.left)==2) {
				  if (height(leaf.right.right)-height(leaf.right.left)>0)
					  leaf=singleLeftRotation(leaf);
				  else
					  leaf=doubleRightLeftRotation(leaf);
				}
		  }
		  
		  return leaf;
	 }
	
	
	BinaryNode<T> deleteRoot()
	{
		return super.deleteRoot();
	}
	
	/*
	
	private int getBalance(BinaryNode<T> node)
	{
		if (node == null)
			return -1;
		else return height(node.left)-height(node.right);
	}
	
	
	private BinaryNode<T> balance(BinaryNode<T> node)
	{
		int balance=getBalance(node);
		System.out.print("Balance: "+balance+" on:"+node.print()+ "\n");
		
		if (balance>1) {
			if (height(node.getLeft().getLeft()) >= height(node.getLeft().getRight())) {
				node = singleRightRotation(node);
			}
			else {
				node = doubleLeftRightRotation(node);
			}
		}
		else if (balance <-1) {
			if (height(node.getRight().getRight()) >= height(node.getRight().getLeft())) {
				node = singleLeftRotation(node);
			}
			else {
				node = doubleRightLeftRotation(node);
			}
		}
	
		return node;
	}
	*/
	
	
	//case 1
	private BinaryNode<T> singleRightRotation(BinaryNode<T> k2)
	{
		System.out.print("Doing a single right rotation on "+k2.print()+"\n");
		BinaryNode<T> k1 = k2.getLeft();
		try {
			k2.setLeft(k1.getRight());
			k1.setRight(k2);
		}catch(NullPointerException e)	//k2.left is null
		{
			System.out.print("Aborting\n");
			return k2;
		}
		//k2.setHeight(Math.max(height(k2.getLeft()), height(k2.getRight()))+1);
		//k1.setHeight(Math.max(height(k1.getLeft()), k2.getHeight()) + 1);
		System.out.print("Returning: "+k1.print());	
		return k1;
	}
	//case 4
	private BinaryNode<T> singleLeftRotation(BinaryNode<T> k1)
	{
		System.out.print("Doing a single left rotation on "+k1.print()+"\n");
		BinaryNode<T> k2 = k1.getRight();
		try {
			k1.setRight(k2.getLeft());
			k2.setLeft(k1);
		}catch(NullPointerException e)	//k1.right is null
		{
			System.out.print("Aborting\n");
			return k1;
		}
		//k1.setHeight(Math.max(height(k1.getLeft()), height(k1.getRight()))+1);
		//k2.setHeight(Math.max(height(k2.getRight()), k1.getHeight()) + 1);
		System.out.print("Returning: "+k2.print());
		return k2;
	}
	//case 2
	private BinaryNode<T> doubleLeftRightRotation(BinaryNode<T> k3)
	{
		System.out.print("Doing a double left right rotation\n");
		k3.setLeft(singleLeftRotation(k3.getLeft()));
		return singleRightRotation(k3); 
	}
	//case 3
	private BinaryNode<T> doubleRightLeftRotation(BinaryNode<T> k1)
	{
		System.out.print("Doing a double right left rotation\n");
		k1.setRight(singleRightRotation(k1.getRight()));
		return singleLeftRotation(k1);
	}
}
