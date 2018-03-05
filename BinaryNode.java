public class BinaryNode<T extends Comparable<T>>
	 {
		 BinaryNode<T> left, right; // links to subtrees\
		 T value;
		 
		 public BinaryNode(T value)
		 { 
			 this.value = value; 
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
			
			void setLeft(BinaryNode<T> node)
			{
				left=node;
			}

			void setRight(BinaryNode<T> node)
			{
				right=node;
			}
			
			String print(){
				String ret="\nValue: "+value;
				if(left!=null)
					ret+="\nL: "+left.getData();
				if(right!=null)
					ret+="\nR: "+right.getData();
				ret+="\n";
				
				
				return ret;
				
			}
			
	 }