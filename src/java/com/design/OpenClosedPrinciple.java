package java.com.design;

/**
 * Open closed principle illustrates how code should be open for extension but closed for modification
 * We should be able to extend the functionality of the code for new requirements,
 * but should not change the existing classes for new functionality
 **/

import java.util.List;
import java.util.stream.Stream;


enum Color {
    RED, BLUE, GREEN, YELLOW
}

enum Size {
    SMALL, MEDIUM, LARGE, HUGE
}

interface Specification<T> {
    boolean isSatisfied(T item);
}


//Introducing two new interfaces which are open for extension

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> spec);
}

class Product {
    private String name;
    private Color color;
    private Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}

//Everytime a new specification is added,
// or a new filter based on other specification is needed,
// we just need to implement these interfaces, without changing existing classes/ code.

class SizeSpecification implements Specification<Product> {

    private Size size;

    public SizeSpecification(Size size) {
        this.size = size
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }
}

class ColorSpecification implements Specification<T> {
    private color;

    public ColorSpecification(Color color) {
        return this.color = color;
    }


    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color;
    }
}

class ProductFilter implements Filter<T> {

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(item -> spec.isSatisfied(item));
    }
}


public class OpenClosedPrinciple {
    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.RED, Size.SMALL);
        Product banana = new Product("Banana", Color.YELLOW, Size.SMALL);
        Product car = new Product("Car", Color.BLUE, Size.HUGE);

        List<Product> productList = List.of(apple, banana, car);

        ProductFilter filter = new ProductFilter();
        filter.filter(productList, new ColorSpecification(Color.RED)).
                forEach(p -> System.out.println(" - " + p.name + " is Red");
    }
}
