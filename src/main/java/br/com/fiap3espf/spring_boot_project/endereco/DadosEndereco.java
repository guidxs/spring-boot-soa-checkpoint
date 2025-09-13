package br.com.fiap3espf.spring_boot_project.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

        @NotBlank
        String logradouro,
        String numero,
        String complemento,

        @NotBlank
        String bairro,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep) {

    public DadosEndereco(Endereco endereco) {
        this(
            endereco.getLogradouro(),
            endereco.getNumero(),
            endereco.getComplemento(),
            endereco.getBairro(),
            endereco.getCidade(),
            endereco.getUf(),
            endereco.getCep()
        );
    }

    public Endereco toEndereco() {
        return new Endereco(this);
    }
}