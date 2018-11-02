import java.io.*;
import java.util.*;
import java.lang.Math;
// import javafx.util.Pair;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class jkm {
    Node root;
    static cin in = new cin(new InputStreamReader(System.in));
    static PrintWriter w = new PrintWriter(System.out);

    public static void main(String[] args) {

        jkm tree = new jkm();
        tree.root = new Node(2);
        tree.root.left = new Node(5);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(10);
        tree.root.left.right.right = new Node(11);
        tree.root.right.left = new Node(14);
        tree.root.right.right = new Node(15);

        Map<Integer, ArrayList<Node>> ans = new TreeMap<Integer, ArrayList<Node>>();

        ans.put(0, new ArrayList<Node>(Arrays.asList(tree.root)));

        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Integer> value = new LinkedList<>();

        queue.add(tree.root);
        value.add(0);

        while (!queue.isEmpty()) {
            Node u = queue.poll();
            int val = value.poll();
            if (u.left != null) {
                if (ans.containsKey(val - 1)) {
                    ArrayList<Node> l = ans.get(val - 1);
                    l.add(u.left);
                    ans.put(val - 1, l);
                } else
                    ans.put(val - 1, new ArrayList<Node>(Arrays.asList(u.left)));
                queue.add(u.left);
                value.add(val - 1);
            }
            if (u.right != null) {
                if (ans.containsKey(val + 1)) {
                    ArrayList<Node> l = ans.get(val + 1);
                    l.add(u.right);
                    ans.put(val + 1, l);
                } else
                    ans.put(val + 1, new ArrayList<Node>(Arrays.asList(u.right)));
                queue.add(u.right);
                value.add(val + 1);
            }
        }

        ans.forEach((k, v) -> {

            for (Node i : ans.get(k)) {

                System.out.print(i.data + " ");
            }
            System.out.println("");
        });

        w.close();
    }

    public static class cin {
        public BufferedReader scan;
        public StringTokenizer st;

        public cin(InputStreamReader stream) {
            scan = new BufferedReader(stream);
            st = null;
        }

        public cin(FileReader stream) {
            scan = new BufferedReader(stream);
            st = null;
        }

        public String string() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(scan.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int Int() {
            return Integer.parseInt(string());
        }

        public String Line() throws IOException {
            return scan.readLine();
        }

        public long Long() {
            return Long.parseLong(string());
        }

        public double Double() {
            return Double.parseDouble(string());
        }

    }

}