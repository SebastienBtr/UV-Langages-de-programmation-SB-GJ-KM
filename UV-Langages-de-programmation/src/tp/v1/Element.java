package tp.v1;

public class Element<E> {

    private Element next;
    private E value;

    public Element(E value) {
        this.next = null;
        this.value = value;
    }

    public Element getNext() {
        return this.next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
