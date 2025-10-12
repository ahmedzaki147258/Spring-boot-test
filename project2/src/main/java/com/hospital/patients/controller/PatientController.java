package com.hospital.patients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.patients.model.entity.Patient;
import com.hospital.patients.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService; //bean

    @GetMapping("")
    public ResponseEntity<List<Patient>> getAllPateients(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) {
        return ResponseEntity.ok(this.patientService.getAllPateients(page, limit));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Patient> getOnePateient(@PathVariable String name) {
        return ResponseEntity.ok(this.patientService.getOnePateient(name));
    }

    @PostMapping("")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.patientService.createPatient(patient));
    }
}