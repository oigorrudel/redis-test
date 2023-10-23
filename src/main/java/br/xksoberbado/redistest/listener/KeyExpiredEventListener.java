package br.xksoberbado.redistest.listener;

import br.xksoberbado.redistest.model.Person;
import br.xksoberbado.redistest.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisKeyExpiredEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KeyExpiredEventListener {

    private final PersonRepository repository;

    @EventListener
    public void onExpired(final RedisKeyExpiredEvent<Person> event) {
        final var person = (Person) event.getValue();
        log.info("Person: {}", person);

        repository.deleteById(person.getId());
    }
}
