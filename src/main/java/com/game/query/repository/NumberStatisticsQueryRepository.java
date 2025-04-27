package com.game.query.repository;

import com.game.command.numbergame.domain.Level;
import com.game.command.numbergame.domain.NumberStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NumberStatisticsQueryRepository extends JpaRepository<NumberStatistics, Long> {
    List<NumberStatistics> findByLevel(Level level);
}
