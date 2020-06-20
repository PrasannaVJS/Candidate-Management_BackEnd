package com.example.demo.DAO;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.models.Candidate;
import com.example.demo.models.Candidate2;
import com.example.demo.models.Candidate3;

public interface CandidateDAOCustom {
	public List<Candidate3> getAllCandidates() throws DataAccessException;
	public List<Candidate3> getCandidateByLocation(String location_choice) throws DataAccessException;
	public List<Candidate3> getCandidateByJob(String Job) throws DataAccessException;
	public List<Candidate3> getCandidateBySkill(String sname) throws DataAccessException;
	public List<Candidate3> getCandidateByID(int Id) throws DataAccessException;
}
