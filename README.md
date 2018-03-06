# trees for 130
I've written trees in C++ before, but in C++ one simply uses pointers. Writing a data structure such as a tree without access to memory is a challenging transition.

I discovered through much desperation that Java is exclusively pass by value, so in order to affect a node you must use the node's member functions.

The text in the book was very helpful in understanding how to write trees in Java. Additionally the code snippets are very useful. However it is clearly not enough to just copy down code snippets and try to force them together; one must understand the code in order to use it.

A balanced tree can many more elements in the same amount of levels as an unbalanced tree. It is clear that AVL trees are useful in keeping very large databases from becoming very long to navigate through by reducing the number of levels.

Debugging the AVL tree really helped me understand the algorithms for rotation. It really forced me to hand-trace every rotation in order to find my bugs, which helped me to memorize the rotations.
