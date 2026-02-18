package berserk.task_app.exception;

import lombok.Getter;

@Getter
public class RecordNotFoundException extends RuntimeException {

    private final int id;

    public RecordNotFoundException(int id) {
        super(String.format("Record not found with id %d", id));
        this.id = id;
    }

}
