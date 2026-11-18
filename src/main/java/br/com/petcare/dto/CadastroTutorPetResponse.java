package br.com.petcare.dto;

public record CadastroTutorPetResponse(
    Long tutorId, String nomeTutor, String cpf,
    Long petId, String nomePet, String especie
) {}
