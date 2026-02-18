package berserk.task_app.domain.dto;

import berserk.task_app.domain.entity.TaskPriority;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record CreateTaskRequestDto(

        @NotEmpty(message = ERROR_MESSAGE_TITLE_LENGHT)
        @Length(max = 310, message = ERROR_MESSAGE_TITLE_LENGHT)
        String title,
        @Nullable
        @Length(max = 1000, message = ERROR_MESSAGE_DESCRIPTION_LENGTH)
        String description,
        @Nullable
        @FutureOrPresent(message = ERROR_MESSAGE_DUEDATE_TIME)
        LocalDate dueDate,
        @NotNull(message = ERROR_MESSAGE_PRIORITY_NOTNULL)
        TaskPriority priority // json will make sure value is an enum value
) {

    private static final String ERROR_MESSAGE_TITLE_LENGHT =
            "title value must be between 1 and 310"; // static why?
    private static final String ERROR_MESSAGE_DESCRIPTION_LENGTH =
            "description value must be LESS OR EQUAL 1000";
    private static final String ERROR_MESSAGE_DUEDATE_TIME =
            "DATE MUST BE IN THE FUTURE";
    private static final String ERROR_MESSAGE_PRIORITY_NOTNULL =
            "priority must not be null";
}
