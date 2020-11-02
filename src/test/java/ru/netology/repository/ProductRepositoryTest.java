package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductRepositoryTest {

    @Test
    void removeById() {
        ProductManager manager = new ProductManager();
        int idToRemove = 3;
        Product first = new Product(1, "book 1", 230);
        Product second = new Product(2, "book 2", 340);
        Product third = new Product(3, "book 3", 560);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{first, second};

        assertArrayEquals(actual, expected);
    }
}