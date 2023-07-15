package org.acme.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * created by ronney
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TodoInput {
    private String name;
    private String description;
    private List<TaskInput> tasks;

}
