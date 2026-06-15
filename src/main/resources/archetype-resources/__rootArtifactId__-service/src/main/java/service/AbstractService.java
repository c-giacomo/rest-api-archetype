#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import ${package}.mapper.BaseMapper;
import ${package}.model.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*****
 *
 * @param <I> id of object to search
 * @param <R> repository
 * @param <M> mapper
 * @param <T> source type
 * @param <V> return type
 */

@RequiredArgsConstructor
public abstract class AbstractService<I, R extends JpaRepository<T, I>, M extends BaseMapper<T, V>, T, V> {

    protected final M mapper;
    protected final R repository;

    public Page<V> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::map);
    }

    public List<V> findAll() {
        return repository.findAll().stream().map(mapper::map).toList();
    }

    public V findById(I id) {
        return repository.findById(id).map(mapper::map).orElseThrow(ItemNotFoundException::new);
    }
}
