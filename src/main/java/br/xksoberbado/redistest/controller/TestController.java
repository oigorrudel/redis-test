package br.xksoberbado.redistest.controller;

import br.xksoberbado.redistest.model.Person;
import br.xksoberbado.redistest.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TestController {

    private final PersonRepository repository;

    @PostConstruct
    void setup() {
        final var person = Person.builder()
            .id(UUID.randomUUID())
            .name("Pedro")
            .timeToLive(15L)
            .build();

        repository.save(person);
    }

    @GetMapping
    public List<Person> get() {
        return Optional.ofNullable(repository.findAll())
            .map(iterable -> StreamSupport.stream(iterable.spliterator(), false))
            .map(Stream::toList)
            .orElse(Collections.emptyList());
    }
}
