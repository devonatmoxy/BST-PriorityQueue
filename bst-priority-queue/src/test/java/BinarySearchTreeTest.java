import org.junit.Test;

import java.util.Random;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: Devon
 * Date: 11/18/11
 * Time: 8:48 AM
 * To change this template use File | Settings | File Templates.
 */

public class BinarySearchTreeTest {

    @Test
    public void headTest(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        assert(bst.peek() == null);
        bst.add(34);
        assert(bst.peek() == 34);
        bst.add(3);
        assert(bst.peek() == 34);
        bst.add(43);
        assert(bst.peek() == 34);
    }

    @Test
    public void addTest(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        Random ran = new Random();
        for(int i = 0; i < 50; i++){
            bst.add(ran.nextInt(50));
            assertEquals(i, bst.size());
        }
    }

    @Test
    public void preorderTest(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.add(25);
        bst.add(22);
        bst.add(34);
        bst.add(0);
        bst.add(3223);
        bst.add(3);
        String expected = "25, 22, 0, 3, 34, 3223";
        assertEquals(expected,bst.preorder());
    }

    @Test
    public void inorderTest(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.add(25);
        bst.add(22);
        bst.add(34);
        bst.add(0);
        bst.add(3223);
        bst.add(3);
        String expected = "0, 3, 22, 25, 34, 3223";
        assertEquals(expected,bst.inorder());
    }

    @Test
    public void firstInorderTest(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.add(25);
        bst.add(22);
        bst.add(34);
        bst.add(0);
        bst.add(3223);
        bst.add(3);
        bst.add(43);
        bst.add(41);
        bst.add(42);
        bst.add(35);

        int expected = 0;
        Vertex result = bst.getFirstInorder(bst.getHead());
        assertEquals(expected, result.getValue());
    }

    @Test
    public void lastInorderTest(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.add(25);
        bst.add(22);
        //bst.add(23);
        bst.add(34);
        bst.add(0);
        bst.add(3223);
        bst.add(3);
        int expected = 3223;

        // head
        Vertex result = bst.getLastInorder(bst.getHead());
        assertEquals(expected, result.getValue());

        // head's right child
        result = bst.getLastInorder(bst.getHead().getRightChild());
        assertEquals(expected, result.getValue());

        // head's left child
        expected = 22;
        result = bst.getLastInorder(bst.getHead().getLeftChild());
        assertEquals(expected, result.getValue());
    }

    @Test
    public void heightTest(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.add(25);
        bst.add(22);
        bst.add(34);
        bst.add(0);
        bst.add(3223);
        bst.add(3);
        bst.add(43);
        bst.add(41);
        bst.add(42);
        bst.add(35);
        int expected = 5;
        assertEquals(expected, bst.height());
    }

    @Test
    public void findTest(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.add(25);
        bst.add(22);
        bst.add(34);
        bst.add(0);
        bst.add(3223);
        bst.add(3);
        bst.add(43);
        bst.add(41);
        bst.add(42);
        bst.add(35);
    }

    @Test
    public void removeTest(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.add(25);
        bst.add(22);
        bst.add(34);
        bst.add(0);
        bst.add(3223);
        bst.add(3);
        String expected = "0, 3, 22, 25, 34, 3223";
        assertEquals(expected,bst.inorder());
        bst.remove();
        expected = "0, 3, 22, 34, 3223";
        assertEquals(expected,bst.inorder());
        bst.remove();
        expected = "0, 3, 22, 3223";
        assertEquals(expected,bst.inorder());

        // remove when root vertex right child is null
        bst = new BinarySearchTree<Integer>();
        bst.add(25);
        bst.add(22);
        bst.add(3);
        bst.add(14);
        bst.add(17);
        bst.add(15);
        expected = "3, 14, 15, 17, 22";
        bst.remove();
        assertEquals(expected, bst.inorder());
    }
}
