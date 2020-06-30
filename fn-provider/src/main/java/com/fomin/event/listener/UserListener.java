package com.fomin.event.listener;

import com.fomin.event.model.entity.User;
import com.fomin.event.model.event.UserEvent;
import com.fomin.event.publisher.UserPublisher;
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
