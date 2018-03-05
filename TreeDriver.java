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
		while(bst.height()!=5)
		{
			//for(int i=0; i<20; i++) {
				temp=random.nextInt(89)+10;
				bst.add(temp);
				tp=new TreePrinter(bst);
				//tp.print("Binary Search Tree with height of "+bst.height());
				//pressAnyKeyToContinue();
			//}
		}
		//tree with height 5 now exists.
		
		tp=new TreePrinter(bst);
		tp.print("Binary Search Tree with height of "+bst.height());
		
		System.out.print("Now deleting root.\n");
		while(bst.height()>0)
		{
			temp=random.nextInt(89)+10;
			bst.deleteRoot();
			tp=new TreePrinter(bst);
			tp.print("Binary Search Tree after deleting root ");
			//pressAnyKeyToContinue();
		}
		
		
		BinarySearchTree<Integer> avl=new AVL<Integer>();
		for(int i=0; i<35&&avl.height()<=5; i++)
		{
			temp=random.nextInt(89)+10;
			System.out.print("Adding "+temp+"\n");
			avl.add(temp);
			tp=new TreePrinter(avl);
			tp.print("AVL Tree with height of " +avl.height());
			pressAnyKeyToContinue();
		}
		
	}
}
