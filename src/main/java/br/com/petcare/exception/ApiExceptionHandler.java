package br.com.petcare.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(CpfDuplicadoException.class)
    public ResponseEntity<Map<String, String>> tratarCpfDuplicado(CpfDuplicadoException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
            .body(Map.of("erro", ex.getMessage()));
    }
}
