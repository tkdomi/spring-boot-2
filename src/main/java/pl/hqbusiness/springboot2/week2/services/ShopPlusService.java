package pl.hqbusiness.springboot2.week2.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.hqbusiness.springboot2.week2.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@Profile("Plus")
public class ShopPlusService implements ShopService {

  @Value("${shop.vat}")
  private int vat;

  @Override
  public BigDecimal calculatePrice(Product product) {
    BigDecimal vatValue = calculateVat(product.getPrice());
    return product.getPrice().add(vatValue);
  }

  private BigDecimal calculateVat(BigDecimal price) {
    return price
      .multiply(BigDecimal.valueOf(vat))
      .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
  }
}
