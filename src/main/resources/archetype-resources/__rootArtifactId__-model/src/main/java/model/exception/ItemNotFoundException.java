#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ItemNotFoundException extends RuntimeException {

    private final Set<String> errors;
    private final String message;

    public ItemNotFoundException() {
        super("Item Not Found");
        this.message = "Item Not Found";
        this.errors = new HashSet<>();
    }

    public ItemNotFoundException(String message) {
        super(message);
        this.message = message;
        this.errors = new HashSet<>();
    }

    public ItemNotFoundException(String message, Set<String> errors) {
        super(message);
        this.message = message;
        this.errors = errors;
    }
}
