package myLinkedList;

import itemList.ListItem;
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
        boolean result = false;
        if (firstItem == null) {
            firstItem = value;
            lastObject = value;
            listSize++;
        } else {
            result = addToList(firstItem, value);
        }
        return result;
    }

    private boolean addToList(NodeItem current, NodeItem value) {
        int compare = current.compareTo(value);
        if (compare < 0) {
            NodeItem nextItem = current.next();
            if (nextItem == null) {
                value.setPrevious(current);
                current.setNext(value);
                listSize++;
                return true;
            }
            return addToList(nextItem, value);

        } else if (compare > 0) {
            NodeItem prev = current.previous();
            value.setNext(current);
            value.setPrevious(prev);
            if (prev == null) {
                this.firstItem = value;
            }
            if (!current.hasNext()) {
                lastObject = current;
            }
            listSize++;
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
