package com.example.DoctoresApp.service

import com.example.DoctoresApp.model.Patients
import com.example.DoctoresApp.repository.DoctorRepository
import com.example.DoctoresApp.repository.PatientsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class PatientsService {
    @Autowired
    lateinit var patientsRepository: PatientsRepository

    @Autowired
    lateinit var doctorRepository: DoctorRepository

    fun list ():List<Patients>{
        return patientsRepository.findAll()
    }
    fun save(patients: Patients):Patients{
        try {
            patientsRepository.findById(patients.DoctorID)
                ?: throw Exception("Id del Doctor no found")
            return patientsRepository.save(patients)
        }catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun update(patients: Patients): Patients{
        try {
            patientsRepository.findById(patients.id)
                ?: throw Exception("ID no exists")

            return patientsRepository.save(patients)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }
    fun updateName(patients: Patients ): Patients{
        try{
            val response = patientsRepository.findById(patients.id)
                ?: throw Exception("ID no exists")
            response.apply {
                fullname=patients.fullname //un attribute del model
            }
            return patientsRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = patientsRepository.findById(id)
                ?: throw Exception("ID no exist")
            patientsRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Patients?{
        return patientsRepository.findById(id)
    }
}