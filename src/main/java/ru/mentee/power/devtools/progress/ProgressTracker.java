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

	static void main(String[] args) {
		Mentee[] mentees = {
				new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
				new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
				new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
		};
		System.out.println(new ProgressTracker().calculateTotalProgress(mentees));
	}
}
