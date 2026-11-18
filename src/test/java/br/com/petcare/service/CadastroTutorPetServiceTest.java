package br.com.petcare.service;

import br.com.petcare.dto.CadastroTutorPetRequest;
import br.com.petcare.exception.CpfDuplicadoException;
import br.com.petcare.model.Tutor;
import br.com.petcare.model.Pet;
import br.com.petcare.repository.TutorRepository;
import br.com.petcare.repository.PetRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CadastroTutorPetServiceTest {
    @Test
    void naoDeveCadastrarCpfDuplicado() {
        TutorRepository tutores = mock(TutorRepository.class);
        PetRepository pets = mock(PetRepository.class);
        when(tutores.existsByCpf("12345678901")).thenReturn(true);
        CadastroTutorPetService service = new CadastroTutorPetService(tutores, pets);
        CadastroTutorPetRequest request = new CadastroTutorPetRequest(
            "Ana", "12345678901", "34999999999", "Rex", "Cachorro", "SRD", 3
        );
        assertThrows(CpfDuplicadoException.class, () -> service.cadastrar(request));
        verify(tutores, never()).save(any(Tutor.class));
        verify(pets, never()).save(any(Pet.class));
    }
}
