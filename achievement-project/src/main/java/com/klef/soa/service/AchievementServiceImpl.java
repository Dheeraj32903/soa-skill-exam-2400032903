package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klef.soa.entity.Achievement;
import com.klef.soa.repository.AchievementRepository;
@Service
public class AchievementServiceImpl implements AchievementService {
	@Autowired
	private AchievementRepository repo;
	@Override
	public Achievement addachievement(Achievement achievement) {
	return repo.save(achievement);
	}

	@Override
	public Achievement updateachievement(Achievement achievement) {
		Optional<Achievement> ao=repo.findById(achievement.getAchievementId());
		if(ao.isPresent()) {
			Achievement a= ao.get();
			a.setName(achievement.getName());
			a.setLocation(achievement.getLocation());
			a.setStatus(achievement.getStatus());
			a.setType(achievement.getType());
			return repo.save(a);
		
	}else {
		return null;
	}
		
	}

	@Override
	public List<Achievement> viewacheivements() {
		return repo.findAll();
	}

	@Override
	public Achievement viewachievementbyid(Long achievementId) {
	 return repo.findById(achievementId).orElse(null);	
	}

	@Override
	public List<Achievement> viewachievementbyname(String name) {
		 return repo.findByName(name);
		
	}

	@Override
	public List<Achievement> viewachievementbytype(String type) {
		return repo.findByType(type);
	}

	@Override
	public String deleteachievement(Long id) {
		Optional<Achievement> oa=repo.findById(id);
		if(oa.isPresent()) {
			Achievement a=oa.get();
			repo.delete(a);
			return "Deleted Sucessfully";
		}else {
			return "Not Found";
		}
	}

	@Override
	public long viewcount() {
		return repo.count();
	}

}