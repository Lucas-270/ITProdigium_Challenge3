package br.com.prodigium.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prodigium.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
