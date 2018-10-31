# Scapegoat-Tree
Scape Goat tree implemented on Java.

## What is a data structure?
A data structure is a specialized format for organizing and storing data. General data structure types include the array, the file, the record, the table, the tree, and so on. Any data structure is designed to organize data to suit a specific purpose so that it can be accessed and worked with in appropriate ways.

## What is Tree?
A tree is a widely used abstract data type (ADT)—or data structure implementing this ADT—that simulates a hierarchical tree structure, with a root value and subtrees of children with a parent node, represented as a set of linked nodes.

A tree data structure can be defined recursively (locally) as a collection of nodes (starting at a root node), where each node is a data structure consisting of a value, together with a list of references to nodes (the "children"), with the constraints that no reference is duplicated, and none points to the root.

## What is Scapegoat-Tree?
A scapegoat tree is a self-balancing binary search tree. It provides worst-case O(log n) lookup time, and O(log n) amortized insertion and deletion time.

Unlike most other self-balancing binary search trees which provide worst case O(log n) lookup time, scapegoat trees have no additional per-node memory overhead compared to a regular binary search tree: a node stores only a key and two pointers to the child nodes. This makes scapegoat trees easier to implement and, due to data structure alignment, can reduce node overhead by up to one-third.

Instead of the small incremental rebalancing operations used by most balanced tree algorithms, scapegoat trees rarely but expensively choose a "scapegoat" and completely rebuild the subtree rooted at the scapegoat into a complete binary tree. Thus, scapegoat trees have O(n) worst-case update performance.

## Where is the Source code:
The source code can be found in /src directory. There are total 3 java classes:

-- SCGNode.java = Java class for a Node. Simply put, node is a basic unit that stores any data.

-- ScapeGoatTree.java = Java class for actual tree. This uses the SCGNode class as tree is simply made through nodes.

-- ScapeGoatMainFile.java = Java main class.
