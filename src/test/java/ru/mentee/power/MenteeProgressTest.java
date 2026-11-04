package ru.mentee.power;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MenteeProgressTest {

	@Test
	void shouldFormatSummary_whenProgressCreated() {
		MenteeProgress progress = new MenteeProgress("Nikita", 3, 8);

		assertThat(progress.summary()).isEqualTo("Sprint 3 → Nikita: planned 8 h");
	}

	@Test
	void shouldDetectReadiness_whenHoursAboveThreshold() {
		assertThat(new MenteeProgress("Bob", 3, 6).readyForSprint()).isTrue();
	}

	@Test
	void shouldDetectLackOfReadiness_whenHoursBelowThreshold() {
		assertThat(new MenteeProgress("John", 4, 1).readyForSprint()).isFalse();
	}
}