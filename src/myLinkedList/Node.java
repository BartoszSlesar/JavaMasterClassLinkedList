package myLinkedList;

import itemList.NodeItem;

public class Node extends NodeItem {


    public Node() {
        super(null);
    }

    public Node(String value) {
        super(value);
    }


    @Override
    public int compareTo(NodeItem item) {
        int result = -1;
        if (item != null && item.getValue() != null) {
            String val = (String) super.getValue();
            result = val.compareToIgnoreCase((String) item.getValue());
        }

        return result;

    }

    @Override
    public NodeItem next() {
        return this.rightLink;
    }

    @Override
    public NodeItem previous() {
        return this.leftLink;
    }

    //    setting right reference to an object
    @Override
    public NodeItem setRightLink(NodeItem rightLink) {
        this.rightLink = rightLink;
        return this.rightLink;
    }

    //    setting left reference to an object
    @Override
    public NodeItem setLeftLink(NodeItem previous) {
        this.leftLink = previous;
        return this.leftLink;
    }

}
