package Linked_List;

class Node<T> {

    T val;
    Node<T> next;
    Node<T> prev;

    public Node(T val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList<T> {
    Node<T> head;

    public DoublyLinkedList(){}
    public DoublyLinkedList(T val) {
        this.head = new Node<T>(val);
    }

    public void insertFirst(T val) {
        Node<T> newNode = new Node<T>(val);

        Node<T> oldHead = this.head;

        oldHead.prev = newNode;

        newNode.next = oldHead;

        this.head = newNode;
    }

    public void insertLast(T val) {
        Node<T> newNode = new Node<T>(val);

        Node<T> mover = this.head;
        while (mover.next != null) {
            mover = mover.next;
        }

        mover.next = newNode;
        newNode.prev = mover;
    }

    public void printList() {
        Node<T> mover = this.head;

        while (mover != null) {
            System.out.print(mover.val + " ");
            mover = mover.next;
        }
    }

    public void printListReverse() {

        printListReverse(this.head);
    }

    private void printListReverse(Node<T> node) {

        Node<T> mover = node;
        while (mover.next != null) {
            mover = mover.next;
        }

        while (mover != null) {
            System.out.print(mover.val + " ");
            mover = mover.prev;
        }
    }

    public DoublyLinkedList<T> returnCopyOfRandomList(Node<T> head) {

        DoublyLinkedList<T> copyList = new DoublyLinkedList<T>();

        Node<T> originalListHead = head;
        Node<T> originalListHeadOne = head;
        Node<T> originalListHeadTwo = head;
        while (originalListHeadOne != null) {
            Node<T> nextReference = originalListHeadOne.next;
            Node<T> copyNode = new Node<T>(originalListHeadOne.val);

            originalListHeadOne.next = copyNode;
            copyNode.next = nextReference;

            originalListHeadOne = originalListHeadOne.next.next;
        }

        while(originalListHead != null){

            originalListHead.next.prev = originalListHead.prev.next;

            originalListHead = originalListHead.next != null? originalListHead.next.next : originalListHead.next;

        }

        Node<T> copy = head.next;

        Node<T> toReturn = copy;
        while(originalListHeadTwo != null && copy != null){
            originalListHeadTwo.next = originalListHeadTwo.next != null? originalListHeadTwo.next.next : originalListHeadTwo.next;


            copy.next = copy.next != null? copy.next.next : copy.next;

            originalListHeadTwo = originalListHeadTwo.next;
            copy = copy.next;

        }

        copyList.head = toReturn;

        return copyList;
    }
}
