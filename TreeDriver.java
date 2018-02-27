import java.util.Random;

public class TreeDriver {
	
	 private static void pressAnyKeyToContinue()
	 { 
	        System.out.println("Press Enter key to continue...");
	        try
	        {
	            System.in.read();
	        }  
	        catch(Exception e)
	        {}  
	 }
	 
	public static void main(String args[])
	{
		Random random = new Random();
		TreePrinter tp;
		BinarySearchTree<Integer> bst=new BinarySearchTree<Integer>();
		int temp;
		while(bst.height()<5)
		{
			temp=random.nextInt(89)+10;
			bst.add(temp);
			//System.out.print("Adding "+temp+"\n");
		//	pressAnyKeyToContinue();
		}
		//tree with height 5 now exists.
		tp=new TreePrinter(bst);
		tp.print("Binary Search Tree with height of "+bst.height());
		
		

		BinarySearchTree<Integer> avl=new AVL<Integer>();
		while(avl.height()<5)
		{
			temp=random.nextInt(89)+10;
			avl.add(temp);
			//System.out.print("Adding "+temp+"\n");
		//	pressAnyKeyToContinue();
		}
		//tree with height 5 now exists.
		tp=new TreePrinter(avl);
		tp.print("AVL Tree with height of "+avl.height());
		
	}
}
