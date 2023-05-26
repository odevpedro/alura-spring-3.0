package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import med.voll.api.doctor.DadosAtualizacaoMedico;
import med.voll.api.doctor.DadosListagemMedico;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.record.DoctorsRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/medicos")
public class Registration {

    @Autowired
    private final DoctorRepository repository;

    @PostMapping
    public void register(@RequestBody @Valid DoctorsRegister dados) {
        repository.save(new Doctor(dados));


    }

    //por padrão são carregados 20 registros do db sem ordenação
    @GetMapping
    public Page<DadosListagemMedico> list(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable pageable) {
        return repository.findAll(pageable).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var doctor = repository.getReferenceById(dados.id());
        doctor.atualizaatualizarInformacoes(dados);
    }
}