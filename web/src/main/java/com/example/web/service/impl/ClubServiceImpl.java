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

    private Club mapToClub(ClubDto clubDto) {
        Club.ClubBuilder builder = Club.builder()
                .title(clubDto.getTitle())
                .photoUrl(clubDto.getPhotoUrl())
                .content(clubDto.getContent())
                .createdOn(clubDto.getCreatedOn())
                .updatedOn(clubDto.getUpdatedOn());

        if (clubDto.getId() != null) {
            builder.id(clubDto.getId());
        }

        return builder.build();
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
