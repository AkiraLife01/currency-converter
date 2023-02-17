package com.converter.currencyconverter.repository;

import java.util.Optional;

import com.converter.currencyconverter.model.ERole;
import com.converter.currencyconverter.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}