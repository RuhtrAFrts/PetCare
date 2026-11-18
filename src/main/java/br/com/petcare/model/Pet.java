package br.com.petcare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pets")
public class Pet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String especie;
    private String raca;
    private Integer idade;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;
    protected Pet() {}
    public Pet(String nome, String especie, String raca, Integer idade, Tutor tutor) {
        this.nome = nome; this.especie = especie; this.raca = raca; this.idade = idade; this.tutor = tutor;
    }
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEspecie() { return especie; }
    public String getRaca() { return raca; }
    public Integer getIdade() { return idade; }
    public Tutor getTutor() { return tutor; }
}
