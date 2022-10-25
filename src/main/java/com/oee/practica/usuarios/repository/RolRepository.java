package com.oee.practica.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oee.practica.usuarios.entity.Role;

public interface RolRepository extends JpaRepository<Role, Long> {

}
