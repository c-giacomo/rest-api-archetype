#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.mapper.role;

import ${package}.orm.entities.role.RoleEntity;
import ${package}.mapper.BaseMapper;
import ${package}.model.bean.role.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<RoleEntity, Role> {

    @Override
    @Mapping(target = "users", ignore = true)
    Role map(RoleEntity roleEntity);

    @Override
    @Mapping(target = "users", ignore = true)
    RoleEntity mapReverse(Role role);
}
