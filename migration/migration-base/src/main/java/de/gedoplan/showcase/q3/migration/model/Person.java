package de.gedoplan.showcase.q3.migration.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Size(min = 2)
  private String firstname;
  @Size(min = 2)
  private String lastname;
  @Email
  private String email;

  public String getFullname() {
    return firstname + " " + lastname;
  }

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
    Person other = (Person) obj;
    return Objects.equals(this.id, other.id);
  }

  @Override
  public String toString() {
    return "Person{" +
        "id='" + id + '\'' +
        ", firstname='" + firstname + '\'' +
        ", lastname='" + lastname + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
