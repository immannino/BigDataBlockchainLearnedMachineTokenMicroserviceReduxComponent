package customer.controller;

import com.fasterxml.jackson.annotation.JacksonInject;
import customer.model.User;
import customer.service.UserService;
import customer.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
public class UserServiceTests {

    private UserService service;

    @Before
    public void setup() {
        this.service = new UserServiceImpl();
    }

    @Test
    public void createUserTest() throws Exception {
        User tempUser = new User("Tony", "Birthday", 24);
        User serviceResponseUser = service.createUser(tempUser);

        assertEquals(tempUser.getName(), serviceResponseUser.getName());
        assertEquals(tempUser.getBirthday(), serviceResponseUser.getBirthday());
        assertEquals(tempUser.getAge(), serviceResponseUser.getAge());
    }

    @Test
    public void getUser() throws Exception {
        User tempUser = new User("Tony", "Birthday", 24);
        User serviceResponseUser = service.createUser(tempUser);

        assertEquals(tempUser.getName(), serviceResponseUser.getName());
        assertEquals(tempUser.getBirthday(), serviceResponseUser.getBirthday());
        assertEquals(tempUser.getAge(), serviceResponseUser.getAge());
    }

    @Test
    public void updateUser() throws Exception {
        User tempUser = new User("Tony", "Birthday", 24);
        User serviceResponseUser = service.createUser(tempUser);

        assertEquals(tempUser.getName(), serviceResponseUser.getName());
        assertEquals(tempUser.getBirthday(), serviceResponseUser.getBirthday());
        assertEquals(tempUser.getAge(), serviceResponseUser.getAge());
    }
}