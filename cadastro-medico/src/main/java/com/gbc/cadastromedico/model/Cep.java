package com.gbc.cadastromedico.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_cep")
public class Cep {
    @Id
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    @OneToMany(mappedBy = "cep", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("cep")
    private List<Medico> medico;

}