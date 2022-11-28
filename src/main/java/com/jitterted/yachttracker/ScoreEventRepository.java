package com.jitterted.yachttracker;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ScoreEventRepository {
  private final List<ScoredEvent> scoredEvents = new ArrayList<>();

  ScoredEvent save(ScoredEvent scoredEvent) {
    scoredEvents.add(scoredEvent);
    return scoredEvent;
  }

  List<ScoredEvent> findAll() {
    return List.copyOf(scoredEvents);
  }

  public void clear() {
    scoredEvents.clear();
  }
}
