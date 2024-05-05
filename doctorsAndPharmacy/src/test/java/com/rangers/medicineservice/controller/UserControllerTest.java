package com.rangers.medicineservice.controller;

import com.rangers.medicineservice.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.apache.logging.log4j.ThreadContext.isEmpty;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalMatchers.not;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes= User.class)
@AutoConfigureMockMvc
@DisplayName("Test class for UserController")
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String userTestId = "72971ae6-58e3-4081-9095-06742628dab1";

    @Test
    void createUserTest() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.post("/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "firstname": "Test firstname of user",
                                  "lastname": "Test lastname of user",
                                  "email": "email",
                                  "phoneNumber": "phoneNumber",
                                  "address": "address",
                                  "city": "city",
                                  "country": "country",
                                  "postalCode": "postalCode",
                                  "policyNumber": "12344321",
                                  "chatId": "001"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname", is("Test firstname of user")))
                .andExpect(jsonPath("$.lastname", is("Test lastname of user")))
                .andExpect(jsonPath("$.policyNumber", is("12344321")))
                .andExpect(jsonPath("$.chatId", is("001")));
    }

    @Test
    void getUserByIdTest() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/user/" + userTestId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId", is(userTestId)));
    }

    @Test
    void getUserByIdNegativeTest() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/user/" + userTestId))
                .andExpect(status().isNotFound());
    }

    @Test
    void getUserIdByChatIdTest() throws Exception {
        String userIdActual = mockMvc
                .perform(MockMvcRequestBuilders.get("/user/chatId/001"))
                .andExpect(status().isOk())
                .andReturn().toString();
        assertEquals(userTestId,userIdActual);
    }

    @Test
    void updateUserTest() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.post("/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "userId": "72971ae6-58e3-4081-9095-06742628dab1",
                                  "firstname": "New",
                                  "lastname": "User",
                                  "policyNumber": "345543"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname", is("New")))
                .andExpect(jsonPath("$.lastname", is("User")))
                .andExpect(jsonPath("$.policyNumber", is("345543")));
    }

    @Test
    void getUserHistoryOrdersTest() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/user/history/orders/userId/"+userTestId))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.orderId", not(isEmpty())))
                .andExpect((ResultMatcher) jsonPath("$.quantity", not(isEmpty())))
                .andExpect((ResultMatcher) jsonPath("$.name", not(isEmpty())));
    }

    @Test
    void getUserHistorySchedulesTest() {
    }

    @Test
    void getUserHistoryPrescriptionsTest() {
    }
}