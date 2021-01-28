package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Product firstProduct = new Product(1, "Упаковка", 0);
    private Product secondProduct = new Book(2, "Mastering SolidWorks", 6246, "Matt Lombard");
    private Product thirdProduct = new Smartphone(3, "iPhone 12 128GB, синий", 82480, "Apple");

    @BeforeEach
    public void setUp() {
        repository.save(firstProduct);
        repository.save(secondProduct);
        repository.save(thirdProduct);
    }

    @Test
    public void shouldDeleteProductById() {
        repository.removeById(1);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{secondProduct, thirdProduct};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotDeleteProductById() {
        assertThrows(NotFoundException.class, () -> repository.removeById(0));
    }
}
