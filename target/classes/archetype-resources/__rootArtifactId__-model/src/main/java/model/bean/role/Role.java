#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model.bean.role;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Role
 */

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-25T17:28:16.759132+01:00[Europe/Rome]", comments = "Generator version: 7.10.0")
public class Role {
  
  @JsonProperty("id")
  private Long id;

  @NotNull @Size(min = 3, max = 20) 
  @JsonProperty("description")
  private String description;

  @JsonProperty("users")
  private List<String> users = new ArrayList<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Role role = (Role) o;
    return Objects.equals(this.id, role.id) &&
        Objects.equals(this.description, role.description) &&
        Objects.equals(this.users, role.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, users);
  }

  @Override
  public String toString() {
    return "class Role {${symbol_escape}n" +
    "    id: " + toIndentedString(id) + "${symbol_escape}n" +
    "    description: " + toIndentedString(description) + "${symbol_escape}n" +
    "    users: " + toIndentedString(users) + "${symbol_escape}n" +
    "}";
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("${symbol_escape}n", "${symbol_escape}n    ");
  }
}

