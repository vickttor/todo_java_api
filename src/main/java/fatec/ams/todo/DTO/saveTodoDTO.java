package fatec.ams.todo.DTO;

import fatec.ams.todo.enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class saveTodoDTO {
    private String name;
    private String description;
    private String responsible;
    private Priority priority;
    private boolean checked;
}
