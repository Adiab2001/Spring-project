package com.example.web.service;

import com.example.web.dto.ClubDto;
import com.example.web.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
    Club saveClub (Club club);


    ClubDto findClubById(long clubId);

    void updateClub(ClubDto club);
}
