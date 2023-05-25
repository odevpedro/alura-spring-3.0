package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import med.voll.api.doctor.DadosListagemMedico;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.record.DoctorsRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping
    public Page<DadosListagemMedico> list(Pageable pageable) {
        return repository.findAll(pageable).map(DadosListagemMedico::new);
    }
}
