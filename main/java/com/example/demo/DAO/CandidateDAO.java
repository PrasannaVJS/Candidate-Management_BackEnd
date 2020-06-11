package com.example.demo.DAO;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Candidate;
import com.example.demo.models.Candidate2;
import com.example.demo.models.Candidate3;

public interface CandidateDAO extends CrudRepository<Candidate3,Integer>,CandidateDAOCustom {

}
