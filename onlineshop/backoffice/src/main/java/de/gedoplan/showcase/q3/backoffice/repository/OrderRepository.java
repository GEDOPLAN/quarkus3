package de.gedoplan.showcase.q3.backoffice.repository;

import de.gedoplan.showcase.q3.model.ShopOrder;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<ShopOrder> {
}
