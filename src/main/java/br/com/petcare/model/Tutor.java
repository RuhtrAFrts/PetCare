package br.com.petcare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tutores", uniqueConstraints = @UniqueConstraint(columnNames = "cpf"))
public class Tutor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(nullable = false, unique = true)
    private String cpf;
    private String telefone;
    protected Tutor() {}
    public Tutor(String nome, String cpf, String telefone) {
        this.nome = nome; this.cpf = cpf; this.telefone = telefone;
    }
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getTelefone() { return telefone; }
}
