package ru.mentee.power.devtools.progress;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестирование ProgressTracker")
class ProgressTrackerTest {

  @Test
  @DisplayName("Суммарный прогресс для нескольких mentee с разным прогрессом")
  void shouldCalculateTotalProgressWhenMultipleMentees() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
        new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
        new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
    };
    assertThat(mentees).extracting(Mentee::name).containsExactly("Иван", "Мария", "Пётр");
    String result = tracker.calculateTotalProgress(mentees);

    assertThat(result)
        .contains("пройдено 25 из 36 уроков")
        .contains("осталось 11 уроков");
  }

  @Test
  @DisplayName("Все mentee завершили курс — осталось 0")
  void shouldCalculateTotalProgressWhenAllMenteesCompleted() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend", 12, 12),
        new Mentee("Мария", "СПб", "Fullstack", 12, 12)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertThat(result)
        .contains("пройдено 24 из 24 уроков")
        .contains("осталось 0 уроков");
  }

  @Test
  @DisplayName("Mentee создан с неверными/невозможными параметрами")
  void shouldBeExceptionWhenCreateIncorrectMentee() {
    assertThatThrownBy(() -> new Mentee("Иван", "Москва", "Backend", 15, 10))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Некорректные значения прогресса");
  }

  @Test
  @DisplayName("Mentee создан с верными параметрами")
  void shouldNotBeExceptionWhenCreateCorrectMentee() {
    assertThatCode(() -> new Mentee("Иван", "Москва", "Backend", 5, 12))
        .doesNotThrowAnyException();
  }

  @Test
  @DisplayName("Средний прогресс рассчитан правильно для круглых значений")
  void shouldReturnCorrectAverageForRoundValues() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend", 5, 10),
        new Mentee("Петр", "Казань", "Java", 5, 10),
        new Mentee("Анна", "Тула", "Frontend", 5, 10)
    };

    double result = tracker.averageProgressPercent(mentees);

    assertThat(result).isEqualTo(50.0);
  }

  @Test
  @DisplayName("Средний прогресс рассчитан правильно для некруглых значений")
  void shouldReturnCorrectAverageForNonRoundValues() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend", 5, 12),
        new Mentee("Петр", "Казань", "Java", 8, 12),
        new Mentee("Анна", "Тула", "Frontend", 12, 12)
    };

    double result = tracker.averageProgressPercent(mentees);

    assertThat(result).isCloseTo(69.444444, offset(0.000001));
  }

  @Test
  @DisplayName("Исключение при передаче пустого массива mentee")
  void shouldThrowExceptionWhenMenteesArrayIsEmpty() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {};

    assertThatThrownBy(() -> tracker.averageProgressPercent(mentees))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Пустой список mentee");
  }

  @Test
  @DisplayName("Средний прогресс находится в допустимых границах")
  void shouldReturnProgressWithinValidRange() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend", 5, 10),
        new Mentee("Петр", "Казань", "Java", 8, 10)
    };

    double result = tracker.averageProgressPercent(mentees);

    assertThat(result)
        .isGreaterThan(0)
        .isLessThanOrEqualTo(100);
  }
}
