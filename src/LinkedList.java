import java.util.Collection;
import java.util.Iterator;

public class LinkedList<T extends Comparable<T>> implements Collection<T>{
    private Node<T> head;
    private Node<T> current;
    private int size;

    public LinkedList() {
    }

    public LinkedList(Node<T> node) {
        this.head = node;
    }

    public LinkedList(LinkedList<T> linkedList) {
        this.size = linkedList.size();
        if (linkedList.size == 1) {
            this.head = new Node<>(linkedList.head.data);
            return;
        }
        Node<T> current = linkedList.head;
        while (current != null) {
            this.add(current.data);
            current = current.next;
        }
    }

    public Node<T> remove(int number) {
        if (head == null || number >= size) return null;              //exit 1
//        if (number >= size) return null;    //exit 2
        if (number == 0) {
            Node<T> deleted = new Node<>(head);
            head = head.next;
            return deleted;
        }
        Node<T> old = head;
        current = head.next;
        for (int i = 1; i < number; i++) {
            old = current;
            current = current.next;
        }
        old.next = current.next;
        size--;
        this.sort();
        return current;                             //exit 3
    }

    public Node<T> getOne(int number) {
        if (number >= size) return null;
        current = head;
        for (int i = 0; i < number; i++) {
            current = current.next;
        }
        return current;
    }

    private void sort() {
        if (head.next != null) {
            Node<T> last = null;
            Node<T> current = this.head;
            boolean flag = false;
            do {
                if (current.data.compareTo(current.next.data) < 0) {
                    Node<T> temp = current.next;
                    current.next = current.next.next;
                    if (last == null) {
                        temp.next = current;
                        this.head = temp;
                    } else {
                        last.next = temp;
                        last.next.next = current;
                    }
                    flag = true;
                }

                if (flag) {
                    current = this.head;
                    flag = false;
                    last = null;
                } else {
                    last = current;
                    current = current.next;
                }
            }
            while (current.next != null);
        }
    }

    public void swap(int node1, int node2){

    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        current = head;
        while (current != null) {
            output.append(current.data.toString()).append(" -> ");
            current = current.next;
        }
        return output.append("null\n\r").toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    @Override
    public boolean contains(Object o) {
        current = head;
        while(current.next != null){
            if(current.data == o) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public T next() {
                return current.data;
            }
        };
    }

    @Override
    public Object[] toArray() {
        current = head;
        Object[] result = new Object[this.size()];
        int i = 0;
        while (current.next != null){
            result[i] = current.data;
            i++;
            current = current.next;
        }
        return result;
    }

    //todo don't understand
    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }
}
