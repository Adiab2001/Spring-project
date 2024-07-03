package com.example.web.Repo;

import com.example.web.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClubRepo extends JpaRepository<Club, Long> {

    @Query("SELECT c from Club c WHERE c.title LIKE CONCAT('%',:query,'%')")
    List<Club> searchClubs(String query);
}
