#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.user;

import ${package}.mapper.user.UserMapper;
import ${package}.model.bean.user.User;
import ${package}.orm.entities.user.UserEntity;
import ${package}.orm.repositories.user.UserEntityRepository;
import ${package}.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService extends AbstractService<Long, UserEntityRepository, UserMapper, UserEntity, User> {

    public UserService(UserMapper mapper, UserEntityRepository repository) {
        super(mapper, repository);
    }

    @Transactional(readOnly = true)
    public User findByIdWithRoles(Long id) {
        return super.findById(id);
    }

}
