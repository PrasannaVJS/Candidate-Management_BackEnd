package com.example.demo.ServiceImpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DAO.CandidateDAO;
import com.example.demo.Service.CandidateService;
import com.example.demo.models.Candidate;
import com.example.demo.models.Candidate2;
import com.example.demo.models.Candidate3;
import com.example.demo.models.Chart;
import com.example.demo.models.SkillChart;

@Component
public class CandidateServiceImpl implements CandidateService {
	@Autowired
	CandidateDAO dao;
	
	public String fname="C:\\Users\\lenovo\\Desktop\\My Details\\Accolite\\Logs.log";
	
	public void addCandidate(Candidate3 candidate) {
		dao.save(candidate);
		String str=candidate.getFirstname()+" " +candidate.getLastname()+ " is added to database.\n";
		logFile(fname,str);
	}
	public void deleteCandidate(Integer id) {
		dao.deleteById(id);
		String str="Candidate with ID: "+ id+ " is deleted from the database.\n";
		logFile(fname,str);
	}
	public Candidate3 getCandidateById(Integer id) {
		Optional<Candidate3> optionalEntity = dao.findById(id);
		Candidate3 candidate=optionalEntity.get();
		return candidate;
	}
	public List<Candidate3> getAllCandidates() {
		return dao.getAllCandidates();
	}
	
	public void updateCandidate(Candidate3 candidate,Integer id)
	{	
		String str="Candidate with ID: " + candidate.getId() + " got updated.\n";
		logFile(fname,str);
		dao.save(candidate);
	}
	
	public List<Candidate3> getCandidateByLocation(String location_choice)
	{
		return dao.getCandidateByLocation(location_choice);
	}
	
	public List<Candidate3> getCandidateByJob(String jobdescrip){
		return dao.getCandidateByJob(jobdescrip);
	}
	
	public List<Chart> getChartDataLocation(){
		List<Chart> results=new ArrayList<>(); 
		//List<Integer> graddata=new ArrayList<>(); 
		int result=dao.getCandidateByLocation("Bangalore").size();
		Chart c=new Chart("Bangalore",result);
		results.add(c);
		result=dao.getCandidateByLocation("Mumbai").size();
		c=new Chart("Mumbai",result);
		results.add(c);
		result=dao.getCandidateByLocation("Chennai").size();
		c=new Chart("Chennai",result);
		results.add(c);
		result=dao.getCandidateByLocation("Hyderabad").size();
		c=new Chart("Hyderabad",result);
		results.add(c);
		result=dao.getCandidateByLocation("Gurugram").size();
		c=new Chart("Gurugram",result);
		results.add(c);
		return results;
	}
	
	public void logFile(String fname,String str) {
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter(fname,true)); 
			bw.write(str);
			bw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<SkillChart> getChartDataSkill(){
		List<SkillChart> sc=new ArrayList<>();
		int result=dao.getCandidateBySkill("cpp").size();
		SkillChart s=new SkillChart("CPP",result);
		sc.add(s);
		result=dao.getCandidateBySkill("java").size();
		s=new SkillChart("Java",result);
		sc.add(s);
		result=dao.getCandidateBySkill("python").size();
		s=new SkillChart("Python",result);
		sc.add(s);
		result=dao.getCandidateBySkill("angular").size();
		s=new SkillChart("Angular",result);
		sc.add(s);
		result=dao.getCandidateBySkill("spring").size();
		s=new SkillChart("Spring",result);
		sc.add(s);
		return sc;
	}
	
	
	
}
