package Week05;

import Structures.BinNode;

public class Main {

    static void main() {

        Integer[] PreOrder = {17, 14, 31, 48, 24, 24, 38, 10, 24, 26, 24};
        Integer[] InOrder = {48, 31, 24, 14, 24, 17, 10, 24, 38, 24, 26};

        BinNode<Integer> root = build(PreOrder, InOrder);
    }


    private static void inOrder(BinNode<Integer> root) {
        if (root == null)
            return;
        inOrder((root.getLeft()));
        System.out.print(" " + root.getValue());
        inOrder((root.getRight()));
    }

    private static void preOrder(BinNode<Integer> root) {

        if (root == null)
            return;
        System.out.print(" " + root.getValue());
        preOrder((root.getLeft()));
        preOrder((root.getRight()));
    }

    private static <T> BinNode<T> build(T[] o1, T[] o2) {
        return  null;
    }

}
