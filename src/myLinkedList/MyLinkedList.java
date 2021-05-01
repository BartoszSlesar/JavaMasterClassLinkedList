package myLinkedList;

import itemList.ListItem;
import itemList.Node;
import itemList.NodeItem;

public class MyLinkedList implements ListItem {
    private static int listSize;
    private NodeItem firstItem;
    private NodeItem lastObject;

    public MyLinkedList() {
        listSize = 0;
        firstItem = null;
    }

    public MyLinkedList(NodeItem firstItem) {
        this.firstItem = firstItem;
        listSize = 1;
    }


    @Override
    public boolean addItem(NodeItem value) {
        if (value == null) {
            return false;
        }
        if (firstItem == null) {
            firstItem = value;
            lastObject = value;
            listSize++;
        } else {
            addToList(firstItem, value);
        }
        return false;
    }

    private boolean addToList(NodeItem current, NodeItem value) {
        int compare = current.compareTo(value);
        if (compare == -1) {
            NodeItem nextItem = current.next();
            if (nextItem == null) {
                value.setPrevious(current);
                current.setNext(value);
                listSize++;
                return true;
            }
            return addToList(nextItem, value);

        } else if (compare > 1) {
            NodeItem prev = current.previous();
            value.setNext(current);
            value.setPrevious(prev);
            if (prev == null) {
                this.firstItem = value;
            }
            if (!current.hasNext()) {
                lastObject = current;
            }
            return true;
        } else {
            return false;
        }


    }

    @Override
    public NodeItem removeItem(int index, NodeItem Item) {
        return null;
    }

    @Override
    public NodeItem removeItem(NodeItem Item) {
        return null;
    }

    @Override
    public NodeItem firstObject() {
        return firstItem;
    }

    @Override
    public NodeItem lastObject() {
        return lastObject;
    }

    @Override
    public int listSize() {
        return listSize;
    }
}
