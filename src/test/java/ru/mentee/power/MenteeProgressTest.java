package ru.mentee.power;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MenteeProgressTest {

  @Test
  void shouldFormatSummaryWhenProgressCreated() {
    MenteeProgress progress = new MenteeProgress("Nikita", 3, 8);

    assertThat(progress.summary()).isEqualTo("Sprint 3 → Nikita: planned 8 h");
  }

  @Test
  void shouldDetectReadinessWhenHoursAboveThreshold() {
    assertThat(new MenteeProgress("Bob", 3, 6).readyForSprint()).isTrue();
  }

  @Test
  void shouldDetectLackOfReadinessWhenHoursBelowThreshold() {
    assertThat(new MenteeProgress("John", 4, 1).readyForSprint()).isFalse();
  }
}