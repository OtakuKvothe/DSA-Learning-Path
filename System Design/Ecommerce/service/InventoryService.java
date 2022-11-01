package Ecommerce.service;

import java.util.HashMap;

import Ecommerce.category.Category;
import Ecommerce.category.CategoryFactory;
import Ecommerce.model.item.Item;

public class InventoryService {
    
    private HashMap<String, Category> categories;

    public InventoryService() {
        categories = new HashMap<>();
    }

    public void addItem(String name, String category) {
        Item item = new Item(name, category);
        
    }

    private Category getCategory(String categoryName) {
        if(!categories.containsKey(categoryName)) {
            try {
                Category category = this.getNewCategory(categoryName);
                categories.put(categoryName, category);
                return category;
            } catch (Exception e) {
                throw new IllegalArgumentException(categoryName + " does not exist!");
            }
        } else {
            return categories.get(categoryName);
        }
    }

    private Category getNewCategory(String categoryName) {
        try {
            return CategoryFactory.getCategory(categoryName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
