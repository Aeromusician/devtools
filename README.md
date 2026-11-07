# Quick start
./gradlew run - fast app run
./gradlew test - fast test run

# Packages
ru.mentee.power - область видимости (namespace), которая предотвращает конфликты имён между модулями;

# Таблица полей

| Поле | Описание | Тип данных |
| :--- | :--- | :--- |
| `menteeName` | Имя студента | String |
| `sprintNumber` | Номер спринта | Integer |
| `plannedHoursPerWeek` | Запланированные часы на спринт | Integer |
| `readyForSpring()` | Функция определения готовности к спринту, true если запланировано больше 3х часов | boolean |

# Правило веток
from master feature/DVT-X, где X номер задания
# Правило push
<pre>git status clean then git push</pre>
# Удаленный репозиторий
по SSH на git@github.com:Aeromusician/devtools.git


# Сценарий ручной проверки DVT-6
```bash
./gradlew run    # Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков
./gradlew test   # BUILD SUCCESSFUL, все тесты зелёные (включая тесты на исключения)
```

# Кодстайл-гайд DVT-7

### 1. Именование классов: PascalCase

До: `public class studentService { ... }`

После: `public class StudentService { ... }`

Источник: Google Java Style Guide — Naming

### 2. Именование методов: camelCase

До: `public List get_students() { ... }`

После: `public List getStudents() { ... }`

Источник: Google Java Style Guide — Naming

### 3. Именование констант: SCREAMING_SNAKE_CASE

До: `private static final int maxSize = 100;`

После: `private static final int MAX_SIZE = 100;`

Источник: Google Java Style Guide — Naming

### 4. Отступы: 2 пробела вместо табуляции

До:
```java
public void doSomething() {
    System.out.println("Hello");
}
```

После:
```java
public void doSomething() {
  System.out.println("Hello");
}
```
Источник: Checkstyle — Indentation, FileTabCharacter

### 5. Именование пакетов: lowercase

До: `package ru.mentee.Power;`

После: `package ru.mentee.power;`

Источник: Google Java Style Guide — Naming

# DVT-7 runbook

### запустил CheckStyle
-> упало -> смотришь отчет checkstyle и правишь где нужно
### запустил Jacoco
-> не хватает покрытия -> смотришь отчет в build -> дописываешь тесты, где необходимо
