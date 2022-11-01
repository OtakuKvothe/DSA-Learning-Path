package Ecommerce.category;

import Ecommerce.category.categories.ApparelsCategory;
import Ecommerce.category.categories.ElectronicsCategory;

public class CategoryFactory {
    public static Category getCategory(String categoryType) {
        switch (categoryType.toLowerCase()) {
            case "electronics":
                return new ElectronicsCategory();
            
            case "apparels":
                return new ApparelsCategory();
        
            default:
                throw new IllegalArgumentException();
        }
    }
}
