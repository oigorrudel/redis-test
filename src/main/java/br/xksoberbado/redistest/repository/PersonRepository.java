package br.xksoberbado.redistest.repository;

import br.xksoberbado.redistest.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonRepository extends CrudRepository<Person, UUID> {
}
