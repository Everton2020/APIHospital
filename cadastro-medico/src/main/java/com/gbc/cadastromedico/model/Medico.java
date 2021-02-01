package com.gbc.cadastromedico.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Entity
@Table (name = "tb_medico")
public class Medico {
	
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private long id;

@NotNull
@Size(min = 2, max = 120)
private String nome;

@NotNull
private String crm;

private String telefone;

private String celular;

@ManyToOne
@JsonIgnoreProperties("medico")
private Cep cep;

@ManyToOne
@JsonIgnoreProperties("medico")
private Especialidade especialidade;

@ManyToOne
@JsonIgnoreProperties("medico")
private Especialidade_2 especialidade_2;

}