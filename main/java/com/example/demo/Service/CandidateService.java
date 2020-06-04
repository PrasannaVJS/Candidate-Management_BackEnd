package com.example.demo.Service;

import java.util.List;

import com.example.demo.models.Candidate;
import com.example.demo.models.Candidate2;

public interface CandidateService {
	public void addCandidate(Candidate2 candidate);
	public void deleteCandidate(Integer id);
	public Candidate2 getCandidateById(Integer id);
	public List<Candidate2> getAllCandidates();
	public void updateCandidate(Candidate2 candidate,Integer id);
	public List<Candidate2> getCandidateByLocation(String location);
	public List<Candidate2> getCandidateByJob(String jobdescrip);
}
