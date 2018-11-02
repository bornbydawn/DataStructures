class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(1);

        list.insertFirst(0);
        list.insertLast(2);

        list.head.prev = list.head.next.next;

        list.head.next.prev = list.head;

        list.head.next.next.prev = list.head.next;

        //list.printList();

       // list.printListReverse();

       DoublyLinkedList<Integer> copyList = list.returnCopyOfRandomList(list.head);

       copyList.printList();
    }
}