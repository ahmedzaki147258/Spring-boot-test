package com.hospital.patients.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

import com.hospital.patients.model.entity.Patient;

@Service
public class PatientService {
    private List<Patient> listOfPatients = new ArrayList<>();

    public PatientService() {
        Random random = new Random();

        IntStream.range(0, 30).forEach(i -> {
            String id = UUID.randomUUID().toString();
            String name = String.format("Patient %d", i + 1);
            int age = 18 + random.nextInt(50); // from 18 to 67
            Patient patient = Patient.builder().id(id).name(name).age(age).build();
            this.listOfPatients.add(patient);
        });
    }
    
    public List<Patient> getAllPateients(Integer page, Integer limit) {
        Integer pageNumber = Optional.ofNullable(page).orElse(1);
        Integer pageSize = Optional.ofNullable(limit).orElse(10);
        Integer sikp = (pageNumber - 1) * pageSize;
        return this.listOfPatients.stream().skip(sikp).limit(pageSize).toList();
    }
    
    public Patient getOnePateient(String name) {
        return this.listOfPatients.stream().filter(i -> i.getName().equalsIgnoreCase(name)).findAny().orElse(new Patient(UUID.randomUUID().toString(), "Nothing", 0));
    }

    public Patient createPatient(Patient patient) {
        Patient p = Patient.builder().id(UUID.randomUUID().toString()).name(patient.getName()).age(patient.getAge()).build();
        this.listOfPatients.add(p);
        return p;
    }
}
