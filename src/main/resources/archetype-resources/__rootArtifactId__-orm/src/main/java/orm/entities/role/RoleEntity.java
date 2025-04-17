#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.orm.entities.role;

import ${package}.orm.entities.user.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class RoleEntity extends Persistence implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(length = 20)
    private String description;

    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", description='" + description + '${symbol_escape}'' +
                ", users=" + users.stream().map(UserEntity::getUsername).collect(Collectors.joining(";")) +
                '}';
    }
}
