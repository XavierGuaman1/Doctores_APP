package com.example.DoctoresApp.service


import com.example.DoctoresApp.model.Doctor
import com.example.DoctoresApp.repository.DoctorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class DoctorService {
    @Autowired
    lateinit var doctorRepository: DoctorRepository
    fun list ():List<Doctor>{
        return doctorRepository.findAll()
    }

fun save(doctor: Doctor): Doctor{
    try{
        return doctorRepository.save(doctor)
    }
    catch (ex:Exception){
        throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
         }
    }


fun update(doctor: Doctor): Doctor{
    try {
        doctorRepository.findById(doctor.id)
            ?: throw Exception("ID no exist")

        return doctorRepository.save(doctor)
    }
    catch (ex:Exception){
        throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
    }
        }


//patch//
fun updateName(doctor: Doctor): Doctor{
    try{
        val response = doctorRepository.findById(doctor.id)
            ?: throw Exception("ID no existe")
        response.apply {
            nombre=doctor.nombre //un atributo del modelo
        }
        return doctorRepository.save(response)
    }
    catch (ex:Exception){
        throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
    }
        }


//delete

fun delete (id: Long?):Boolean?{
    try{
        val response = doctorRepository.findById(id)
            ?: throw Exception("ID no existe")
        doctorRepository.deleteById(id!!)
        return true
    }
    catch (ex:Exception){
        throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
    }
        }


//lis By ID
fun listById (id:Long?):Doctor?{
    return doctorRepository.findById(id)
    }
}
