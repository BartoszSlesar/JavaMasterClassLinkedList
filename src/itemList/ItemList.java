package itemList;

public class ItemList extends Node {


    public ItemList(String value) {
        super(value);
    }


    @Override
    public int compareTo(Node item) {
        String value = (String) super.getValue();
        return value.compareTo((String) item.getValue());
    }

    @Override
    public Node next() {
        return null;
    }

    @Override
    public Node previous() {
        return null;
    }

    @Override
    public void setNext(Node next) {

    }

    @Override
    public void setPrevious(Node setPrevious) {

    }

    public boolean hasNext() {
        return this.next() != null;
    }
}
