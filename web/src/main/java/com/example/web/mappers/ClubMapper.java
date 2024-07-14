package com.example.web.mappers;

import com.example.web.dto.ClubDto;
import com.example.web.models.Club;

import java.util.stream.Collectors;

import static com.example.web.mappers.EventMapper.mapToEventDto;

public class ClubMapper {
    public static Club mapToClub(ClubDto clubDto) {
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


    public static ClubDto mapToClubDto(Club club){
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents().stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList()))
                .build();
        return clubDto;
    }
}
