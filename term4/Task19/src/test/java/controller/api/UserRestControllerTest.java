package controller.api;


import model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import repository.UserRepository;

import java.util.Collections;

import static controller.api.fixture.RestDataFixture.standardUserJSON;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static repository.fixture.TestConstants.UserConstants.*;
import static repository.fixture.TestData.standardUser;

public class UserRestControllerTest {
    MockMvc mockMvc;

    private final String BASE_URL = "/api/user";

    @InjectMocks
    UserRestController controller;

    @Mock
    UserRepository userRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = standaloneSetup(controller)
                .setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
    }

    @Test
    public void thatFindUserById() throws Exception {
        //описываем поведение мока при вызове метода findOne
        when(userRepository.findOne(any(Long.class))).thenReturn(standardUser());
        //делаем GET-запрос и проверяем содержимое полученного json-документа
        this.mockMvc.perform(
                get(BASE_URL + "/{id}", 1L).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.name").value(USER_NAME))
                .andExpect(jsonPath("$.city").value(USER_CITY))
                .andExpect(jsonPath("$.gender").value(USER_GENDER.name()));
    }

    @Test
    public void thatFindUserById_NotFound() throws Exception {
        when(userRepository.findOne(any(Long.class))).thenReturn(null);
        this.mockMvc.perform(
                get(BASE_URL + "/{id}", 1L).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateUser() throws Exception {
        when(userRepository.save(any(User.class))).thenReturn(standardUser());
        this.mockMvc.perform(
                put(BASE_URL+ "/{id}", 1L)
                        .content(standardUserJSON())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //TODO 1. Добавить тест добавления нового пользователя
    @Test
    public void testCreateUser() throws Exception {
        when(userRepository.save(any(User.class))).thenReturn(standardUser());
        this.mockMvc.perform(
                post(BASE_URL)
                        .content(standardUserJSON())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    //TODO 2. Добавить тест удаления пользователя
    @Test
    public void testRemoveUser() throws Exception {
        this.mockMvc.perform(
                delete(BASE_URL + "/{id}", 1L)
                        .content(standardUserJSON())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }



    //TODO 4. Добавить тест метода поиска всех пользователей
    @Test
    public void testFindAll() throws Exception {
        when(userRepository.findAll()).thenReturn(Collections.singletonList(standardUser()));
        this.mockMvc.perform(
                get(BASE_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$[0].name").value(USER_NAME))
                .andExpect(jsonPath("$[0].city").value(USER_CITY))
                .andExpect(jsonPath("$[0].gender").value(USER_GENDER.name()))
                .andExpect(status().isOk());
    }

    @Test
    public void thatFindAll_NotFound() throws Exception {
        when(userRepository.findAll()).thenReturn(null);
        this.mockMvc.perform(
                get(BASE_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}
