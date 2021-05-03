package main;

import myLinkedList.MyLinkedList;
import myLinkedList.Node;

public class MainListItem {

    public static void main(String[] args) {

//        Node first = new Node("a");
        MyLinkedList list = new MyLinkedList(new Node("Darwin"));
//        Node second = new Node("b");
//        list.addItem(second);
//        Node fifth = new Node("f");
//        Node fourth = new Node("c");
//        list.addItem(fifth);
//        list.addItem(fourth);
//        list.traverse();
        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";

        String[] data = stringData.split(" ");
        for (String s : data) {
            list.addItem(new Node(s));
        }

        list.traverse();

    }
}
