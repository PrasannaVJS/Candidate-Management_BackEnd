package com.example.demo.DAO;

import java.util.List;

import com.example.demo.models.Candidate;
import com.example.demo.models.Candidate2;

public interface CandidateDAOCustom {
	List<Candidate2> getAllCandidates();
	public List<Candidate2> getCandidateByLocation(String location_choice);
	public List<Candidate2> getCandidateByJob(String Job);
	public List<Candidate2> getCandidateBySkill(String sname);
}
