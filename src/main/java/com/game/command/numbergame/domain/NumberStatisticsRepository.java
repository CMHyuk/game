package com.game.command.numbergame.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NumberStatisticsRepository extends JpaRepository<NumberStatistics, Long> {
    Optional<NumberStatistics> findByNumber(int number);
}
