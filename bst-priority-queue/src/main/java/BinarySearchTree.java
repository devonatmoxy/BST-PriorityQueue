/**
 * Created by IntelliJ IDEA.
 * User: Devon
 * Date: 11/18/11
 * Time: 8:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearchTree<T extends Comparable> implements Tree<T> {


    private Vertex<T> head;
    private int size = 0;
    private StringBuilder traversalSB = new StringBuilder();

    public BinarySearchTree() {
        this.head = new Vertex<T>();
    }

    public void add(T obj) {
        if (peek() == null) {
            this.head = new Vertex(obj);
        } else {
            place(new Vertex(obj), head);
        }
    }

    private void place(Vertex nodeToPlace, Vertex currentNodeInTree) {
        verifyChildrenNotNull(currentNodeInTree);
        if (nodeToPlace.getValue().compareTo(currentNodeInTree.getValue()) <= 0) {
            if (currentNodeInTree.getLeftChild().getValue() == null) {
                currentNodeInTree.setLeftChild(nodeToPlace);
                nodeToPlace.setParent(currentNodeInTree);
                size++;
            } else {
                place(nodeToPlace, currentNodeInTree.getLeftChild());
            }
        } else {
            if (currentNodeInTree.getRightChild().getValue() == null) {
                currentNodeInTree.setRightChild(nodeToPlace);
                nodeToPlace.setParent(currentNodeInTree);
                size++;
            } else {
                place(nodeToPlace, currentNodeInTree.getRightChild());
            }
        }
    }

    private void verifyChildrenNotNull(Vertex currentNodeInTree) {
        if (currentNodeInTree.getLeftChild() == null) {
            currentNodeInTree.setLeftChild(new Vertex());
        }
        if (currentNodeInTree.getRightChild() == null) {
            currentNodeInTree.setRightChild(new Vertex());
        }
    }

    public T peek() {
        return this.head.getValue();
    }

    public T remove() {
        T headVal = head.getValue();
        T newHeadValue = null;
        if(head.getRightChild().getValue() != null)
            newHeadValue = remove(head.getRightChild());
        else if(head.getLeftChild().getValue() != null)
            newHeadValue = remove(head.getLeftChild());
        head.setValue(newHeadValue);
        return headVal;
    }

    private T remove(Vertex<T> v) {
        Vertex<T> inorder = null;
        T inorderValue = null;
        if(v.getValue().compareTo(head.getValue()) > 0){
            inorder = getFirstInorder(v);
            inorderValue = inorder.getValue();
            if(inorder.getRightChild() != null){
                inorder.setValue((T) inorder.getRightChild().getValue());
                inorder.getRightChild().setValue(null);
            }
        } else {
            inorder = getLastInorder(v);
            inorderValue = inorder.getValue();
            if(inorder.getLeftChild() != null){
                inorder.setValue((T)inorder.getLeftChild().getValue());
                inorder.getLeftChild().setValue(null);
            }
        }
        return inorderValue;
    }

    private T removeLeft(Vertex<T> v){
        Vertex<T> inorder = null;
        T inorderValue = null;
            inorder = getLastInorder(v);
            inorderValue = inorder.getValue();
            if(inorder.getLeftChild() != null){
                inorder.getLeftChild().setParent(v);
                v.setLeftChild(inorder.getLeftChild());
            }
        return inorderValue;
    }
    public Vertex getHead(){
        return this.head;
    }

    public Vertex getFirstInorder(Vertex v){
        if(v.getLeftChild() != null){
            if(v.getLeftChild().getValue() != null)
                return getFirstInorder(v.getLeftChild());
        }
        return v;
    }

    public Vertex getLastInorder(Vertex v){
        if(v.getRightChild() != null){
            if(v.getRightChild().getValue() != null)
                return getLastInorder(v.getRightChild());
        }
        return v;
    }

    private int find(T obj, Vertex v){
        if(v.getValue() == null)
            return -1;
        if(v.getValue().compareTo(obj) > 0)
            return 1 + find(obj, v.getLeftChild());
        return 1 + find(obj, v.getRightChild());
    }

    public int find(T obj) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int size() {
        return this.size;
    }

    private void addToStringBuilder(String value) {
        traversalSB.append(value + ", ");
    }

    private void traverseInorder(Vertex root) {
        if (root.getValue() == null)
            return;
        if (root.getLeftChild() != null)
            traverseInorder(root.getLeftChild());
        addToStringBuilder(root.getValue().toString());
        if (root.getRightChild() != null)
            traverseInorder(root.getRightChild());
    }

    public String inorder() {
        traversalSB = new StringBuilder();
        traverseInorder(head);
        String result = traversalSB.toString();
        return result.substring(0, result.length() - 2);
    }

    private void traversePreorder(Vertex root) {
        if (root.getValue() == null)
            return;
        addToStringBuilder(root.getValue().toString());
        if (root.getLeftChild() != null)
            traversePreorder(root.getLeftChild());
        if (root.getRightChild() != null)
            traversePreorder(root.getRightChild());
    }

    public String preorder() {
        traversalSB = new StringBuilder();
        traversePreorder(head);
        String result = traversalSB.toString();
        return result.substring(0, result.length() - 2);
    }

    private int calculateHeight(Vertex v){
        if(v == null)
            return -1;
        return Math.max(calculateHeight(v.getLeftChild()),
                calculateHeight(v.getRightChild())) +1;
    }
    public int height() {
        return calculateHeight(this.head);
    }
}
