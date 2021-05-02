package itemList;

public abstract class NodeItem {
    protected NodeItem rightLink = null;
    protected NodeItem leftLink = null;
    private Object value;

    public NodeItem(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean hasNext() {
        return rightLink != null;
    }
    public boolean hasPrevious() {
        return leftLink != null;
    }

    public abstract int compareTo(NodeItem item);

    public abstract NodeItem next();

    public abstract NodeItem previous();

    public abstract NodeItem setRightLink(NodeItem rightLink);

    public abstract NodeItem setLeftLink(NodeItem setPrevious);


}
