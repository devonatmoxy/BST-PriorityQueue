/**
 * Created by IntelliJ IDEA.
 * User: Devon
 * Date: 11/18/11
 * Time: 7:33 AM
 */
public class Vertex<T extends Comparable> {
    private T value;
    private Vertex leftChild;
    private Vertex rightChild;
    private Vertex parent;

    public Vertex(){

    }

    public Vertex(T val){
        this.value = val;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Vertex getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Vertex leftChild) {
        this.leftChild = leftChild;
    }

    public Vertex getRightChild() {
        return rightChild;
    }

    public void setRightChild(Vertex rightChild) {
        this.rightChild = rightChild;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public void delete(){
        if((this.getLeftChild() != null && this.getLeftChild().getValue() != null)
                && (this.getRightChild() != null && this.getRightChild().getValue() != null)){
                    throw new RuntimeException("A vertex cannot delete itself if it has two children.");
        }

        if(this.getRightChild() != null && this.getRightChild().getValue() != null){
                this.setValue((T) this.getRightChild().getValue());
                this.getRightChild().setValue(null);
        } else if(this.getLeftChild() != null && this.getLeftChild().getValue() != null){
                this.setValue((T) this.getLeftChild().getValue());
                this.getLeftChild().setValue(null);
        } else {
            this.setValue(null);
        }
        
    }
}
