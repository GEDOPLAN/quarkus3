package de.gedoplan.showcase.q3.frontend.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product {
  private Long number;
  private String name;
  private BigDecimal price;
}
