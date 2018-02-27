
class BinaryNode<T extends Comparable<T>>{
	T value;
	BinaryNode<T> left, right;
	
	BinaryNode(T value){
		this.value=value;
		left=null;
		right=null;
	}
	
	int height() {
		int left, right;
		if(this.left==null)
			left=-1;
		else
			left=this.left.height();
		if (this.right==null)
			right=-1;
		else
			right=this.right.height();
		
		if(left>right)
			return 1+left;
		else return 1+right;
	}
	
	
	T getData() {
		return value;
	}
	
	BinaryNode<T> getLeft(){
		return left;
	}
	
	BinaryNode<T> getRight(){
		return right;
	}
	
	void insert(T query)
	{
		if(query.compareTo(value)<0) {		//less than
			//System.out.print("Going left.\n");
			if(left==null){
				left=new BinaryNode<T>(query);
				}
			else{
				left.insert(query);
			}
		}
		else if(query.compareTo(value)>0) {		//greater than
			//System.out.print("Going right.\n");
			if(right==null) {
				right=new BinaryNode<T>(query);
			}
			else {
				right.insert(query);
			}
		}
	}
}

public class BinarySearchTree<T extends Comparable<T>> {
	BinaryNode<T> root;
	
	BinarySearchTree(){
		root=null;
	}
	
	void add(T value)
	{
		if(root==null)
			root=new BinaryNode<T>(value);
		else
			root.insert(value);
	}
	
	int height()
	{
		if (root==null)
			return -1;
		return root.height();
		
	}
	
	BinaryNode<T> getRoot(){
		return root;
	}
	
}
