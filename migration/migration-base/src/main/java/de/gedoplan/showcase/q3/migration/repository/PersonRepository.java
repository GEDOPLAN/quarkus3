package de.gedoplan.showcase.q3.migration.repository;

import de.gedoplan.showcase.q3.migration.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PersonRepository {
  @Inject
  EntityManager entityManager;

  public Optional<Person> findById(String id) {
    return Optional.ofNullable(entityManager.find(Person.class, id));
  }

  public List<Person> findAll() {
    return entityManager.createQuery("select p from Person p", Person.class).getResultList();
  }

  @Transactional
  public void persist(Person person) {
    entityManager.persist(person);
  }
}
