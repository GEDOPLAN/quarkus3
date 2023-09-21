package de.gedoplan.showcase.q3.rest;

import de.gedoplan.showcase.q3.model.ShopOrder;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("order")
public interface OrderResource {
  @POST
  public Response createOrder(ShopOrder shopOrder);
}
