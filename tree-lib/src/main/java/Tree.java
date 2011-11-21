/**
 * Created by IntelliJ IDEA.
 * User: Devon
 * Date: 11/18/11
 * Time: 7:31 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Tree<T> {

    /**
     * adds a new item to the tree
     * @param obj the item to add to the tree
     */
    void add(T obj);

    /**
     * returns the head of the tree
     * @return T the head element of the tree
     */
    T peek();

    /**
     * removes the head of the tree and returns it
     * @return T the head element of the tree
     */
    T remove();

    /**
     * returns the position of an element in the tree
     * @param obj the element to search for
     * @return int the position of the element in the tree, or -1 if it is not found
     */
    int find(T obj);

    /**
     * returns the size of the tree
     * @return int the number of elements in the tree
     */
    int size();

    /**
     * returns an in-order, comma-separated string of every element in the tree
     * @return string comma-separated string of every element in the tree
     */
    String inorder();

    /**
     * returns a pre-order, comma-separated string of every element in the tree
     * @return string comma-separated string of every element in the tree
     */
    String preorder();

    /**
     * returns the height of the tree
     * @return int the height of the tree
     */
    int height();

}
