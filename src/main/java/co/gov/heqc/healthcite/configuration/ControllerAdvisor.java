package co.gov.heqc.healthcite.configuration;

import co.gov.heqc.healthcite.exceptions.PeopleNoDataFoundException;
import co.gov.heqc.healthcite.exceptions.PersonNotFoundException;
import co.gov.heqc.healthcite.utils.constants.GlobalConstants;
import co.gov.heqc.healthcite.utils.constants.PeopleConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errorMessages = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (error instanceof FieldError fieldError) {
                errorMessages.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
            } else {
                errorMessages.add(error.getDefaultMessage());
            }
        }
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Map<String, String>> handleAuthenticationException(AuthenticationException authException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap(
                        GlobalConstants.RESPONSE_ERROR_MESSAGE_KEY,
                        GlobalConstants.WRONG_CREDENTIALS_MESSAGE));
    }
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePersonNotFoundException(PersonNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(
                        GlobalConstants.RESPONSE_ERROR_MESSAGE_KEY,
                        PeopleConstants.PERSON_NOT_FOUND_MESSAGE));
    }
    @ExceptionHandler(PeopleNoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handlePeopleNoDataFoundException(PeopleNoDataFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(
                        GlobalConstants.RESPONSE_ERROR_MESSAGE_KEY,
                        PeopleConstants.PEOPLE_NO_DATA_FOUND_MESSAGE));
    }

}
