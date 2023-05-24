package med.voll.api.controller;

import lombok.AllArgsConstructor;
import med.voll.api.adress.Endereco;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.record.DoctorsRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/medicos")
public class Registration {

    @Autowired
    private final DoctorRepository doctorRepository;

    @PostMapping
    public void register(@RequestBody DoctorsRegister dados){
        doctorRepository.save(new Doctor(dados));


    }
}
