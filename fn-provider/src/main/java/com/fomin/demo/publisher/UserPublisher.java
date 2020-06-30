package com.fomin.demo.publisher;

import com.fomin.demo.guaua.GuavaEventPublisher;
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
