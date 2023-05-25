package med.voll.api.doctor.record;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.adress.DadosEndereco;
import med.voll.api.doctor.Especialidade;


public record DoctorsRegister(
        @NotBlank
        String nome,
        @NotBlank  @Email
        String email,
        @NotBlank @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotBlank
        String telefone,

        @NotNull
        Especialidade especialidade,
        @NotNull @Valid
        DadosEndereco endereco) {

}
