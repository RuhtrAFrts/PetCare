package br.com.petcare.dto;

import jakarta.validation.constraints.*;

public record CadastroTutorPetRequest(
    @NotBlank String nomeTutor,
    @NotBlank @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 números") String cpf,
    @NotBlank String telefone,
    @NotBlank String nomePet,
    @NotBlank String especie,
    String raca,
    @NotNull @Min(0) Integer idade
) {}
