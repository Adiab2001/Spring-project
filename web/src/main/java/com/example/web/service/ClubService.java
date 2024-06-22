package com.example.web.service;

import com.example.web.dto.ClubDto;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
}
