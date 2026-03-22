package Week02;

import Week01.Node;

public class Mahat_Summer_2022A {

    static void main() {
        Node<Integer> chain = new Node<>(5, new Node<>(20, new Node<>(9, new Node<>(6, new Node<>(5, new Node<>(8, new Node<>(2)))))));
        print(chain);
        Node<Integer> difference = differenceList(chain);
        print(difference);
        int survive = theSurvives(chain);
        System.out.println(survive);

    }

    private static int theSurvives(Node<Integer> chain) {
        if (chain == null)
            throw new IllegalArgumentException();

        while (chain.hasNext()) {
            print(chain);
            chain = differenceList(chain);
        }
        print(chain);
        return chain.getVal();
    }

    public static void print(Node<Integer> chain) {

        while (chain != null) {
            System.out.print(chain.getVal() + ", ");
            chain = chain.getNext();

        }
        System.out.println("");

    }

    public static Node<Integer> add(Node<Integer> chain, int value) {
        if (chain == null)
            return new Node<Integer>(value);
        Node<Integer> head = chain;
        while (chain.hasNext())
            chain = chain.getNext();

        chain.setNext(new Node<Integer>(value));

        return head;

    }

    private static Node<Integer> differenceList(Node<Integer> chain) {

        if (chain == null)
            return null;

        Node<Integer> diff = null;
        while (chain.hasNext()) {
            int d = Math.abs(chain.getVal() - chain.getNext().getVal());
            diff = add(diff, d);
            chain = chain.getNext();
        }

        return diff;
    }
}
