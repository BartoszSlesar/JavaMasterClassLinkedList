package itemList;

public interface ListItem {
    boolean addItem(NodeItem value);

    NodeItem removeItem(int index, NodeItem Item);

    NodeItem removeItem(NodeItem Item);

    NodeItem firstObject();

    NodeItem lastObject();

    int listSize();


}
