package customer.controller;

import customer.model.User;
import customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = "/{name}/birthday")
    @ResponseBody
    public String getUserBirthday(@PathVariable String name) {
        return userService.getUser(name).getBirthday();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{name}/age")
    @ResponseBody
    public int getUserAge(@PathVariable String name) {
        return userService.getUser(name).getAge();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/user")
    @ResponseBody
    public HttpStatus createUser(@RequestBody User user) {
        User tempUser = userService.createUser(user);
        return HttpStatus.CREATED;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/user/{name}")
    @ResponseBody
    public HttpStatus updateUser(@PathVariable String name, @RequestBody User user) {
        User tempUser = new User(name, user.getBirthday(), user.getAge());
        return HttpStatus.ACCEPTED;
    }
}