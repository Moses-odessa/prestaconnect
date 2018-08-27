package ua.moses.prestaconnect.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ua.moses.prestaconnect.entity.Category;
import ua.moses.prestaconnect.entity.Product;

@AllArgsConstructor
@Getter
public enum SERVICES {
    CATEGORIES("categories", "category", Category.class),
    PRODUCTS("products", "product", Product.class);

    private String path;
    private String selector;
    private Class resourceClass;

}
