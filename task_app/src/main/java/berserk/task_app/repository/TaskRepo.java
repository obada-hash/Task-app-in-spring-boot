package berserk.task_app.repository;

import berserk.task_app.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
}
