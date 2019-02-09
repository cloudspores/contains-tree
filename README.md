# Subtree Check
You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.

Create an algorithm to decide if T2 is a subtree of T1

# Approach
See if binary tree T2 is a subtree of binary tree T1

     - A tree T2 is a subtree of T1 if T1 has a node where the subtree of this node is identical to T2.
     - Two trees are identical if they have the same pre-order traversal - assuming the NULL nodes are represented.
     - The approach:
        - traverse through the larger tree, T1
        - when a node in T1 matches the root node of T2 call compareTree() to compare two sub-trees for equality

# Sample Run Results

    T1:
    └── 1
        ├── 2
        │   ├── 3
        │   └── 1
        └── 1
            ├── 1
            └── 5
    T2:
    └── 2
        ├── 3
        └── 1
    
    
    T2 is a subtree of T1
    
    
    T3:
    └── 1
        ├── 2
        └── 3
    
    
    T3 is not a subtree of T1
    
# Performance
A rough estimate is O(nm) time, where n is the number of nodes in T1 and T2 respectively.

In practice, performance is better than this rough estimate because the compareTree() method in TreeUtils.java is not called on every node in T1. 

compareTree() only gets called the number of occurrences of T2's root in T1 making the runtime closer to an upper limit of O(n + km).

Where k is the number of occurrences of T2's root in T1

m is an upper limit not reached in practice since less than m nodes are looked at in compareTree() because it exits as soon as a difference is found.


## Build, Deploy Run
- To build and deploy from ./ContainsTree-Ade-Lucas: mvn clean install
- Builds and deploys to: ./ContainsTree-Ade-Lucas/deployment
- cd ./ContainsTree-Ade-Lucas/deployment
- ./run.sh
- Runs the program and produces and prints out results to terminal
