#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.mapper;

public interface BaseMapper<T, V> {

    V map(T t);

    T mapReverse(V v);
}
