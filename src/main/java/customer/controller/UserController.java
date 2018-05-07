package customer.controller;

import customer.model.User;
import customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = "/{name}/birthday")
    @ResponseBody
    public ResponseEntity <String> getUserBirthday(@PathVariable String name) {
        User tempUser = userService.getUser(name);

        if (tempUser != null) {
            return new ResponseEntity<String>(tempUser.getBirthday(), HttpStatus.OK);
        }

        return new ResponseEntity<String>("User Not Found", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{name}/age")
    @ResponseBody
    public ResponseEntity getUserAge(@PathVariable String name) {
        User tempUser = userService.getUser(name);

        if (tempUser != null) {
            return new ResponseEntity<Integer>(tempUser.getAge(), HttpStatus.OK);
        }

        return new ResponseEntity<String>("User Not Found", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/user")
    @ResponseBody
    public HttpStatus postCreateUser(@RequestBody User user) {
        boolean isNew = userService.getUser(user.getName()) == null ? true : false;

        if (isNew) {
            userService.createUser(user);

            return HttpStatus.CREATED;
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/user/{name}")
    @ResponseBody
    public HttpStatus putUpdateUser(@PathVariable String name, @RequestBody User user) {
        User tempUser = userService.getUser(name);

        if (tempUser != null) {
            tempUser.setAge(user.getAge());
            tempUser.setBirthday(user.getBirthday());

            userService.updateUser(tempUser);

            return HttpStatus.ACCEPTED;
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}