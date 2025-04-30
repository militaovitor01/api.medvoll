package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.Doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping @Transactional //Necessário para todo método de escrita
    public void register(@RequestBody @Valid DoctorRegisterData data) {
        repository.save(new Doctor(data));
    }

    @GetMapping
    public Page<DoctorDataList> listDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return repository.findAll(pageable).map(DoctorDataList::new);
    }

    @PutMapping @Transactional //Necessário para todo método de escrita
    public void update(@RequestBody @Valid DoctorUpdateList data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.updateData(data);
    }
}
