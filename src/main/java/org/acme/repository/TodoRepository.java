package org.acme.repository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Todo;

/**
 * created by ronney
 */
@ApplicationScoped
public class TodoRepository implements PanacheRepository<Todo> {
}
