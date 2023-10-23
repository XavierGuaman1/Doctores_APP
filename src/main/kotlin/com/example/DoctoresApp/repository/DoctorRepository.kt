package com.example.DoctoresApp.repository

import com.example.DoctoresApp.model.Doctor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface DoctorRepository : JpaRepository<Doctor, Long?> {

    fun findById (id: Long?): Doctor?

}

