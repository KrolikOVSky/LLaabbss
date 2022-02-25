import java.util.*;

public class LinkedList<T extends Comparable<T>> extends AbstractSequentialList<T> {
    private Node<T> head;
    private Node<T> current;
    private int size;

    public LinkedList() {
        this.head = null;
        this.current = null;
        this.size = 0;
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

    public T getOne(int number) {
        if (number >= size) return null;
        current = head;
        for (int i = 0; i < number; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void sort() {
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
        current = null;
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        current = head;
        output.append("null");
        while (current != null) {
            output.append(" <- ").append(current.data.toString());
            current = current.next;
        }
        return output.append("\n\r").toString();
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
        while (current != null) {
            if (current.data == o) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        current = head;
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                var el = current.data;
                current = current.next;
                return el;
            }
        };
    }

    @Override
    public Object[] toArray() {
        current = head;
        Object[] result = new Object[this.size()];
        int i = 0;
        while (current != null) {
            result[i++] = current.data;
            current = current.next;
        }
        return result;
    }

    @Override
    public boolean add(T t) {
        Node<T> node = new Node<>(t);
        if (isEmpty()) {
            head = node;
            this.size++;
            this.sort();
            return true;
        }

        current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        this.size++;
        this.sort();
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(isEmpty() || !contains(o)) return false;
        var current = head;
        int i = 0;
        while (current != null) {
            if (current.data.equals(o)) {
                remove(i);
                return true;
            }
            i++;
            current = current.next;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (isEmpty() || index >= size()) throw new NullPointerException("No elements in list");              //exit 1
        Node<T> deleted;
        if (index == 0) {
            deleted = new Node<>(head);
            head = head.next;
            --size;
            return deleted.data;
        }

        Node<T> old = head;
        current = head.next;
        for (int i = 1; i < index; i++) {
            old = current;
            current = current.next;
        }
        deleted = current;
        old.next = current.next;
        --size;
        this.sort();
        return deleted.data;
    }

    @Override
    public void clear() {
        this.head = null;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        if(collection.isEmpty()) return false;
        for (var el : collection) {
            add(el);
        }
        return true;
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        throw new NullPointerException("Not configured method");
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        throw new NullPointerException("Not configured method");
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new NullPointerException("Not configured method");
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new NullPointerException("Not configured method");
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        throw new NullPointerException("Not configured method");
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node() {
            this.data = null;
            this.next = null;
        }

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(Node<T> node) {
            this.data = node.data;
            this.next = node.next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

}
