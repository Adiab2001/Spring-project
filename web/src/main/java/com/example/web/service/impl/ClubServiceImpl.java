package com.example.web.service.impl;

import com.example.web.Repo.ClubRepo;
import com.example.web.dto.ClubDto;
import com.example.web.models.Club;
import com.example.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepo clubRepo;


    @Autowired
    public ClubServiceImpl(ClubRepo clubRepo) {
        this.clubRepo = clubRepo;
    }

    @Override
    public List<ClubDto> findAllClubs() {
       List<Club> clubs =   clubRepo.findAll();
       return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }

    private ClubDto mapToClubDto(Club club){
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
        return clubDto;
    }
}
