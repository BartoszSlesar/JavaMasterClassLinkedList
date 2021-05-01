package myLinkedList;

import itemList.ListItem;
import itemList.NodeItem;

public class MyLinkedList implements ListItem {
    private int listSize;
    private NodeItem firstItem;
    private NodeItem lastItem;
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
            lastItem = value;
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
                lastItem = value;
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
                lastItem = current;
            }
            listSize++;
            return true;
        } else {
            return false;
        }


    }

    @Override
    public NodeItem removeItem(int index) {
        if (index > (this.listSize - 1) || index < 0) {
            return null;
        }
        NodeItem node = this.firstItem;
        if (!node.hasNext()) {
            listSize--;
            return remove(node);
        }

        int i = 0;
        while (node.hasNext()) {
            if (index == i) {
                return remove(node);
            }
            node = node.next();
            i++;
        }

        return null;
    }


    @Override
    public NodeItem removeItem(NodeItem Item) {
        if (listSize == 0) {
            return null;
        }
        NodeItem node = firstItem;
        if (node.compareTo(Item) == 0) {
            return remove(node);
        }
        while (node.hasNext()) {
            node = node.next();
            if (node.compareTo(Item) == 0) {
                return remove(node);
            }
        }
        return null;
    }

    //     removes NodeItem from List
    private NodeItem remove(NodeItem node) {
        if (node != null) {

            if (!node.hasNext() && !node.hasPrevious()) {
                firstItem = null;
                lastItem = null;
                iterable = null;
            } else if (!node.hasPrevious()) {
                firstItem = node.next();
                firstItem.setPrevious(null);
            } else if (!node.hasNext()) {
                lastItem = node.previous();
                lastItem.setNext(null);
            } else {
                node.previous().setNext(node.next());
                node.next().setPrevious(node.previous());
            }

        }
        listSize--;
        return node;
    }

    public void showAllValues() {
        NodeItem node = firstItem;
        int index = 0;
        do {
            System.out.println(index + " : " + node.getValue());
            index++;
        } while (node.hasNext());
    }

    @Override
    public NodeItem firstObject() {
        return firstItem;
    }

    @Override
    public NodeItem lastObject() {
        return lastItem;
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
