package com.gbc.cadastromedico.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gbc.cadastromedico.model.Especialidade;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
	public List<Especialidade> findAllByNomeContainingIgnoreCase (String nome);
}
