package com.fomin.event.publisher;

import com.fomin.event.core.guaua.GuavaEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author fomin
 * @since 2020/6/30
 */
@Component
public class UserPublisher extends GuavaEventPublisher {
    @Override
    public String identify() {
        return "user-event";
    }
}
