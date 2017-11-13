<<<<<<< HEAD:UV-Langages-de-programmation/src/tp/v1/Lane.java
package tp.v1;

=======
package tp1;
/**
 * Interface of a model for a Lane (succession of element)
 * @param <E> the type of element in the list
 */
>>>>>>> bf47f2e671a7676eb49cd3dda2a097fbcb71b655:UV-Langages-de-programmation/src/tp1/Lane.java
public interface Lane<E> {

    /**
     * Add an element to the lane
     */
    public void pushElem(E e);

    /**
     * Remove an element of the lane
     * @return The element removed
     */
    public Object popElem();

    /**
     * Check if the lane is empty
     * @return true if the lane is empty
     */
    public boolean isEmpty();

    /**
     * @return the lane's length
     */
    public int getLength();
}