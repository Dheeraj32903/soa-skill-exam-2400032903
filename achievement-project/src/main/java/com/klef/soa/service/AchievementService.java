package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Achievement;

public interface AchievementService {
     Achievement addachievement(Achievement achievement);
     Achievement updateachievement(Achievement achievement);
     List<Achievement> viewacheivements();
     Achievement viewachievementbyid(Long achievementId);
     List<Achievement> viewachievementbyname (String name);
     List<Achievement> viewachievementbytype (String type);
      String deleteachievement(Long id);
      long viewcount();
     
} 