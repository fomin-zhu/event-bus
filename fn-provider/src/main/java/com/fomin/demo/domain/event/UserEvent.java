package com.fomin.demo.domain.event;

import com.fomin.demo.guaua.BaseEvent;
import com.fomin.demo.domain.entity.User;

/**
 * @author fomin
 * @since 2020/6/30
 */
public class UserEvent extends BaseEvent {

    private User user;

    public UserEvent(User user) {
        this.user = user;
    }

    @Override
    protected String identify() {
        return "user-event";
    }
}
