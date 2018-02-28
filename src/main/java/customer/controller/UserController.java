package customer.controller;

import customer.model.User;
import customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = "/{name}/birthday")
    @ResponseBody
    public Map getUserBirthday(@PathVariable String name) {
        return Collections.singletonMap("birthday", userService.getUser(name).getBirthday());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{name}/age")
    @ResponseBody
    public Map getUserAge(@PathVariable String name) {
        return Collections.singletonMap("age", userService.getUser(name).getAge());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/user")
    @ResponseBody
    public HttpStatus postCreateUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        HttpStatus returnStatus = (newUser != null ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
        return returnStatus;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/user/{name}")
    @ResponseBody
    public HttpStatus putUpdateUser(@PathVariable String name, @RequestBody User user) {
        User tempUser = new User(name, user.getBirthday(), user.getAge());
        User updatedUser = userService.updateUser(tempUser);
        HttpStatus returnStatus = (updatedUser != null ? HttpStatus.ACCEPTED : HttpStatus.INTERNAL_SERVER_ERROR);
        return returnStatus;
    }
}