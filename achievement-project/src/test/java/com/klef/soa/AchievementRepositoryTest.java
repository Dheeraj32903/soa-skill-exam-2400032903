package com.klef.soa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.Achievement;
import com.klef.soa.repository.AchievementRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AchievementRepositoryTest 
{
    @Autowired
    private AchievementRepository repository;

    @Test
    void testFindAllAchievements() 
    {
        List<Achievement> achievements = repository.findAll();
        assertNotNull(achievements);
        assertFalse(achievements.isEmpty());
        System.out.println("Total Achievements: " + achievements.size());
    }

    @Test
    void testFindAchievementById() 
    {
        Optional<Achievement> achievement = repository.findById(1L);
        assertTrue(achievement.isPresent());
        assertEquals(1L, achievement.get().getAchievementId());
        System.out.println("Achievement ID: " + achievement.get().getAchievementId());
        System.out.println("Name: " + achievement.get().getName());

        Optional<Achievement> nonExisting = repository.findById(999L);
        assertFalse(nonExisting.isPresent());
    }

    @Test
    void testFindAchievementByName() 
    {
        List<Achievement> achievements = repository.findByName("Hackathon Winner");
        assertNotNull(achievements);
        assertFalse(achievements.isEmpty());
        assertEquals("Hackathon Winner", achievements.get(0).getName());
        System.out.println("Name: " + achievements.get(0).getName());
    }

    @Test
    void testTotalAchievementCount() 
    {
        long count = repository.count();
        assertTrue(count >= 3);
        System.out.println("Total Achievements in Database: " + count);
    }

    @Test
    void testAchievementDetails() 
    {
        Optional<Achievement> achievement = repository.findById(1L);
        assertTrue(achievement.isPresent());
        Achievement foundAchievement = achievement.get();
        assertNotNull(foundAchievement.getName());
        assertNotNull(foundAchievement.getType());
        assertNotNull(foundAchievement.getStatus());
        assertNotNull(foundAchievement.getLocation());
        System.out.println("Name: " + foundAchievement.getName());
        System.out.println("Type: " + foundAchievement.getType());
        System.out.println("Status: " + foundAchievement.getStatus());
        System.out.println("Location: " + foundAchievement.getLocation());
        List<Achievement> categoryAchievements = repository.findByType("Technical");
        assertNotNull(categoryAchievements);
        assertFalse(categoryAchievements.isEmpty());
        System.out.println("Technical Achievements: " + categoryAchievements.size());
    }
}

