package itemList;

public interface ListItem {
    boolean addItem(NodeItem value);

    NodeItem removeItem(int index);

    NodeItem removeItem(NodeItem Item);

    NodeItem firstObject();

    NodeItem lastObject();

    NodeItem next();

    NodeItem previous();

    int listSize();


}
