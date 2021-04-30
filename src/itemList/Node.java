package itemList;

public abstract class Node {
    protected Node next = null;
    protected Node previous = null;
    private Object value;


    public Node(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public abstract int compareTo(Node item);

    public abstract Node next();

    public abstract Node previous();

    public abstract void setNext(Node next);

    public abstract void setPrevious(Node setPrevious);


}
