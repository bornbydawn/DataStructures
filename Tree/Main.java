public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.root = new Node<>(1);
        // tree.root.setLeft(new Node<Integer>(2).setLeft(new Node<Integer>(7)).setRight(new Node<Integer>(6)))
        //         .setRight(new Node<Integer>(3).setLeft(new Node<Integer>(5)).setRight(new Node<Integer>(4)));

        tree.root
                .setLeft(new Node<Integer>(2).setLeft(new Node<Integer>(3).setLeft(new Node<Integer>(4)))
                        .setRight(new Node<Integer>(5).setRight(new Node<Integer>(6))))
                .setRight(new Node<Integer>(7).setRight(new Node<Integer>(13)).setLeft(new Node<Integer>(8).setLeft(new Node<Integer>(9)).setRight(
                        new Node<Integer>(10).setRight(new Node<Integer>(11).setRight(new Node<Integer>(12))))));

        // System.out.println(tree.calculateHeightIterative());

        // Node<Integer> newHead = tree.convertToCircularDll();

        // tree.printCircularDll(newHead);

        // tree.doInorderTranversal();
        // tree.printLevelOrder();
         //tree.traverseDiagonal();
        // tree.countLeaves();
        // System.out.println(tree.getDiameter());

         //tree.doVerticalTraversalIter();
         //System.out.println();
         //rutree.traverseVertical();

        //System.out.println(tree.isIdenticalToTree(tree.root));

        //tree.printAncestors(new Node(11));

        //tree.printPathWithGivenSum(21);
        //tree.printNodesWithKLeaves(2);
        // tree.printSumOfNodes();

        // tree.printRootToLeafPaths();
         //tree.printAncestorsStack(new Node<Integer>(11));

         //tree.printLowestCommonAncestor(new Node<Integer>(4), new Node<Integer>(5));

         //tree.printLowestCommonAncestorRecur(new Node<Integer>(4), new Node<Integer>(5));
        // tree.printNodesAtDistance(0);
        // tree.doInorderTranversal();
        
          tree.printTopView();

          System.out.println();

          tree.printTopViewWithoutHash();
    }

}