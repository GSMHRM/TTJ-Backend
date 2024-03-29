package com.gsmhrm.anything_back.domain.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("blackList")
public class BlackList {
    @Id
    private String accessToken;
    private String email;
    @TimeToLive
    private ZonedDateTime timeToLive;
}