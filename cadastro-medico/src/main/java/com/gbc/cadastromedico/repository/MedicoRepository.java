package com.gbc.cadastromedico.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbc.cadastromedico.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{
public List<Medico> findAllByNomeContainingIgnoreCase (String nome);
public Medico getByCrm(String crm);
public Medico getByCelular(String celular);
public Medico getByTelefone(String telefone);
}
