package br.com.petcare.service;

import br.com.petcare.dto.*;
import br.com.petcare.exception.CpfDuplicadoException;
import br.com.petcare.model.*;
import br.com.petcare.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroTutorPetService {
    private final TutorRepository tutorRepository;
    private final PetRepository petRepository;

    public CadastroTutorPetService(TutorRepository tutorRepository, PetRepository petRepository) {
        this.tutorRepository = tutorRepository;
        this.petRepository = petRepository;
    }

    @Transactional
    public CadastroTutorPetResponse cadastrar(CadastroTutorPetRequest request) {
        if (tutorRepository.existsByCpf(request.cpf())) {
            throw new CpfDuplicadoException("Já existe um tutor cadastrado com este CPF.");
        }

        Tutor tutor = new Tutor(request.nomeTutor(), request.cpf(), request.telefone());
        Tutor tutorSalvo = tutorRepository.save(tutor);

        Pet pet = new Pet(request.nomePet(), request.especie(), request.raca(),
                          request.idade(), tutorSalvo);
        Pet petSalvo = petRepository.save(pet);

        return new CadastroTutorPetResponse(
            tutorSalvo.getId(), tutorSalvo.getNome(), tutorSalvo.getCpf(),
            petSalvo.getId(), petSalvo.getNome(), petSalvo.getEspecie()
        );
    }
}
