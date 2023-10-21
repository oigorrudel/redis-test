package br.xksoberbado.redistest.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.util.UUID;

@Getter
@Builder
@RedisHash("people")
//@RedisHash(timeToLive = 30L)
public class Person {

    @Id
    private UUID id;

    private String name;

    @TimeToLive
    private Long timeToLive;
}
