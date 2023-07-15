package org.acme.input;

import lombok.*;

/**
 * created by ronney
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TaskInput {
    private String name;
    private String description;
}
