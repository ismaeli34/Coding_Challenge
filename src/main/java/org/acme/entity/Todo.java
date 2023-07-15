package org.acme.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
/**
 * created by ronney
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Todo  {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "todo", cascade = CascadeType.PERSIST)
    private List<Task> tasks;

}
