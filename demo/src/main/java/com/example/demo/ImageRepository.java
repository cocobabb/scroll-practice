package com.example.demo;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImageRepository extends JpaRepository<Image, Long> {

    @Query("SELECT i FROM Image i WHERE (:cursorId IS NULL OR i.id < :cursorId) ORDER BY i.id DESC")
    List<Image> findNextImages(@Param("cursorId") Long cursorId, Pageable pageable);
}

