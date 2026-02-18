package berserk.task_app.domain.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description")
    private String description;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "status", nullable = false)
    private TaskStatus status;
    @Column(name = "priority", nullable = false)
    private TaskPriority priority;

    @Column(name = "create_date", nullable = false, updatable = false)
    @CreationTimestamp
    private Instant created;
    @Column(name = "update_date", nullable = false)
    @UpdateTimestamp
    private Instant updated;
}
