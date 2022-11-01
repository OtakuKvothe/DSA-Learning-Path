package Ecommerce.model.trie;

import java.util.ArrayList;
import java.util.List;

import Ecommerce.model.item.Item;

public class Node {
    public Node[] next;
    public List<Item> items;

    public Node() {
        next = new Node[256];
        items = new ArrayList<>();
    }
}
