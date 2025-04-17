#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.resources.impl;

import ${package}.model.bean.user.User;
import ${package}.service.user.UserService;
import ${package}.web.resources.UsersApi;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersResource implements UsersApi {

    private final UserService userService;

    @Override
    public ResponseEntity<User> getUserId(Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getUserIdWithRoles(Long id) {
        return new ResponseEntity<>(userService.findByIdWithRoles(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<User>> getUsers(Pageable pageable) {
        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }
}
