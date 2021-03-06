package com.example.demo.Service;

import java.util.List;

import com.example.demo.models.Candidate;
import com.example.demo.models.Candidate2;
import com.example.demo.models.Candidate3;
import com.example.demo.models.Chart;
import com.example.demo.models.DesignationChart;
import com.example.demo.models.SkillChart;

public interface CandidateService {
	public void addCandidate(Candidate3 candidate);
	public boolean deleteCandidate(Integer id);
	public List<Candidate3> getCandidateById(Integer id);
	public List<Candidate3> getAllCandidates();
	public boolean updateCandidate(Candidate3 candidate,Integer id);
	public List<Candidate3> getCandidateByLocation(String location);
	public List<Candidate3> getCandidateByJob(String jobdescrip);
	public List<Candidate3> getCandidateBySkill(String skill);
	public List<Chart> getChartDataLocation();
	public void logFile(String fname,String str);
	public List<SkillChart> getChartDataSkill();
	public List<DesignationChart> getChartDataPosition();
}
