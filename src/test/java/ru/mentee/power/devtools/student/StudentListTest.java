package ru.mentee.power.devtools.student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StudentListTest {

  @Test
  void shouldAddStudentToList() {
    StudentList studentList = new StudentList();
    Student student = new Student("Nick", "Moscow");
    studentList.addStudent(student);
    assertThat(studentList.getStudentList())
        .hasSize(1)
        .containsExactly(student);
  }

  @Test
  void shouldNotAddNullStudent() {
    StudentList studentList = new StudentList();
    studentList.addStudent(null);
    assertThat(studentList.getStudentList()).isEmpty();
  }

  @Test
  void shouldFindStudentFromSpecificCity() {
    StudentList studentList = new StudentList();
    Student student = new Student("Nick", "Moscow");
    studentList.addStudent(student);
    var result = studentList.getStudentFromSpecificCity("Moscow");
    assertThat(result).containsExactly(student);
  }

  @Test
  void shouldReturnEmptyListWhenCityDoesNotExist() {
    StudentList studentList = new StudentList();
    studentList.addStudent(new Student("Nick", "Moscow"));
    var result = studentList.getStudentFromSpecificCity("London");
    assertThat(result).isEmpty();
  }

  @Test
  void shouldReturnEmptyListWhenStudentListIsEmpty() {
    StudentList studentList = new StudentList();
    var result = studentList.getStudentFromSpecificCity("Moscow");
    assertThat(result).isEmpty();
  }

  @Test
  void shouldReturnCopyOfStudentList() {
    StudentList studentList = new StudentList();
    Student student = new Student("Nick", "Moscow");
    studentList.addStudent(student);
    var result = studentList.getStudentList();
    assertThat(result).containsExactly(student);
    assertThatThrownBy(() -> result.add(new Student("Alex", "London")))
        .isInstanceOf(UnsupportedOperationException.class);
  }

  @Test
  void shouldNotChangeOriginalListWhenAddingStudentAfterGettingCopy() {
    StudentList studentList = new StudentList();
    Student student = new Student("Nick", "Moscow");
    studentList.addStudent(student);
    var result = studentList.getStudentList();
    studentList.addStudent(new Student("Alex", "London"));
    assertThat(result).hasSize(1);
    assertThat(studentList.getStudentList()).hasSize(2);
  }

  @Test
  void shouldReturnUnmodifiableListWhenSearchingByCity() {
    StudentList studentList = new StudentList();
    studentList.addStudent(new Student("Nick", "Moscow"));
    var result = studentList.getStudentFromSpecificCity("Moscow");
    assertThatThrownBy(() -> result.add(new Student("Alex", "Moscow")))
        .isInstanceOf(UnsupportedOperationException.class);
  }
}