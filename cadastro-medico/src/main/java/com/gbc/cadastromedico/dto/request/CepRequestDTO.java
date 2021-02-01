package com.gbc.cadastromedico.dto.request;
import com.gbc.cadastromedico.model.Cep;
import lombok.*;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CepRequestDTO {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String unidade;
    private String ibge;

    public Cep build(){
        Cep cep = new Cep();
        cep.setCep(this.cep);
        cep.setLocalidade(this.localidade);
        cep.setLogradouro(this.logradouro);
        cep.setComplemento(this.complemento);
        cep.setBairro(this.bairro);
        cep.setUf(this.uf);
        return cep;
    }
}
