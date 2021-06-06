package com.notes.backend.dao;

import com.notes.backend.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("from User u where (:name is null or u.name = :name) and (:surname is null or u.surname = :surname) and (:email is null or u.email = :email)")
	List<User> searchBy(String name, String surname, String email);

    Optional<User> findByLogin(String login);

	boolean existsByUserId(Integer userId);

	boolean existsByLogin(String login);
}
