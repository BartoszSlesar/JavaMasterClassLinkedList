package itemList;

public class Node extends NodeItem {

    public Node(String value) {
        super(value);
    }


    @Override
    public int compareTo(NodeItem item) {
        int result = -1;
        if (item != null) {
            String val = (String) super.getValue();
            result = val.compareTo((String) item.getValue());
        }

        return result;

    }

    @Override
    public NodeItem next() {
        return this.next;
    }

    @Override
    public NodeItem previous() {
        return this.previous;
    }

    @Override
    public void setNext(NodeItem next) {
        this.next = next;
    }

    @Override
    public void setPrevious(NodeItem setPrevious) {
        this.previous = previous;
    }

    public boolean hasNext() {
        return this.next() != null;
    }
}
