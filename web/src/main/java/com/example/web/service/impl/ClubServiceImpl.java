package com.example.web.service.impl;

import com.example.web.Repo.ClubRepo;
import com.example.web.dto.ClubDto;
import com.example.web.models.Club;
import com.example.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.web.mappers.ClubMapper.mapToClub;
import static com.example.web.mappers.ClubMapper.mapToClubDto;

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

    @Override
    public Club saveClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        return clubRepo.save(club);
    }

    @Override
    public ClubDto findClubById(long clubId) {
        Club club = clubRepo.findById(clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepo.save(club);
    }

    @Override
    public void delete(Long clubId) {

        clubRepo.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepo.searchClubs(query);
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }


}
