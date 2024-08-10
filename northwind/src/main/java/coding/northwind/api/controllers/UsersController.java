package coding.northwind.api.controllers;

import java.util.HashMap;
import java.util.Map;
//we got error but now we solve we were supposed to use this import
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import coding.northwind.business.abstracts.UserService;
import coding.northwind.core.entities.User;
import coding.northwind.core.utilities.results.ErrorDataResult;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {
    
    private UserService userService;
    
    @Autowired
    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }
    
    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user) {
        return ResponseEntity.ok(this.userService.add(user));
    }
    
    // Global exception handler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
            // Hata mesajlarını konsola yazdır
            System.out.println("Field: " + fieldError.getField() + ", Error: " + fieldError.getDefaultMessage());
        }
        return new ErrorDataResult<>(validationErrors, "Validation errors");
    }
}
