package customer.controller;

import com.fasterxml.jackson.annotation.JacksonInject;
import customer.model.User;
import customer.service.UserService;
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
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private JacksonTester<User> jsonTester;

    @Test
    public void getUserBirthdayByNameTest() throws Exception {
        given(this.userService.getUser("Tony"))
                .willReturn(new User("Tony", "birthday", 0));

        mockMvc.perform(get("/Tony/birthday")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"birthday\":\"birthday\"}"));
    }

    @Test
    public void getUserAgeByNameTest() throws Exception {
        given(this.userService.getUser("Tony"))
                .willReturn(new User("Tony", "birthday", 0));

        mockMvc.perform(get("/Tony/age")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"age\":0}"));
    }

//    @Test
//    public void postCreateUserTest() throws Exception {
//        User tempUser = new User("Tony", "Birthday", 0);
//
//        given(this.userService.createUser(tempUser))
//                .willReturn(new User("Tony", "February 27th, 2018", 0));
//
//        mockMvc.perform(post("/user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonTester.write(tempUser).getJson()))
//                .andExpect(status().isCreated());
//    }
//
//    @Test
//    public void postCreateUserTestError() throws Exception {
//        User tempUser = new User("Tony", "Birthday", 0);
//
//        given(this.userService.createUser(tempUser))
//                .willReturn(null);
//
//        mockMvc.perform(post("/user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonTester.write(tempUser).getJson()))
//                .andExpect(status().isInternalServerError());
//    }
//
//    @Test
//    public void putUpdateUserTest() throws Exception {
//        User tempUser = new User("Tony", "Birthday", 0);
//
//        given(this.userService.getUser("Tony"))
//                .willReturn(new User("Tony", "February 27th, 2018", 0));
//
//        mockMvc.perform(get("/user/Tony")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonTester.write(tempUser).getJson()))
//                .andExpect(status().isAccepted());
//    }
//
//    @Test
//    public void putUpdateUserTestError() throws Exception {
//        User tempUser = new User("Tony", "Birthday", 0);
//
//        given(this.userService.getUser("Tony"))
//                .willReturn(null);
//
//        mockMvc.perform(get("/user/Tony", tempUser)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonTester.write(tempUser).getJson()))
//                .andExpect(status().isInternalServerError());
//    }
}