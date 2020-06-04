package com.example.demo.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DAO.CandidateDAO;
import com.example.demo.Service.CandidateService;
import com.example.demo.models.Candidate;
import com.example.demo.models.Candidate2;

@Component
public class CandidateServiceImpl implements CandidateService {
	@Autowired
	CandidateDAO dao;
	public void addCandidate(Candidate2 candidate) {
		dao.save(candidate);
	}
	public void deleteCandidate(Integer id) {
		dao.deleteById(id);
	}
	public Candidate2 getCandidateById(Integer id) {
		Optional<Candidate2> optionalEntity = dao.findById(id);
		Candidate2 candidate=optionalEntity.get();
		return candidate;
	}
	public List<Candidate2> getAllCandidates() {
		return dao.getAllCandidates();
	}
	
	public void updateCandidate(Candidate2 candidate,Integer id)
	{	
		dao.save(candidate);
	}
	
	public List<Candidate2> getCandidateByLocation(String location_choice)
	{
		return dao.getCandidateByLocation(location_choice);
	}
	
	public List<Candidate2> getCandidateByJob(String jobdescrip){
		return dao.getCandidateByJob(jobdescrip);
	}
	
}
