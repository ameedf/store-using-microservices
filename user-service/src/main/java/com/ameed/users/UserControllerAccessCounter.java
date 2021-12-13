package com.ameed.users;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "users-controller-counter")
public class UserControllerAccessCounter {

    private final UserController userController;

    public UserControllerAccessCounter(UserController userController) {
        this.userController = userController;
    }

    @ReadOperation
    public int getCounter() {
        return userController.getCounter();
    }

    @WriteOperation
    public void updateCounter(int amount) {
        userController.setCounter(userController.getCounter() + amount);
    }

    @DeleteOperation
    public void resetCounter() {
        userController.setCounter(0);
    }
}
