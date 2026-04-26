package Week06;

import Structures.BinNode;
import Week06.task.BST;
import Week06.task.Student;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //--------------------Level 0 ----------------------------
        BinNode<Integer> root = new BinNode<>(17);
        //--------------------Level 1 ----------------------------
        root.setLeft(new BinNode<>(36));
        root.setRight(new BinNode<>(7));
        //--------------------Level 2 ----------------------------
        root.getLeft().setLeft(new BinNode<>(12));
        root.getRight().setRight(new BinNode<>(0));
        root.getRight().setLeft(new BinNode<>(28));
        //--------------------Level 3 ----------------------------
        root.getLeft().getLeft().setLeft(new BinNode<>(10));
        root.getLeft().getLeft().setRight(new BinNode<>(42));
        root.getRight().getRight().setRight(new BinNode<>(1));
        //--------------------Level 4 ----------------------------
        root.getRight().getRight().getRight().setRight(new BinNode<>(70));


        levelOrder(root);
        System.out.println(root);

        int value = 6;
        add(root, value);
        levelOrder(root);
        insert(root, value);
        levelOrder(root);
        BinNode<Integer> root1 = null;
        for (int i = 0; i < 100000; i++) {
            root1 = insertToBST(root1, i);
//            levelOrder(root1);
        }

        BST<Student> studentBST = new BST<Student>();
    }

    private static void add(BinNode<Integer> root, int value) {
        if (root == null)
            return;

        boolean bool = new Random().nextBoolean();
        if (bool) {
            add(root.getLeft(), value);
            if (!root.hasLeft())
                root.setLeft(new BinNode<>(value));
        } else {
            add(root.getRight(), value);
            if (!root.hasRight())
                root.setRight(new BinNode<>(value));
        }
    }

    private static <E> BinNode<E> insert(BinNode<E> root, E value) {
        if (root == null)
            return new BinNode<>(value);

        boolean bool = new Random().nextBoolean();
        if (bool)
            root.setLeft(insert(root.getLeft(), value));
        else
            root.setRight(insert(root.getRight(), value));

        return root;
    }

    private static void addToBST(BinNode<Integer> root, int value) {
        if (root == null)
            return;

        boolean bool = root.getValue() > value;
        if (bool) {
            addToBST(root.getLeft(), value);
            if (!root.hasLeft())
                root.setLeft(new BinNode<>(value));
        } else {
            addToBST(root.getRight(), value);
            if (!root.hasRight())
                root.setRight(new BinNode<>(value));
        }
    }

    private static BinNode<Integer> insertToBST(BinNode<Integer> root, Integer value) {
        if (root == null)
            return new BinNode<>(value);

        boolean bool = root.getValue() > value;
        if (bool)
            root.setLeft(insertToBST(root.getLeft(), value));
        else
            root.setRight(insertToBST(root.getRight(), value));

        return root;
    }

    private static void levelOrder(BinNode<Integer> root) {
        if (root == null)
            return;

        Queue<BinNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinNode<Integer> item = q.poll();
            if (item.hasLeft())
                q.add(item.getLeft());
            if (item.hasRight())
                q.add(item.getRight());
            System.out.print(item.getValue() + " ");
        }
        System.out.println();
    }
}
