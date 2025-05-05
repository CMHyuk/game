package com.game.query.repository;

import com.game.command.numbergame.domain.Record;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RecordQueryRepository extends Repository<Record, Long> {
    @Query("select r from Record r where r.level = :level order by r.attemptCount, r.elapsedTime")
    List<Record> findByLevel(String level);
}
