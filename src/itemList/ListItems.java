package itemList;

import org.w3c.dom.ls.LSOutput;

public abstract class ListItems {
    private ListItems next;
    private ListItems previous;
    private String value;

    public void setNext(ListItems next) {
        this.next = next;
    }

    public void setPrevious(ListItems previous) {
        this.previous = previous;
    }
}
