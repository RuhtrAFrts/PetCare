package br.com.petcare.controller;

import br.com.petcare.dto.*;
import br.com.petcare.service.CadastroTutorPetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cadastros")
public class TutorPetController {
    private final CadastroTutorPetService service;

    public TutorPetController(CadastroTutorPetService service) {
        this.service = service;
    }

    @PostMapping("/tutor-pet")
    @ResponseStatus(HttpStatus.CREATED)
    public CadastroTutorPetResponse cadastrar(@Valid @RequestBody CadastroTutorPetRequest request) {
        return service.cadastrar(request);
    }
}
