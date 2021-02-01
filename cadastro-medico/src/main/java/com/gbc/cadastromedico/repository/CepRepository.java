package com.gbc.cadastromedico.repository;

import com.gbc.cadastromedico.model.Cep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CepRepository extends JpaRepository<Cep, String> {
    public Cep getByCep(String cep);
}
