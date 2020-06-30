package com.fomin.event.model.event;

import com.fomin.event.core.guaua.BaseEvent;
import com.fomin.event.model.entity.User;

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
