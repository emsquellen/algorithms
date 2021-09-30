
/**
 * @author Emmy Smith
 * @version 1.3
 * @since 0.0
 */

public class SinglyLinkedList {

    private static class Node {

        private final int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;

    public int length = 0;

    /**
     * Adds a Node to the front of the list
     * 
     * @param data integer to be represented by the Node
     */
    public void add(int data) {
        add(data, 0);
    }

    /**
     * Adds a Node to the list at a specified index
     * 
     * @param data  integer to be represented by the Node
     * @param index where the Node will be added at. If index is out of bounds, the
     *              data will be added at the end of the list
     */
    public void add(int data, int index) {
        Node newNode = new Node(data);
        if (length == 0) {
            this.head = newNode;
            this.tail = newNode;

        } else if (index == 0) {
            newNode.next = this.head;
            this.head = newNode;

        } else if ((this.length == 1 && index == 1) || index >= length || index == -1) {
            this.tail.next = newNode;
            this.tail = newNode;

        } else {
            Node currentNode = head;
            for (int i = 0; i <= index; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        this.length++;
    }

    /**
     * Removes a Node to the list at a specified index
     * 
     * @param index where the Node will be removed from
     */
    public void remove(int index) {
        if (this.length < 1) {
            return;

        } else if (this.length == 1) {
            this.head = null;
            this.tail = null;

        } else if (index >= length) {
            return;

        } else {

            if (index == 0) {
                this.head = this.head.next;
            } else {
                Node currentNode = this.head;
                for (int i = 1; i < index; i++) {
                    currentNode = currentNode.next;
                }
                if (currentNode.next == this.tail) {
                    this.tail = currentNode;

                } else {
                    currentNode.next = currentNode.next.next;
                }
            }
        }
        this.length--;
    }

    /**
     * Clears the SinglyLinkedList by removing all Nodes
     */
    public void clearList() {
        if (this.head == null) {
            return;
        }
        while (this.length != 0) {
            this.remove(0);
        }
    }

    /**
     * Prints the SinglyLinkedList with brackets
     */
    public void printList() {
        if (this.head == null) {
            System.out.println("[]");
            return;
        }
        if (this.head == this.tail) {
            System.out.print("[" + this.head.data + "]\n");
            return;
        }
        Node currentNode = head;
        System.out.print("[" + currentNode.data);
        while (currentNode != this.tail) {
            currentNode = currentNode.next;
            System.out.print(", " + currentNode.data);
        }
        System.out.print("]\n");
    }

    /**
     * Prints the head and tail variables of the list.
     */
    public void printHeadAndTail() {
        if (this.head == null) {
            System.out.println("head: null tail: null");
        } else {
            System.out.println("head: " + this.head.data + " tail: " + this.tail.data);
        }
    }

    /**
     * Converts an Array to a SinglyLinkedList
     * 
     * @param arr to be converted to a SinglyLinkedList
     * @return SinglyLinkedList
     */
    public static SinglyLinkedList fromArray(int[] arr) {
        SinglyLinkedList newList = new SinglyLinkedList();
        if (arr.length == 0) {
            return newList;
        }
        for (int i : arr) {
            newList.add(i, -1);
        }
        return newList;
    }

    /**
     * Converts a SinglyLinkedList to an Array
     * 
     * @param list to be converted to an Array
     * @return Array
     */
    public static int[] toArray(SinglyLinkedList list) {
        int[] newArray = new int[list.length];
        if (list.length == 0) {
            return newArray;
        }
        Node currentNode = list.head;
        for (int i = 0; i < list.length; i++) {
            newArray[i] = currentNode.data;
            currentNode = currentNode.next;
        }
        return newArray;
    }

    /**
     * Deep copies a SinglyLinkedList
     * 
     * @param list to be copied
     * @return SinglyLinkedList
     */
    public static SinglyLinkedList deepCopy(SinglyLinkedList list) {
        SinglyLinkedList newList = new SinglyLinkedList();
        Node currentNode = list.head;
        for (int i = 0; i < list.length; i++) {
            newList.add(currentNode.data, -1);
            currentNode = currentNode.next;
        }
        return newList;
    }

    // IGNORE
    public static SinglyLinkedList[] splitMiddle(SinglyLinkedList list){SinglyLinkedList newList = new SinglyLinkedList();SinglyLinkedList secondList = deepCopy(list);if (list.length == 2){newList.add(secondList.head.data, 0);secondList.remove(0);return new SinglyLinkedList[] {newList, secondList };}Node slow = list.head;Node fast = list.head;while (fast.next != null && fast.next.next != null){newList.add(slow.data, -1);secondList.remove(0);slow = slow.next;fast = fast.next.next;}newList.add(slow.data, -1);secondList.remove(0);return new SinglyLinkedList[] {newList, secondList };}public static SinglyLinkedList sortedMerge(SinglyLinkedList listA, SinglyLinkedList listB){SinglyLinkedList out = new SinglyLinkedList();Node aHead = listA.head;Node bHead = listB.head;Node tail = new Node(0);while (true){if (aHead == null){tail.next = bHead;break;}    if (bHead == null){tail.next = aHead;break;}    if (aHead.data <= bHead.data){tail.next = aHead;aHead = aHead.next;} else{tail.next = bHead;bHead = bHead.next;}    out.add(tail.data, -1);tail = tail.next;}while (tail != null){out.add(tail.data, -1);tail = tail.next;}out.remove(0);return out;}public static SinglyLinkedList mergeSort(SinglyLinkedList list){if (list.length < 2){return list;}System.out.println('x');list.printList();SinglyLinkedList[] split = splitMiddle(list);SinglyLinkedList a = split[0];SinglyLinkedList b = split[0];SinglyLinkedList left = mergeSort(a);SinglyLinkedList right = mergeSort(b);SinglyLinkedList sortedlist = sortedMerge(left, right);return sortedlist;}
    // continue

    public static void main(String[] args) {
        int[] arr = { 5, 9, 2, 4, 1, 8, 7, 8, 4 };
        SinglyLinkedList myList = fromArray(arr);
        myList.printHeadAndTail();
        myList.printList();
        SinglyLinkedList myListCopy = deepCopy(myList);
        myListCopy.printList();
    }
}