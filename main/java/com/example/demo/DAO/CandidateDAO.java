package com.example.demo.DAO;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Candidate;
import com.example.demo.models.Candidate2;

public interface CandidateDAO extends CrudRepository<Candidate2,Integer>,CandidateDAOCustom {

}
