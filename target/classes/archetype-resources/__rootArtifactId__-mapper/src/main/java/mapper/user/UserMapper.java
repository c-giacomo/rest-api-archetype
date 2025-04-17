#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.mapper.user;

import ${package}.mapper.BaseMapper;
import ${package}.model.bean.user.User;
import ${package}.orm.entities.role.RoleEntity;
import ${package}.orm.entities.user.UserEntity;
import org.hibernate.LazyInitializationException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring", imports = RoleEntity.class)
public interface UserMapper extends BaseMapper<UserEntity, User> {

    @Override
    @Mapping(target = "roles", source = "roles", qualifiedByName = "roleToString")
    User map(UserEntity userEntity);

    @Override
    @Mapping(target = "roles", ignore = true)
    UserEntity mapReverse(User user);

    @Named("roleToString")
    default List<String> roleToString(List<RoleEntity> roles) {
        try {
            return roles.stream().map(RoleEntity::getDescription).toList();
        } catch (LazyInitializationException ex) {
            return Collections.emptyList();
        }
    }

}
