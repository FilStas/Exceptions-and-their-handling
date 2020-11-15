package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.exceptions.NotFoundException;

public class ProductManager {
    Product[] products = new Product[0];

    public void add(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];

        System.arraycopy(products, 0, tmp, 0, products.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (findById(id) == null) {
                throw new NotFoundException  ("Element with id: " + id + " not found");
            }
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }


}
