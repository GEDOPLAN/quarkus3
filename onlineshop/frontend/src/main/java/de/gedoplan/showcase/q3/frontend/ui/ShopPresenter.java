package de.gedoplan.showcase.q3.frontend.ui;

import de.gedoplan.showcase.q3.frontend.model.Product;
import de.gedoplan.showcase.q3.frontend.repository.ProductRepository;
import de.gedoplan.showcase.q3.frontend.service.BasketService;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.math.BigDecimal;
import java.util.List;

@Named
@ViewScoped
public class ShopPresenter {
  BasketService basketService;

//  @Inject
  public ShopPresenter(BasketService basketService) {
    this.basketService = basketService;
  }

  @Inject
  ProductRepository productRepository;

  public String getShopname() {
    return basketService.getInfo();
  }

  public List<Product> getProductes() {
    return productRepository.getProducts();
  }

  public BigDecimal calculatePrice(Long number) {
    return basketService.calculate(number, 1);
  }
}
