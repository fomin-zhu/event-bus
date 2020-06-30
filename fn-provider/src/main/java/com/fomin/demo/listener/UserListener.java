package com.fomin.demo.listener;

import com.fomin.demo.model.event.UserEvent;
import com.fomin.demo.publisher.UserPublisher;
import com.google.common.eventbus.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fomin
 * @since 2020/6/30
 */
@Component
public class UserListener {

    @Autowired
    public UserListener(UserPublisher usePublisher) {
        usePublisher.register(this);
    }

    @Subscribe
    public void listenUserRegisterEvent(UserEvent userEvent) {
        System.out.println(userEvent.getCurrentTime() + " welcome to join us!");
    }
}
