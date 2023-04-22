package com.example.habittracker.services.impl;

import com.example.habittracker.mappers.ProgressMapper;
import com.example.habittracker.models.dtos.ProfileDto;
import com.example.habittracker.models.dtos.ProgressDto;
import com.example.habittracker.models.entities.Progress;
import com.example.habittracker.models.enums.Status;
import com.example.habittracker.repository.ProgressRep;
import com.example.habittracker.services.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgressServiceImpl implements ProgressService {

    private final ProgressRep progressRep;
    private ProgressMapper progressMapper = ProgressMapper.INSTANCE;

    @Override
    public ProgressDto save(ProgressDto dto) {
        return progressMapper.toDto(progressRep.save(progressMapper.toEntity(dto)));
    }

    @Override
    public ProgressDto findById(Long id) {
        return progressMapper.toDto(progressRep.findById(id)
                .orElseThrow(() -> new RuntimeException("Progress no found")));
    }

    @Override
    public List<ProgressDto> findAll() {
        return progressMapper.toDtos(progressRep.findAll());
    }

    @Override
    public ProgressDto delete(Long id) {
        ProgressDto profileDto = progressMapper.toDto(progressRep.findById(id)
                .orElseThrow(()->new RuntimeException("Profile no found")));
        profileDto.setStatus(Status.DELETED);
        return save(profileDto);
    }
}
