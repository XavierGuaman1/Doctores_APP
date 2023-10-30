package com.example.DoctoresApp.controller

import com.example.DoctoresApp.model.Patients
import com.example.DoctoresApp.service.PatientsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/patients")   //endpoint
class PatientsController {
    @Autowired
    lateinit var patientsService: PatientsService

    @GetMapping
    fun list ():List <Patients>{
        return patientsService.list()

    }
    @PostMapping
    fun save (@RequestBody patients: Patients):ResponseEntity<Patients>{
        return ResponseEntity(patientsService.save(patients), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody patients: Patients):ResponseEntity<Patients>{
        return ResponseEntity(patientsService.update(patients), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody patients: Patients):ResponseEntity<Patients>{
        return ResponseEntity(patientsService.updateName(patients), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(patientsService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return patientsService.delete(id)
    }
}