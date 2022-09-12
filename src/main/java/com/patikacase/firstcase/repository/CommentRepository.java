package com.patikacase.firstcase.repository;

import com.patikacase.firstcase.models.Comment;
import com.patikacase.firstcase.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CommentRepository extends CrudRepository<Comment, String> {

}
