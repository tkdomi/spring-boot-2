package pl.hqbusiness.springboot2.week2.services;

import pl.hqbusiness.springboot2.week2.model.Product;
import pl.hqbusiness.springboot2.week2.model.ShoppingCart;

import java.math.BigDecimal;

public interface ShopService {

  default void displayShoppingCart(ShoppingCart shoppingCart) {
    shoppingCart.getProducts().forEach(product -> System.out.println(product.getName() + " - " + calculatePrice(product)));
  }

  default void displayShoppingCartSummary(ShoppingCart shoppingCart) {
    BigDecimal shoppingCartSum = shoppingCart.getProducts()
      .stream()
      .map(this::calculatePrice)
      .reduce(BigDecimal.ZERO, BigDecimal::add);

    System.out.println("Summary: " + shoppingCartSum.toString());
  }

  default BigDecimal calculatePrice(Product product) {
    return product.getPrice();
  }
}

