package myLinkedList;

import itemList.ListItem;
import itemList.NodeItem;

public class MyLinkedList implements ListItem {
    private int listSize;
    private NodeItem firstItem;
    private NodeItem lastItem;


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

        if (value == null || value.getValue() == null) {
            return false;
        }
        boolean result = false;
//        if there is no items in list, set first and last item as value, and increment size to one.
        if (firstItem == null) {
            firstItem = value;
            lastItem = value;
            listSize++;
        } else {
            result = addToList(firstItem, value);
        }
        return result;
    }

    // add item alphabetically, using recursion
    private boolean addToList(NodeItem current, NodeItem value) {
        int compare = current.compareTo(value);
        if (compare < 0) {
            NodeItem rightLink = current.next();
            if (rightLink == null) {
                //setLeftLink return current value, so it can be used to set right link to it
                value.setLeftLink(current).setRightLink(value);
                lastItem = value;
                listSize++;
                return true;
            }
//            if current  is less then value, run addToList recursively
            return addToList(rightLink, value);
// if current value is grater than value
        } else if (compare > 0) {
            NodeItem prev = current.previous();
            if (prev == null) {
                this.firstItem = value;
                this.firstItem.setRightLink(current);
                if (!current.hasNext()) {
                    lastItem = current;
                }

            } else {
                value.setLeftLink(prev).setRightLink(value);
                value.setRightLink(current).setLeftLink(value);
            }
            listSize++;
            return true;
        } else {
            return false;
        }


    }

    //TODO correct remove item
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
            int compare = node.compareTo(Item);
            if (compare == 0) {
                return remove(node);
            } else if (compare > 1) {
                return null;
            }
        }
        return null;
    }

    //     removes NodeItem from List
    private NodeItem remove(NodeItem node) {


        if (!node.hasNext() && !node.hasPrevious()) {
            firstItem = null;
            lastItem = null;
        } else if (!node.hasPrevious()) {
            firstItem = node.next();
            firstItem.setLeftLink(null);
        } else if (!node.hasNext()) {
            lastItem = node.previous();
            lastItem.setRightLink(null);
        } else {
            node.previous().setRightLink(node.next());
            node.next().setLeftLink(node.previous());
        }


        listSize--;
        return node;
    }


    @Override
    public NodeItem firstObject() {
        return firstItem;
    }

    @Override
    public NodeItem lastObject() {
        return lastItem;
    }

    //     Show all values in list
    @Override
    public void traverse() {
        NodeItem node = firstItem;
        if (node == null) {
            System.out.println("List is empty");
        } else {
            int index = 0;
            do {
                System.out.println(index + " : " + node.getValue());
                index++;
                node = node.next();
            } while (node != null);
        }

    }


    @Override
    public int listSize() {
        return listSize;
    }
}
