package pl.hqbusiness.springboot2.week2.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
  List<Product> products = new ArrayList<>();

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }
}
