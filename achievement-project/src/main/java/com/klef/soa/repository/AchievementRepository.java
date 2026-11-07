package com.klef.soa.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.soa.entity.Achievement;
public interface AchievementRepository extends JpaRepository<Achievement,Long> {
   List<Achievement> findByName(String name);
   List<Achievement> findByType(String type);
}
