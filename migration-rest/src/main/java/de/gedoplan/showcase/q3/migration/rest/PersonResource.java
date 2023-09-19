package de.gedoplan.showcase.q3.migration.rest;

import de.gedoplan.showcase.q3.migration.model.Person;
import de.gedoplan.showcase.q3.migration.repository.PersonRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class PersonResource {
  @Inject
  PersonRepository personRepository;

  @GET
  public List<Person> getAllPersons() {
    return personRepository.findAll();
  }

  @GET
  @Path("{id}")
  public Person getPerson(@PathParam("id") String id) {
    return personRepository.findById(id).orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
  }

  @POST
  public Response createPerson(Person person, @Context UriInfo uriInfo) {
    if (person.getId() != null) {
      return Response.status(Response.Status.BAD_REQUEST).header("error", "id is not empty").build();
    }
    personRepository.persist(person);
    return Response.created(
        uriInfo
            .getAbsolutePathBuilder()
            .path(person.getId().toString())
            .build())
        .build();
  }
}
