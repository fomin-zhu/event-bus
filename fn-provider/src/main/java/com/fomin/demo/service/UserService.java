package com.fomin.demo.service;

import com.fomin.demo.model.entity.User;
import com.fomin.demo.model.event.UserEvent;
import com.fomin.demo.publisher.UserPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fomin
 * @since 2020/6/30
 */
@Service
public class UserService {
    @Autowired
    private UserPublisher publisher;

    public void register(String name, Integer age) {
        publisher.publish(new UserEvent(new User(name, age)));
    }
}
