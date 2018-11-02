import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

class Num {
    int value;
}

class NodeWrapper<T> {
    Node<T> node;
}

class Node<T> {
    T val;
    Node<T> left, right;

    public Node(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public Node<T> setLeft(Node<T> node) {
        this.left = node;
        return this;
    }

    public Node<T> setRight(Node<T> node) {
        this.right = node;
        return this;
    }
}

class Tree<T> {

    Node<T> root;

    public int getDiameter() {

        // return calculateDiameter(this);

        Num a = new Num();
        a.value = Integer.MIN_VALUE;

        // Integer diameter = Integer.MIN_VALUE;

        calculateDiameter(root, a);
        return a.value;
    }

    private int calculateDiameter(Node<T> node, Num answer) {

        if (node == null)
            return 0;

        int lheight = calculateDiameter(node.left, answer);
        int rheight = calculateDiameter(node.right, answer);

        answer.value = Math.max(answer.value, 1 + lheight + rheight);
        return 1 + Math.max(lheight, rheight);
    }

    private int calculateDiameter(Node<T> node) {

        if (node == null)
            return 0;

        int lheight = calculateHeight(node.left);
        int rheight = calculateHeight(node.right);

        int ldiameter = calculateDiameter(node.left);
        int rdiameter = calculateDiameter(node.right);

        return Math.max(1 + lheight + rheight, Math.max(ldiameter, rdiameter));
    }

    public int getHeight() {

        return calculateHeight(root);

    }

    private int calculateHeight(Node<T> node) {

        if (node == null) {
            return 0;
        } else
            return 1 + Math.max(calculateHeight(node.left), calculateHeight(node.right));

    }

    public void printLevelOrder() {

        HashMap<Integer, ArrayList<T>> map = new HashMap<>();

        doLevelOrder(root, 0, map);

        System.out.println("Level Order");
        for (ArrayList<T> value : map.values()) {
            value.forEach(e -> System.out.print(e + " "));
        }
        // System.out.println();

        // System.out.println("Spiral Order");
        // for (Map.Entry<Integer, ArrayList<T>> entry : map.entrySet()) {
        // if (entry.getKey() % 2 == 0) {
        // Collections.reverse(entry.getValue());
        // entry.getValue().forEach(System.out::print);

        // } else {
        // entry.getValue().forEach(System.out::print);
        // }
        // }

    }

    private void inorderTranversal(Node<T> node) {

        if (node == null)
            return;
        inorderTranversal(node.left);
        System.out.println(node.val);
        inorderTranversal(node.right);
    }

    public void doInorderTranversal() {
        inorderTranversal(root);
    }

    private void preorderTranversal(Node<T> node) {

        if (node == null)
            return;
        System.out.println(node.val);
        preorderTranversal(node.left);
        preorderTranversal(node.right);
    }

    public void doPreorderTranversal() {
        preorderTranversal(root);
    }

    private void postorderTranversal(Node<T> node) {
        if (node == null)
            return;
        postorderTranversal(node.left);
        postorderTranversal(node.right);
        System.out.println(node.val);
    }

    public void doPostorderTranversal() {
        postorderTranversal(root);
    }

    private void doLevelOrder(Node<T> node, int level, HashMap<Integer, ArrayList<T>> map) {

        ArrayList<T> a;

        if (node.left != null)
            doLevelOrder(node.left, level + 1, map);

        if (node.right != null)
            doLevelOrder(node.right, level + 1, map);

        a = map.get(level) != null ? a = map.get(level) : new ArrayList<>();

        a.add(node.val);
        map.put(level, a);
    }

    public void doLevelOrderQueue() {

        Queue<Node<T>> q = new LinkedList<>();

        q.add(root);

        // all nodes in a level are popped out in one go that is why the while loop
        while (!q.isEmpty()) {
            Node<T> node = q.poll();
            System.out.println(node.val);

            if (node.left != null)
                q.add(node.left);

            if (node.right != null)
                q.add(node.right);

        }
    }

    public void doSpiralOrderStack() {

        Stack<Node<T>> s1 = new Stack<>(); // printed to right to left, so left will be inserted first
        Stack<Node<T>> s2 = new Stack<>(); // printed from left to right, so right will be inserted first

        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {

            // all nodes in a level are popped out in one go that is why the while loop
            while (!s1.isEmpty()) {
                Node<T> node = s1.pop();

                System.out.println(node.val);
                if (node.right != null)
                    s2.add(node.right);

                if (node.left != null)
                    s2.add(node.left);
            }

            while (!s2.isEmpty()) {
                Node<T> node = s2.pop();
                System.out.println(node.val);
                if (node.left != null)
                    s1.add(node.left);

                if (node.right != null)
                    s1.add(node.right);
            }

        }
    }

    public Node<T> convertToDll() {

        NodeWrapper<T> prev = new NodeWrapper<>();
        NodeWrapper<T> newHead = new NodeWrapper<>();
        doConvertToDll(this.root, newHead, prev);
        return newHead.node;
    }

    public Node<T> convertToCircularDll() {

        NodeWrapper<T> prev = new NodeWrapper<>();
        NodeWrapper<T> newHead = new NodeWrapper<>();
        doConvertToDll(this.root, newHead, prev);
        prev.node.right = newHead.node;
        newHead.node.left = prev.node;
        return newHead.node;
    }

    private void doConvertToDll(Node<T> root, NodeWrapper<T> newHead, NodeWrapper<T> prev) {
        if (root == null)
            return;

        doConvertToDll(root.left, newHead, prev);

        if (prev.node == null) {
            newHead.node = root;
        }

        else {
            root.left = prev.node;
            prev.node.right = root;
        }

        prev.node = root;

        doConvertToDll(root.right, newHead, prev);
    }

    public void printDll(Node<T> head) {

        while (head != null) {
            System.out.println(head.val);
            head = head.right;
        }

    }

    public void printCircularDll(Node<T> head) {

        Node<T> startingHead = head;
        while (head != null) {
            System.out.println(head.val);
            head = head.right;
            if (head == startingHead)
                break;
        }

    }

    public void printTopViewWithoutHash() {

        if (this.root == null)
            return;

        class QueueItem<T> {
            Node<T> node;
            int horizontalDistance;

            public QueueItem(Node<T> node, int horizontalDistance) {
                this.node = node;
                this.horizontalDistance = horizontalDistance;
            }
        }

        List<Integer> distanceList = new ArrayList<>();
        Queue<QueueItem<T>> queue = new LinkedList<>();
        queue.add(new QueueItem(this.root, 0));
        // distanceList.add(0);

        while (!queue.isEmpty()) {

            QueueItem<T> item = queue.poll();
            int hd = item.horizontalDistance;

            Node<T> node = item.node;

            if (!distanceList.contains(hd)) {
                System.out.print(node.val + " ");
                distanceList.add(hd);
            }

            if (node.left != null) {
                queue.add(new QueueItem(node.left, hd - 1));
            }

            if (node.right != null) {
                queue.add(new QueueItem(node.right, hd + 1));
            }
        }

    }

    public int calculateHeightIterative() {

        Queue<Node<T>> q = new LinkedList<>();

        q.add(root);
        int levelSize = 0;
        int height = 0;

        while (true) {

            if (q.isEmpty())
                return height;
            levelSize = q.size();
            height += 1;
            while (levelSize != 0) {
                Node<T> node = q.poll();

                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);

                levelSize--;

            }
        }
    }

    public void traverseDiagonal() {

        Map<Integer, ArrayList<T>> map = new HashMap<>();
        doTraversalDiagonal(this.root, map, 0);

        for (Map.Entry<Integer, ArrayList<T>> entry : map.entrySet()) {
            System.out.print("Level " + entry.getKey() + ": ");
            entry.getValue().stream().forEach(k -> System.out.print(k + " "));
            System.out.println();
        }
    }

    private void doTraversalDiagonal(Node<T> root, Map<Integer, ArrayList<T>> map, int level) {

        ArrayList<T> a;
        if (root == null)
            return;
        a = map.get(level) != null ? a = map.get(level) : new ArrayList<>();
        a.add(root.val);
        map.put(level, a);

        if (root.left != null)
            doTraversalDiagonal(root.left, map, level + 1);

        if (root.right != null)
            doTraversalDiagonal(root.right, map, level);
    }

    private int doCountLeaves(Node<T> root) {
        // this is wrong remeber why
        // if(root == null) return 1;

        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        return doCountLeaves(root.left) + doCountLeaves(root.right);

    }

    public void countLeaves() {
        int count = doCountLeaves(this.root);
        System.out.println(count);
    }

    public void traverseVertical() {

        Map<Integer, ArrayList<T>> map = new TreeMap<>();

        doVerticalTraversalRecur(this.root, 0, map);

        for (Map.Entry<Integer, ArrayList<T>> entry : map.entrySet()) {
            // System.out.print("Horizontal Distance " + entry.getKey() + ": ");
            entry.getValue().forEach(k -> System.out.print(k + " "));
            System.out.println();
        }
    }

    public void printTopView() {

        Map<Integer, ArrayList<T>> map = new TreeMap<>();

        doVerticalTraversalRecur(this.root, 0, map);

        HashMap<Integer, ArrayList<T>> levelOrderMap = new HashMap<>();

        doLevelOrder(root, 0, levelOrderMap);

        // ArrayList<T> levelOrderArray = new ArrayList<>();

        // for (Map.Entry<Integer, ArrayList<T>> entryLevel : map.entrySet()) {
        // levelOrderArray.addAll(entryLevel.getValue());
        // }

        // for (T var : levelOrderArray) {
        // System.out.print(var + ", ");
        // }

        int found = 0;
        for (Map.Entry<Integer, ArrayList<T>> entry : map.entrySet()) {
            // System.out.print("Horizontal Distance " + entry.getKey() + ": ");

            if (entry.getValue().size() > 1) {
                found = 0;
                for (Map.Entry<Integer, ArrayList<T>> entryLevel : levelOrderMap.entrySet()) {
                    for (T var : entryLevel.getValue()) {
                        for (T varTarget : entry.getValue()) {
                            if (var.equals(varTarget)) {
                                System.out.print(var + " ");
                                found = 1;
                                break;
                            }
                        }
                        if (found == 1)
                            break;
                    }
                    if (found == 1)
                        break;
                }
            } else {
                System.out.print(entry.getValue().get(0) + " ");
            }

        }
    }

    public void doVerticalTraversalIter() {

        Queue<Node<T>> queue = new LinkedList<>();
        Queue<Integer> val = new LinkedList<>();

        // Map<Node<T>, Integer> distanceMap = new LinkedHashMap<>();
        Integer horizontalDistance = Integer.valueOf(0);

        Map<Integer, ArrayList<T>> map = new TreeMap<>();

        map.put(0, new ArrayList<T>(Arrays.asList(this.root.val)));

        queue.add(this.root);
        val.add(0);

        // distanceMap.put(this.root, 0);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();

            horizontalDistance = val.poll();
            // distanceMap.get(current);

            if (current.left != null) {

                ArrayList<T> list = map.containsKey(horizontalDistance - 1) ? map.get(horizontalDistance - 1)
                        : new ArrayList<T>();
                list.add(current.left.val);
                map.put(horizontalDistance - 1, list);
                queue.add(current.left);
                val.add(horizontalDistance - 1);
            }

            if (current.right != null) {

                ArrayList<T> list = map.containsKey(horizontalDistance + 1) ? map.get(horizontalDistance + 1)
                        : new ArrayList<T>();
                list.add(current.right.val);
                map.put(horizontalDistance + 1, list);
                queue.add(current.right);
                val.add(horizontalDistance + 1);
            }

        }

        for (Map.Entry<Integer, ArrayList<T>> entry : map.entrySet()) {

            entry.getValue().forEach(k -> System.out.print(k + " "));
            System.out.println();
        }

    }

    private void doVerticalTraversalRecur(Node<T> root, Integer horizontalDistance, Map<Integer, ArrayList<T>> map) {

        ArrayList<T> distanceList;
        if (root == null)
            return;

        // System.out.println(horizontalDistance + " " + root.val);
        distanceList = map.get(horizontalDistance) != null ? map.get(horizontalDistance) : new ArrayList<>();

        distanceList.add(root.val);
        map.put(horizontalDistance, distanceList);

        doVerticalTraversalRecur(root.left, horizontalDistance - 1, map);
        doVerticalTraversalRecur(root.right, horizontalDistance + 1, map);
    }

    public void printNodesAtDistance(int k) {
        doDistanceKFromRoot(this.root, 0, k);
    }

    public Boolean isIdenticalToTree(Node<T> secondRoot) {

        return checkIdentical(this.root, secondRoot);
    }

    private Boolean checkIdentical(Node<T> firstRoot, Node<T> secondRoot) {

        if (firstRoot == null && secondRoot == null)
            return true;

        if (firstRoot != null && secondRoot != null) {
            if (checkIdentical(firstRoot.left, secondRoot.left) && checkIdentical(firstRoot.right, secondRoot.right))
                return true;
        }
        return false;

    }

    public Boolean checkIfSubtree(Node<T> secondRoot) {

        return checkIfSubtree(this.root, secondRoot);

    }

    private Boolean checkIfSubtree(Node<T> thisRoot, Node<T> secondRoot) {

        if (secondRoot == null)
            return true;

        if (thisRoot == null)
            return false;

        if (checkIdentical(thisRoot, secondRoot))
            return true;

        return checkIfSubtree(thisRoot.left, secondRoot) || checkIfSubtree(thisRoot.right, secondRoot);

    }

    public void printAncestors(Node<T> node) {

        int isPresent = getAncestors(this.root, node);

        if (isPresent == 0)

            System.out.println("Node not found in tree.");

    }

    private Integer getAncestors(Node<T> root, Node<T> node) {

        if (root != null) {
            if (root.val == node.val)
                return 1;

            if (getAncestors(root.left, node) == 1 || getAncestors(root.right, node) == 1) {
                System.out.println(root.val);
                return 1;
            }
        }

        return 0;
    }

    private void doDistanceKFromRoot(Node<T> root, int distance, int k) {
        if (root == null)
            return;

        if (distance == k)
            System.out.println(root.val);

        if (root.left != null)
            doDistanceKFromRoot(root.left, distance + 1, k);

        if (root.right != null)
            doDistanceKFromRoot(root.right, distance + 1, k);

    }

    // public void printSumOfNodes(){
    // Num sum = new Num();
    // Node<Integer> a = null;
    // //java uses erasure. it does not know the type T at runtime. Only at compile
    // time it ensures. Everywhere inside the class it uses Java.lang.Object at
    // runtime
    // //if(T.class == Integer.class){
    // a = (Node<Integer>) this.root;
    // //}
    // System.out.println(calculateSumOfNodes(a, sum));
    // }

    // private int calculateSumOfNodes(Node<Integer> root, Num sum){

    // if(root == null) return 0;

    // sum.value = sum.value + root.val;
    // calculateSumOfNodes(root.left, sum);
    // calculateSumOfNodes(root.right, sum);

    // return sum.value;
    // }

    public void printRootToLeafPaths() {

        Stack<Node<T>> stack = new Stack<>();
        doRootToLeaf(this.root, stack);
    }

    private void doRootToLeaf(Node<T> root, Stack<Node<T>> stack) {

        if (root == null)
            return;

        stack.push(root);

        doRootToLeaf(root.left, stack);

        if (root.left == null && root.right == null) {
            Iterator<Node<T>> a = stack.iterator();

            a.forEachRemaining(n -> System.out.print(n.val + " "));
            System.out.println();
        }

        doRootToLeaf(root.right, stack);

        stack.pop();
    }

    public void printAncestorsStack(Node<T> node) {

        Stack<Node<T>> stack = new Stack<>();

        Stack<Node<T>> result = new Stack<>();
        doAncestors(this.root, stack, node.val, result);

        Iterator<Node<T>> a = result.iterator();

        a.forEachRemaining(n -> System.out.print(n.val + " "));
    }

    private void doAncestors(Node<T> root, Stack<Node<T>> stack, T val, Stack<Node<T>> result) {

        if (root == null)
            return;

        stack.push(root);

        doAncestors(root.left, stack, val, result);

        if (val.equals(root.val)) {
            result.setSize(stack.size());
            Collections.copy(result, stack);
            return;
        }

        doAncestors(root.right, stack, val, result);

        stack.pop();
    }

    public void printPathWithGivenSum(Integer sum) {

        Stack<Node<Integer>> stack = new Stack<>();
        Node<Integer> node = (Node<Integer>) this.root;
        pathWithGivenSum(node, stack, sum);
    }

    private int sumOfStack(Stack<Node<Integer>> stack) {

        int sum = 0;
        Iterator<Node<Integer>> itr = stack.iterator();

        while (itr.hasNext()) {

            sum += itr.next().val;
        }

        return sum;
    }

    private void pathWithGivenSum(Node<Integer> root, Stack<Node<Integer>> stack, Integer sum) {

        if (root == null)
            return;

        stack.push(root);

        pathWithGivenSum(root.left, stack, sum);

        if (sum == sumOfStack(stack)) {
            Iterator<Node<Integer>> a = stack.iterator();

            a.forEachRemaining(n -> System.out.print(n.val + " "));
            // return;
        }

        pathWithGivenSum(root.right, stack, sum);

        stack.pop();
    }

    public void printNodesWithKLeaves(int k) {

        nodesWithkLeaves(this.root, k);
    }

    // postorder traversal with count of leaves
    private int nodesWithkLeaves(Node<T> root, int k) {

        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        int leftLeafCount = nodesWithkLeaves(root.left, k);
        int rightLeafCount = nodesWithkLeaves(root.right, k);

        if (leftLeafCount + rightLeafCount == k) {
            System.out.println(root.val);
        }

        return rightLeafCount + leftLeafCount;
    }

    public void printLowestCommonAncestor(Node<T> firstNode, Node<T> secondNode) {

        if (firstNode == null || secondNode == null) {
            System.out.println("Null node(s) given");
            return;
        }

        Stack<Node<T>> stack = new Stack<>();

        Stack<Node<T>> stackOneResult = new Stack<>();

        Stack<Node<T>> stackTwoResult = new Stack<>();

        doAncestors(this.root, stack, firstNode.val, stackOneResult);

        stack.clear();
        doAncestors(this.root, stack, secondNode.val, stackTwoResult);

        Collections.reverse(stackOneResult);
        Collections.reverse(stackTwoResult);

        for (int i = 0; i < stackOneResult.size(); i++) {
            for (int j = 0; j < stackTwoResult.size(); j++) {
                if (stackOneResult.get(i) == stackTwoResult.get(j)) {
                    System.out.println(stackOneResult.get(i).val);
                    return;
                }
            }
        }

    }

    public void printLowestCommonAncestorRecur(Node<T> firstNode, Node<T> secoNode) {

        Node<T> answer = getLowestCommonAncestor(this.root, firstNode, secoNode);

        System.out.println(answer.val);
    }

    public Node<T> getLowestCommonAncestor(Node<T> root, Node<T> firstNode, Node<T> secoNode) {

        if (root == null)
            return null;
        if (root.val == firstNode.val || root.val == secoNode.val)
            return root;

        Node<T> left = getLowestCommonAncestor(root.left, firstNode, secoNode);
        Node<T> right = getLowestCommonAncestor(root.right, firstNode, secoNode);

        if (left != null && right != null)
            return root;

        else {
            return left != null ? left : right;
        }

    }
}