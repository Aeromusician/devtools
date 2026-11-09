package ru.mentee.power.devtools.progress;

public class ProgressTracker {
  /**
   * Суммарный прогресс группы mentee.
   */
  public String calculateTotalProgress(Mentee[] mentees) {
    if (mentees.length == 0 || mentees == null) {
      throw new IllegalArgumentException("Массив mentees не создан, или его размер 0");
    }
    int totalCompleted = 0;
    int totalLessons = 0;
    int index = 0;
    while (index < mentees.length) {
      totalCompleted += mentees[index].completedLessons();
      totalLessons += mentees[index].totalLessons();
      index++;
    }
    String resultMessage = "Суммарно: пройдено " + totalCompleted + " из " + totalLessons
        + " уроков, осталось " + (totalLessons - totalCompleted) + " уроков";
    return resultMessage;
  }

  /**
   * Средний процент прохождения по всем mentee.
   *
   * @throws IllegalArgumentException если массив пуст
   */
  public double averageProgressPercent(Mentee[] mentees) {
    if (mentees == null || mentees.length == 0) {
      throw new IllegalArgumentException("Пустой список mentee");
    }

    double percentSum = 0;

    for (Mentee mentee : mentees) {
      double v = mentee.completedLessons() * 100.0 / mentee.totalLessons();
      percentSum += v;
    }

    return percentSum / mentees.length;
  }

}
