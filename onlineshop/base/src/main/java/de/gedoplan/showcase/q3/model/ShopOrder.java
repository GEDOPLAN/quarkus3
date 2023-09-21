package de.gedoplan.showcase.q3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShopOrder {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String customer;
  private Long productNumber;

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    if (this.id == null) {
      return false;
    }
    ShopOrder other = (ShopOrder) obj;
    return Objects.equals(this.id, other.id);
  }

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", customer='" + customer + '\'' +
        '}';
  }
}
