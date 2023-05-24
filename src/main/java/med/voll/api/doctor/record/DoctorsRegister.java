package med.voll.api.doctor.record;

import med.voll.api.adress.DadosEndereco;
import med.voll.api.doctor.Especialidade;


public record DoctorsRegister(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {

}
