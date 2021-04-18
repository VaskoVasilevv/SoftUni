package Workshop;



import java.util.function.Consumer;

public class DoublyLinkedList {
    private Node tail;
    private Node head;
    private int size;


    private static class Node {
        private int element;
        private Node next;
        private Node previous;

        public Node(int item) {
            this.element = item;
        }
    }
    public int removeLast(){

        int removedElement = this.tail.element;

        return removedElement;
    }

    public int removeFirst(){
        if(this.isEmpty()){
            throw new IllegalStateException("The data structure you're trying ti remove is not exist");

        }
        int element = this.head.element;
        this.head = this.head.next;
        this.size--;

        return element;
    }


    public void addLast(int element){
        if (isEmpty()){
            addFirst(element);
            return;
        }

        Node newNode = new Node(element);
        this.tail.next = newNode;
        newNode.previous = this.tail;
        this.tail = newNode;
        this.size++;

    }

    public void addFirst(int element){
        Node newNode = new Node(element);
        if (this.head != null){
            newNode.next = this.head;
            this.head.previous = newNode;
        }
        this.head = newNode;

        if (isEmpty()){
            this.tail = this.head;
        }
        this.size++;
    }

    public int[] toArray(){
        int[] array = new int[this.size];

        Node current = this.head;
        int index =0;

        while (current != null){
            array[index++] = current.element;
            current = current.next;
        }

        return array;
    }

    public void forEach(Consumer<Integer> consumer){
        Node current = this.head;

        while (current != null){
            consumer.accept(current.element);
            current = current.next;
        }
    }


    public int get(int index){
        validateIndx(index);

        Node current = this.head;
        int currentIndex = 0;
        int element = 0;
        while (current != null){
            if (index == currentIndex){
                element =  current.element;
                break;
            }
            currentIndex++;
            current = current.next;
        }
        return  element;

    }

    private void validateIndx(int index) {
        if (index<0 || index>= this.size){
            throw new IllegalArgumentException(String.format("Index: %d. size: %d - There is not such index"
            ,index,this.size));
        }
    }



    public int getSize() {
        return this.size;
    }
    public  boolean isEmpty(){
        return size == 0;
    }
}
