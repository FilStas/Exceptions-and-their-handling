package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.exceptions.NotFoundException;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {
    ProductManager manager = new ProductManager();
    Product first = new Product(1, "book 1", 230);
    Product second = new Product(2, "book 2", 340);
    Product third = new Product(3, "book 3", 560);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }


    @Test
    void shouldRemoveByIdSuccessfully() {
        int idToRemove = 3;

        manager.removeById(idToRemove);

        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{first, second};

        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldRemoveByIdMistake() {
        int idToRemove = 4;

        manager.removeById(idToRemove);

        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{first, second, third};


        assertArrayEquals(actual, expected);

    }
}