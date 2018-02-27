package customer.service;

import customer.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public User createUser(User user) {
        return user;
    }

    @Override
    public User getUser(String name) {
        return new User(name, "December 6th, 1993", 24);
    }

    @Override
    public User updateUser(User user) {
        return new User(user.getName(), user.getBirthday(), user.getAge());
    }
}
