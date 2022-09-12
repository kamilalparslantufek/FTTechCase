package com.patikacase.firstcase.repository;

import com.patikacase.firstcase.models.Product;
import com.patikacase.firstcase.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, String> {
}

