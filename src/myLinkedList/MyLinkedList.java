package myLinkedList;

import itemList.ListItem;
import itemList.NodeItem;

public class MyLinkedList implements ListItem {
    private static int listSize;
    private NodeItem firstItem;
    private NodeItem lastObject;
    private NodeItem iterable;

    public MyLinkedList() {
        listSize = 0;
        firstItem = null;
        iterable = null;
    }

    public MyLinkedList(NodeItem firstItem) {
        this.firstItem = firstItem;
        this.iterable = firstItem;
        listSize = 1;
    }


    @Override
    public boolean addItem(NodeItem value) {

        if (value == null || value.getValue() == null) {
            return false;
        }
        boolean result = false;
        if (firstItem == null) {
            firstItem = value;
            lastObject = value;
            iterable = firstItem;
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
                lastObject = value;
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
    public NodeItem removeItem(int index) {


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
    public NodeItem next() {
        if (iterable.hasNext()) {
            iterable = iterable.next();
        } else {
            return null;
        }
        return iterable;
    }

    @Override
    public NodeItem previous() {
        if (iterable.hasPrevious()) {
            iterable = iterable.previous();
        } else {
            return null;
        }
        return iterable;
    }

    @Override
    public int listSize() {
        return listSize;
    }
}
