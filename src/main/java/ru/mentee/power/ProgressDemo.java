package ru.mentee.power;

public class ProgressDemo {
	public static void main(String[] args) {
		var progress = new MenteeProgress(
				"Nikita Naumov",
				1,
				6
		);

		System.out.println(progress.summary());
		if (progress.readyForSprint()) {
			System.out.println("Status: sprint ready");
		} else {
			System.out.println("Status: backlog first");
		}
	}
}
