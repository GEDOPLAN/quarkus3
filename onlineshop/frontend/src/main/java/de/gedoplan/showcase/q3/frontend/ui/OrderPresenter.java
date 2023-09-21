package de.gedoplan.showcase.q3.frontend.ui;

import de.gedoplan.showcase.q3.model.ShopOrder;
import de.gedoplan.showcase.q3.rest.OrderResource;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Named
@ViewScoped
public class OrderPresenter {
  @RestClient
  OrderResource orderResource;

  @Inject
  FacesContext facesContext;

  @Getter
  @Setter
  private String customer;

  public void placeOrder(Long number) {
    try {
      var response = orderResource.createOrder(ShopOrder.builder().productNumber(number).customer(customer).build());
      facesContext.addMessage(null, new FacesMessage("Bestellung aufgegeben", response.getHeaderString("location")));
    } catch (Exception exception) {
      facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", exception.getLocalizedMessage()));
    }
  }
}
