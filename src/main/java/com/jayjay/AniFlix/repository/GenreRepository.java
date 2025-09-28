package com.jayjay.AniFlix.repository;

import com.jayjay.AniFlix.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
}
