package com.example.demo.DAO;

import java.util.List;

import com.example.demo.models.Candidate;
import com.example.demo.models.Candidate2;
import com.example.demo.models.Candidate3;

public interface CandidateDAOCustom {
	public List<Candidate3> getAllCandidates();
	public List<Candidate3> getCandidateByLocation(String location_choice);
	public List<Candidate3> getCandidateByJob(String Job);
	public List<Candidate3> getCandidateBySkill(String sname);
}
