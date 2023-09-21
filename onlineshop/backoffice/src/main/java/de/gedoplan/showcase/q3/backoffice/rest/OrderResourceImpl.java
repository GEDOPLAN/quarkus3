package de.gedoplan.showcase.q3.backoffice.rest;

import de.gedoplan.showcase.q3.backoffice.repository.OrderRepository;
import de.gedoplan.showcase.q3.model.ShopOrder;
import de.gedoplan.showcase.q3.rest.OrderResource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;

@Path("order")
@RequestScoped
public class OrderResourceImpl implements OrderResource {
  @Inject
  OrderRepository orderRepository;

  @Context
  UriInfo uriInfo;

  @Transactional
  @Override
  public Response createOrder(ShopOrder shopOrder) {
    if (shopOrder.getId() != null) {
      return Response.status(Response.Status.BAD_REQUEST).header("error", "id should be null").build();
    }
    orderRepository.persist(shopOrder);
    var location = uriInfo.getAbsolutePathBuilder().path(shopOrder.getId().toString()).build();
    return Response.created(location).build();
  }
}
