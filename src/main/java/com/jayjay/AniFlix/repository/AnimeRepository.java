package com.jayjay.AniFlix.repository;

import com.jayjay.AniFlix.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime,Long> {
}
