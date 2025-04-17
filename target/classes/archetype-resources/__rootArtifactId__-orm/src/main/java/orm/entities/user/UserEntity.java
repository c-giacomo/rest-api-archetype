#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.orm.entities.user;

import ${package}.orm.entities.role.RoleEntity;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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
@Table(name = "users")
public class UserEntity extends Persistence implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(length = 20)
    private String name;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(length = 20)
    private String surname;

    @NotNull
    @Size(min = 3, max = 30)
    @Column(length = 30)
    private String username;

    @Size(min = 3, max = 30)
    @jakarta.validation.constraints.Email
    @Column(length = 30)
    private String email;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<@Valid RoleEntity> roles = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(username, that.username) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, username, email);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '${symbol_escape}'' +
                ", surname='" + surname + '${symbol_escape}'' +
                ", username='" + username + '${symbol_escape}'' +
                ", email='" + email + '${symbol_escape}'' +
                ", roles=" + roles.stream().map(RoleEntity::getDescription).collect(Collectors.joining(";")) +
                '}';
    }
}
