package com.example.habittracker.services.impl;

import com.example.habittracker.mappers.AchievementMapper;
import com.example.habittracker.mappers.HabitMapper;
import com.example.habittracker.mappers.ProgressMapper;
import com.example.habittracker.models.dtos.AchievementDto;
import com.example.habittracker.models.dtos.HabitDto;
import com.example.habittracker.models.dtos.ProgressDto;
import com.example.habittracker.models.enums.Status;
import com.example.habittracker.repository.AchievementRep;
import com.example.habittracker.repository.HabitRep;
import com.example.habittracker.repository.ProfileRep;
import com.example.habittracker.repository.ProgressRep;
import com.example.habittracker.services.AchievementService;
import com.example.habittracker.services.HabitService;
import com.example.habittracker.services.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AchievementServiceImpl implements AchievementService {
    private final AchievementRep achievementRep;
    private AchievementMapper achMapper = AchievementMapper.INSTANCE;
    /*private final HabitRep habitRep;
    private HabitMapper habitMapper = HabitMapper.INSTANCE;*/
    private final HabitService habitService;
    /*private final ProgressService progressService;*/
    private final ProgressRep progressRep;
    private ProgressMapper progressMapper = ProgressMapper.INSTANCE;


    @Override
    public AchievementDto save(Long profileId, Long habitId) {
        HabitDto habitDto = habitService.findById(habitId);
        List<ProgressDto> progressDtos = progressMapper.toDtos(progressRep.findAllByProfile(profileId));


        return null;
    }

    @Override
    public AchievementDto findById(Long id) {
        return achMapper.toDto(achievementRep.findById(id)
                .orElseThrow(()->new RuntimeException("Achievement not found")));
    }

    @Override
    public List<AchievementDto> findAll() {
        return achMapper.toDtos(achievementRep.findAll());
    }

    @Override
    public AchievementDto delete(Long id) {
        AchievementDto achievementDto = achMapper.toDto(achievementRep.findById(id)
                .orElseThrow(()->new RuntimeException("Achievement not found")));
        achievementDto.setStatus(Status.DELETED);
        return achMapper.toDto(achievementRep.save(achMapper.toEntity(achievementDto)));
    }
}
