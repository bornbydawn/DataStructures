import java.util.*;

class Graph {
    int V;

    List<Integer> adjListArray[];

    public Graph(int V) {

        this.V = V;

        @SuppressWarnings("unchecked")
        List<Integer> adjListArray[] = new LinkedList[V];

        this.adjListArray = adjListArray;

        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {

        this.adjListArray[src].add(dest);

    }

    public void print() {
        for (int v = 0; v < this.V; v++) {
            System.out.println("Adjacency list of vertex " + v);

            System.out.print("head");

            for (Integer vertices : this.adjListArray[v]) {
                System.out.print(" -> " + vertices);
            }

            System.out.println();
        }
    }

    public void BFS(int startVertex) {
        boolean visited[] = new boolean[this.V];

        Iterator<Integer> i;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        visited[startVertex] = true;

        while (!queue.isEmpty()) {

            startVertex = queue.poll();

            System.out.print(startVertex + " ");
            i = this.adjListArray[startVertex].listIterator();

            while (i.hasNext()) {
                int vertex = i.next();
                if (!visited[vertex]) {
                    visited[vertex] = true;
                    queue.add(vertex);
                }
            }

        }

    }

    private void DFS(int startVertex, boolean[] visited) {

        Iterator<Integer> i;

        visited[startVertex] = true;

        System.out.print(startVertex + " ");
        i = this.adjListArray[startVertex].listIterator();

        while (i.hasNext()) {
            int vertex = i.next();
            if (!visited[vertex]) {
                DFS(vertex, visited);
            }

        }
    }

    public void DFS(int startVertex) {

        boolean visited[] = new boolean[this.V];

        DFS(startVertex, visited);
    }

    public void disconnectedDFS() {
        boolean visited[] = new boolean[this.V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                DFS(i, visited);
            }
        }
    }

    private void topologicalSortUtil(int startVertex, boolean[] visited, Stack<Integer> stack) {

        Iterator<Integer> i;

        visited[startVertex] = true;

        // System.out.print(startVertex + " ");
        i = this.adjListArray[startVertex].listIterator();

        while (i.hasNext()) {
            int vertex = i.next();
            if (!visited[vertex]) {
                topologicalSortUtil(vertex, visited, stack);
            }

        }

        stack.push(startVertex);
    }

    public void topologicalSort() {
        boolean visited[] = new boolean[this.V];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {

        // if the current vertex is already present in the recursion stack then cycle is
        // present
        if (recStack[i])
            return true;

        // if not in stack but has been visited in some other path then in this
        // iteration cycle is not present because of this vertex
        if (visited[i])
            return false;

        recStack[i] = true;
        visited[i] = true;

        Iterator<Integer> iter = this.adjListArray[i].listIterator();

        while (iter.hasNext()) {

            if (isCyclicUtil(iter.next(), visited, recStack))
                return true;
        }

        recStack[i] = false;
        return false;
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[this.V];
        boolean[] recStack = new boolean[this.V];

        for (int i = 0; i < this.V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;

    }

    public void topologicalSortKahns() {
        int[] indegreeArray = new int[this.V];

        for (int i = 0; i < this.V; i++) {
            Iterator<Integer> iter = this.adjListArray[i].listIterator();

            while (iter.hasNext()) {
                indegreeArray[iter.next()]++;
            }

        }

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < this.V; i++) {
            if (indegreeArray[i] == 0)
                queue.add(i);
        }

        int visitedNodes = 0;

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            list.add(current);
            for (int var : this.adjListArray[current]) {
                if (--indegreeArray[var] == 0)
                    queue.add(var);
            }
            visitedNodes++;
        }

        if (visitedNodes != this.V) {
            System.out.println("This graph contains cycles");
            return;
        }

        for (int i : list) {
            System.out.println(i + " ");
        }
    }

    private void allTopologicalSortsUtil(boolean[] visited, int[] indegree, ArrayList<Integer> stack) {

        boolean flag = false;

        for (int i = 0; i < this.V; i++) {

            if (!visited[i] && indegree[i] == 0) {

                visited[i] = true;
                stack.add(i);
                for (int adjacent : this.adjListArray[i]) {
                    indegree[adjacent]--;
                }
                allTopologicalSortsUtil(visited, indegree, stack);

                visited[i] = false;
                stack.remove(stack.size() - 1);
                for (int adjacent : this.adjListArray[i]) {
                    indegree[adjacent]++;
                }

                flag = true;
            }
        }

        if (!flag) {
            stack.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }

    }

    public void allTopologicalSorts() {

        boolean[] visited = new boolean[this.V];

        int[] indegree = new int[this.V];

        for (int i = 0; i < this.V; i++) {

            for (int var : this.adjListArray[i]) {
                indegree[var]++;
            }
        }

        ArrayList<Integer> stack = new ArrayList<>();

        allTopologicalSortsUtil(visited, indegree, stack);
    }
}