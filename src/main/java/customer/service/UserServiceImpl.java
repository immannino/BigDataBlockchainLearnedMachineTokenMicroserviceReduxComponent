package customer.service;

import customer.data.UserRepository;
import customer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User getUser(String name) {
        return this.userRepository.findUserByName(name);
    }

    @Override
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }
}
