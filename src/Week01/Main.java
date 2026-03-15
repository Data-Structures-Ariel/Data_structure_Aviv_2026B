package Week01;

import java.util.Random;

public class Main {
    static Random rd = new Random();

    static void main() {

        Node<Integer>
                chain = new Node<>(1);
        buildRand(chain,10);
        printChain(chain);

    }

    public static void buildRand(Node<Integer> chain, int size) {
        if (chain == null)
            return;
        for (int i = 0; i < size; i++) {
            Node<Integer> newNode = new Node<>(rd.nextInt(0, 2));
            chain.setNext(newNode);
            chain = chain.getNext();
        }
    }

    public static void printChain(Node<Integer> chain) {
        while (chain != null) {

            System.out.print(chain.getVal() + " -> ");
            chain = chain.getNext();
        }
        System.out.println("null");
    }

    public static boolean isBinaryChain(Node<Integer> chain) {


        return true;
    }


}
