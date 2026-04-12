package Week04;

import Structures.BinNode;

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

        print(root);
        System.out.println(root);
    }

    private static void print(BinNode<Integer> root) {
        if (root == null)
            return;
        System.out.println(root.getValue());
        while (root.hasLeft() || root.hasRight()) {
            if (root.hasRight())
                System.out.println(root.getRight().getValue());
            if (root.hasLeft())
                System.out.println(root.getLeft().getValue());
        }

    }

    private static void printMethod2(BinNode<Integer> root) {
        if (root == null)
            return;
        if (!root.hasRight() && !root.hasLeft())
            return;
        if (root.hasRight())
            System.out.println(root.getRight().getValue());
        if (root.hasLeft())
            System.out.println(root.getLeft().getValue());
        printMethod2(root.getRight());
        printMethod2(root.getLeft());

    }
    private static void printMethod3(BinNode<Integer> root) {
        if (root == null)
            return;
        printMethod3(root.getLeft());
        System.out.println(root.getValue());
        printMethod3(root.getRight());

    }
}
