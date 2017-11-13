<<<<<<< HEAD:UV-Langages-de-programmation/src/tp/v1/Element.java
package tp.v1;

=======
package tp1;
/**
 * An element of the the lane linked to another
 * @param <E> the value of the element
 */
>>>>>>> bf47f2e671a7676eb49cd3dda2a097fbcb71b655:UV-Langages-de-programmation/src/tp1/Element.java
public class Element<E> {
    /**Attribute to know the next element of the lane*/
    private Element next;
    private E value;
    /**
     * Constructor of an Element
     * @param value - The value of the element
     */
    public Element(E value) {
        this.next = null;
        this.value = value;
    }
    /**
     * @return the next element of the lane
     */
    public Element getNext() {
        return this.next;
    }
    /**
     * Set the next element
     * @param next - the next element of the lane
     */
    public void setNext(Element next) {
        this.next = next;
    }
    /**
     * @return - the value of the element
     */
    public E getValue() {
        return value;
    }
    /**
     * Set the new value of the element
     * @param value - the new value to set
     */
    public void setValue(E value) {
        this.value = value;
    }
}