package customer.service;

import customer.model.User;
import org.springframework.stereotype.Service;

/**
 * Service for User operations.
 */
@Service
public interface UserService {

    /**
     * createUser
     *
     * Adds a new user to the list of users.
     *
     * @param user User to be added.
     * */
    User createUser(User user);

    /**
     * getUser
     *
     * Returns the user's information.
     *
     * @param name Name of user requesting data.
     * */
    User getUser(String name);

    /**
     * updateUser
     *
     * Updates information for the user.
     *
     * @param user The user and information to be updated.
     * */
    User updateUser(User user);
}