public class BinarySearchTree<T extends Comparable<T>>
{
	 BinaryNode<T> root; // root of BST

	 public int height() {
		 return height(root);
	 }
	 int height(BinaryNode<T> leaf){
		 if(leaf==null)
			 return -1;
		 return Math.max(height(leaf.left), height(leaf.right))+1;
	 }
	 public BinaryNode<T> getRoot()
	 {
		 return root;
	 }
	 
	 
	 public void add(T x)
	 {
		 root=insert(x, root);
	 }
	 
	 public BinaryNode<T> insert(T x, BinaryNode<T> leaf)
	 {
		 if(leaf==null)
			 return new BinaryNode<T>(x);
		  int compareResult=x.compareTo(leaf.value);
		  
		  if(compareResult<0)
			  leaf.left=insert(x, leaf.left);
		  else if(compareResult>0)
			  leaf.right=insert(x, leaf.right);
		  
		  return leaf;
	 }
	 
	

	 public T min()
	 {
		 return min(root).value;
	 }
	 public BinaryNode<T> min(BinaryNode<T> x)
	 {
		  if (x.left == null) 
			  return x;
		  return min(x.left);
	 }
	 public void deleteMin()
	 {
		 root = deleteMin(root);
	 }
	 public BinaryNode<T> deleteMin(BinaryNode<T> x)
	 {
		  if (x.left == null) 
			  return x.right;
		  x.left = deleteMin(x.left);
		  return x;
	 }
	 
	 BinaryNode<T> deleteRoot(){
		 root = delete(root, root.value); 
		 return root;
	 }
	 
	 public BinaryNode<T> delete(BinaryNode<T> x, T value){
		  if (x == null) 
			  return null;
		  int cmp = value.compareTo(x.value);
		  if (cmp < 0)
			  x.left = delete(x.left, value);
		  else if (cmp > 0)
			  x.right = delete(x.right, value);
		  else
		  {
			  if (x.right == null) 
				  return x.left;
			  if (x.left == null) 
				  return x.right;
			  BinaryNode<T> t = x;
			  x = min(t.right);
			  x.right = deleteMin(t.right);
			  x.left = t.left;
		  }
		  return x;
	 }
}