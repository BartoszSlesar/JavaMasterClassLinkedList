package main;

import myLinkedList.MyLinkedList;
import myLinkedList.Node;

public class MainListItem {

    public static void main(String[] args) {

        Node first = new Node("a");
        MyLinkedList list = new MyLinkedList(first);
        Node second = new Node("b");
        list.addItem(second);
        Node fifth = new Node("f");
        Node fourth = new Node("c");
        list.addItem(fifth);
        list.addItem(fourth);
        System.out.println(list.listSize());

//        System.out.println("ala".compareToIgnoreCase("aga"));
    }
}
