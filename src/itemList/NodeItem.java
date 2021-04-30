package itemList;

public abstract class NodeItem {
    protected NodeItem next = null;
    protected NodeItem previous = null;
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

    public abstract int compareTo(NodeItem item);

    public abstract NodeItem next();

    public abstract NodeItem previous();

    public abstract void setNext(NodeItem next);

    public abstract void setPrevious(NodeItem setPrevious);


}
