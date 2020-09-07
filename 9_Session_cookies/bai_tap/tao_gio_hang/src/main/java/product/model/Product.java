package product.model;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private String content;
    private int cost;

    public Product() {
    }

    public Product(int id, String name, String content, int cost) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                cost == product.cost &&
                Objects.equals(name, product.name) &&
                Objects.equals(content, product.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, content, cost);
    }
}
