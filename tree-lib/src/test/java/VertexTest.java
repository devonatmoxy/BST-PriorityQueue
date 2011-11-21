import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: Devon
 * Date: 11/18/11
 * Time: 7:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class VertexTest {

    @Test
    public void getValueTest(){
        Vertex<String> vertex = new Vertex<String>();
        String testString = "this is a test";
        vertex.setValue(testString);
        assertEquals(testString, vertex.getValue());
    }

    @Test
    public void getLeftChildTest(){
        Vertex<String> parent = new Vertex<String>();
        Vertex<String> leftChild = new Vertex<String>();
        Vertex<String> rightChild = new Vertex<String>();
        String parentString = "m";
        String leftChildString = "a";
        String rightChildString = "z";
        parent.setValue(parentString);
        leftChild.setValue(leftChildString);
        rightChild.setValue(rightChildString);

        parent.setLeftChild(leftChild);
        parent.setRightChild(rightChild);
        leftChild.setParent(parent);
        rightChild.setParent(parent);

        assertEquals(parent.getLeftChild(), leftChild);
        assertEquals(parent.getRightChild(), rightChild);
        assertEquals(rightChild.getParent(), parent);
        assertEquals(leftChild.getParent(), parent);
    }
}
