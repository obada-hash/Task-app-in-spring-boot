package berserk.task_app.controller;


import berserk.task_app.domain.dto.ErrorDto;
import berserk.task_app.exception.RecordNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleValidationException(MethodArgumentNotValidException ex){


         String message = ex.getBindingResult().getFieldErrors().stream()
                 .findFirst()
                 .map(DefaultMessageSourceResolvable::getDefaultMessage)
                 .orElse("Validation Error");

         ErrorDto errorDto = new ErrorDto(message);
         return new ResponseEntity<>(errorDto, HttpStatus.CONFLICT);

    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorDto> handleRecordNotFoundException(RecordNotFoundException ex){

        int id = ex.getId();
        String message = String.format("Record not found with id %d", id);
        ErrorDto errorDto = new ErrorDto(message);
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }


}
