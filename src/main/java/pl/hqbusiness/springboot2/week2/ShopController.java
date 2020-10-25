package pl.hqbusiness.springboot2.week2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import pl.hqbusiness.springboot2.week2.model.Product;
import pl.hqbusiness.springboot2.week2.model.ShoppingCart;
import pl.hqbusiness.springboot2.week2.services.ShopService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

@Controller
public class ShopController {

    ShoppingCart shoppingCart = new ShoppingCart();

    ShopService shopService;

    @Autowired
    ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runShop() {
        initShoppingCart();
        displayShoppingCart();
    }

    private void displayShoppingCart() {
        System.out.println("Your Shopping Cart:");
        shopService.displayShoppingCart(shoppingCart);
        System.out.println("---------------");
        shopService.displayShoppingCartSummary(shoppingCart);
    }

    private void initShoppingCart(){
        shoppingCart.setProducts(Arrays.asList(
            new Product("Prod-1", generatePrice()),
            new Product("Prod-2", generatePrice()),
            new Product("Prod-3", generatePrice()),
            new Product("Prod-4", generatePrice()),
            new Product("Prod-5", generatePrice())
        ));
    }

    private BigDecimal generatePrice() {
        return BigDecimal.valueOf((Math.random() * (300 - 50) + 1) + 50).setScale(2, RoundingMode.HALF_DOWN);
    }
}
