package com.jitterted.yachttracker;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ScoreViewRepository {
  private final Map<Long, ScoreView> scoreMap = new HashMap<>();
  private final AtomicLong sequence = new AtomicLong(1);

  ScoreView findOne(Long id) {
    return scoreMap.get(id);
  }

  ScoreView save(ScoreView scoreView) {
    if (scoreView.getId() == null) {
      scoreView.setId(sequence.getAndIncrement());
    }
    scoreMap.put(scoreView.getId(), scoreView);
    return scoreView;
  }

  List<ScoreView> findAll() {
    return new ArrayList<>(scoreMap.values());
  }

  public void delete(Long id) {
    scoreMap.remove(id);
  }

  public void clear() {
    scoreMap.clear();
  }
}
