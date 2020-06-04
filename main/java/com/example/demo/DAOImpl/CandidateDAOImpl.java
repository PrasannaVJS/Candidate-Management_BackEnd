package com.example.demo.DAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.DAO.CandidateDAOCustom;
import com.example.demo.models.Candidate;
import com.example.demo.models.Candidate2;

public class CandidateDAOImpl implements CandidateDAOCustom {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Candidate2> getAllCandidates(){
		return jdbcTemplate.query(
				"select * from candidate2",
				(rs,rowNum) ->
					new Candidate2(
							rs.getInt("id"),
							rs.getString("firstname"),
							rs.getString("lastname"),
							rs.getString("emailID"),
							rs.getString("location"),
							rs.getString("feedback"),
							rs.getString("jobdescrip"),
							rs.getLong("contactno"),
							rs.getBoolean("cpp"),
							rs.getBoolean("java"),
							rs.getBoolean("python"),
							rs.getBoolean("angular"),
							rs.getBoolean("spring")
						)
				);
	}
	
	public List<Candidate2> getCandidateByLocation(String location_choice)
	{
		 return jdbcTemplate.query(
	                "select * from candidate2 where location=?",new Object[]{location_choice},
	                (rs, rowNum) ->
	                        new Candidate2(
	                        		rs.getInt("id"),
	    							rs.getString("firstname"),
	    							rs.getString("lastname"),
	    							rs.getString("emailID"),
	    							rs.getString("location"),
	    							rs.getString("feedback"),
	    							rs.getString("jobdescrip"),
	    							rs.getLong("contactno"),
	    							rs.getBoolean("cpp"),
	    							rs.getBoolean("java"),
	    							rs.getBoolean("python"),
	    							rs.getBoolean("angular"),
	    							rs.getBoolean("spring")                   
	                        )
	        );
	}
	
	public List<Candidate2> getCandidateByJob(String jobdescrip){
		return jdbcTemplate.query(
                "select * from candidate2 where jobdescrip=?",new Object[]{jobdescrip},
                (rs, rowNum) ->
                        new Candidate2(
                        		rs.getInt("id"),
    							rs.getString("firstname"),
    							rs.getString("lastname"),
    							rs.getString("emailID"),
    							rs.getString("location"),
    							rs.getString("feedback"),
    							rs.getString("jobdescrip"),
    							rs.getLong("contactno"),
    							rs.getBoolean("cpp"),
    							rs.getBoolean("java"),
    							rs.getBoolean("python"),
    							rs.getBoolean("angular"),
    							rs.getBoolean("spring")                   
                        )
        );
	}
	
	
}
