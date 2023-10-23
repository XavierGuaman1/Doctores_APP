package com.example.DoctoresApp.controller

import com.example.DoctoresApp.model.Doctor
import com.example.DoctoresApp.service.DoctorService
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
@RequestMapping("/Doctor")

class DoctorController {
    @Autowired
    lateinit var doctorService: DoctorService

    @GetMapping
    fun list ():List <Doctor>{
        return doctorService.list()
    }


@PostMapping
fun save (@RequestBody doctor: Doctor):ResponseEntity<Doctor>{
    return ResponseEntity(doctorService.save(doctor), HttpStatus.OK)
}


@PutMapping
fun update (@RequestBody doctor: Doctor):ResponseEntity<Doctor>{
    return ResponseEntity(doctorService.update(doctor), HttpStatus.OK)
        }


//patch
@PatchMapping
fun updateName (@RequestBody doctor: Doctor):ResponseEntity<Doctor>{
    return ResponseEntity(doctorService.updateName(doctor), HttpStatus.OK)
    }


//delete

@DeleteMapping("/delete/{id}")
fun delete (@PathVariable("id") id: Long):Boolean?{
    return doctorService.delete(id)
    }

//List By ID

@GetMapping("/{id}")
fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
    return ResponseEntity(doctorService.listById (id), HttpStatus.OK)
    }
}


