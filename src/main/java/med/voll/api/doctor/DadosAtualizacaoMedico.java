package med.voll.api.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.adress.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}