package Ecommerce.category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Ecommerce.model.item.Item;
import Ecommerce.model.trie.Node;

public abstract class Category {

    private Node trie;

    public Category() {
        trie = new Node();
    }

    public void addItem(Item item) {
        Node node = searchTrieToInsertNode(item.getName());
        node.items.add(item);
    }

    public List<String> getItems(String searchString) {
        if(searchString == null || searchString.length() == 0) {
            return Collections.emptyList();
        }
        Node last = searchForString(searchString);
        List<Item> items = new ArrayList<>();
        itemsFromSubTrees(last, items);
        return items.stream().map(Item::getName).toList();
    }

    private void itemsFromSubTrees(Node node, List<Item> result) {
        if(node == null) return;
        result.addAll(node.items);
        for(Node next: node.next) {
            if(next == null) continue;
            itemsFromSubTrees(next, result);
        }
    }

    private Node searchForString(String string) {
        if(string == null || string.length() == 0) {
            return null;
        }
        Node curr = trie;
        for(int i=0; i<string.length(); i++) {
            char c = string.charAt(i);
            if(curr.next[c] == null) {
                return null;
            }
            curr = curr.next[c];
        }
        return curr;
    }

    private Node searchTrieToInsertNode(String name) {
        Node curr = trie;
        for(int i=0; i<name.length(); i++) {
            char c = name.charAt(i);
            if(curr.next[c] == null) {
                curr.next[c] = new Node();
            }
            curr = curr.next[c];
        }
        return curr;
    }
}
