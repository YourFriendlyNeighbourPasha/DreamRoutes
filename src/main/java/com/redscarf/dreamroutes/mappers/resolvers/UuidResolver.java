package com.redscarf.dreamroutes.mappers.resolvers;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.UuidResolver
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 12.05.2022|02:58
 * @Version UuidResolver: 1.0
 */

@Component
public class UuidResolver {

    public String fromUUID(UUID uuid) {
        return uuid != null ? uuid.toString() : null;
    }

    public UUID fromString(String uuid) {
        return uuid != null ? UUID.fromString(uuid) : null;
    }

}
