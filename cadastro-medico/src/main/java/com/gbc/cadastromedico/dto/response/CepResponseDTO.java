package com.gbc.cadastromedico.dto.response;
import com.gbc.cadastromedico.model.Cep;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CepResponseDTO {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public CepResponseDTO(Cep cep){
        this.cep = cep.getCep();
        this.localidade = cep.getLocalidade();
        this.complemento = cep.getComplemento();
        this.bairro = cep.getBairro();
        this.logradouro = cep.getLogradouro();
        this.uf = cep.getUf();
    }
}