package fatec.ams.todo.models;

import fatec.ams.todo.enums.Priority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_todos")
public class Todo {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(name = "nome")
    private String name;
    private String description;
    private String responsible;

    @Enumerated(EnumType.STRING)
    private Priority priority;
    private boolean checked;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
