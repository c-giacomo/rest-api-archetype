#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.resources;

import ${package}.model.bean.user.User;
import ${package}.service.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = UsersApi.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class UserResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    @MockitoBean
    private UserService userService;

    @Test
    void findAllPagedExpectResult() throws Exception {
        List<User> list = List.of(
                new User(1L, "Giacomo", "Chiavolotti", "c.giacomo@hotmail.it", "c.giacomo@hotmail.it", List.of("ADMIN")),
                new User(2L, "Viktor", "Nicola", "v.nicola@hotmail.it", "v.nicola@hotmail.it", List.of("ADMIN"))
        );

        Pageable pageable = PageRequest.of(0, 10);
        Page<User> result = new PageImpl<>(list, pageable, list.size());

        Mockito.when(userService.findAll(isA(Pageable.class))).thenReturn(result);

        mockMvc.perform(get("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
                .andExpect(jsonPath("${symbol_dollar}.content").isArray())
                .andExpect(jsonPath("${symbol_dollar}.content.length()").value(2))
                .andExpect(jsonPath("${symbol_dollar}.totalElements").value(2))
                .andExpect(jsonPath("${symbol_dollar}.totalPages").value(1))
                .andExpect(jsonPath("${symbol_dollar}.pageable").exists())
                .andExpect(jsonPath("${symbol_dollar}.pageable.pageNumber").value(0))
                .andExpect(jsonPath("${symbol_dollar}.pageable.pageSize").value(10))
                .andExpect(jsonPath("${symbol_dollar}.first").value(true))
                .andExpect(jsonPath("${symbol_dollar}.last").value(true));
    }


    @Test
    void findByIdExpectResult() throws Exception {
        User user = new User(1L, "Giacomo", "Chiavolotti", "c.giacomo@hotmail.it", "c.giacomo@hotmail.it", List.of("ADMIN"));

        Mockito.when(userService.findById(1L)).thenReturn(user);

        mockMvc.perform(get("/api/v1/users/1"))
                .andExpectAll(
                        status().isOk(),
                        content().json(objectMapper.writeValueAsString(user))
                );
    }

}
