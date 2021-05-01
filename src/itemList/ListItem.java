package itemList;

public interface ListItem {
    boolean addItem(Node value);

    Node removeItem(int index, Node Item);

    void firstObject();

    void lastObject();

    int listSize();

    Node removeItem(Node Item);

}
