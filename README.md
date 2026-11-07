[![Java CI](https://github.com/Aeromusician/devtools/actions/workflows/ci.yml/badge.svg)](https://github.com/Aeromusician/devtools/actions/workflows/ci.yml)

# Quick start
./gradlew run - fast app run
./gradlew test - fast test run

## Code Review Checklist

### Функциональность
- [ ] Код решает поставленную задачу полностью
- [ ] Обработаны граничные случаи (null, пустые данные, экстремальные значения)
- [ ] Обработка ошибок реализована корректно

### Тесты
- [ ] Добавлены тесты для нового функционала
- [ ] Все тесты проходят локально: ./gradlew test
- [ ] Покрыты позитивные и негативные сценарии
- [ ] JaCoCo coverage >= 80% для нового кода

### Читаемость и стиль
- [ ] Имена переменных, методов и классов отражают назначение
- [ ] Нет дублирования кода (DRY)
- [ ] Checkstyle проходит без ошибок: ./gradlew checkstyleMain
- [ ] Нет закомментированного кода или отладочного вывода (System.out.println)

### Документация
- [ ] README обновлён (если добавлена новая функциональность)
- [ ] Публичные методы имеют JavaDoc (если применимо)
- [ ] Runbook обновлён (если изменились команды)

### Производительность и безопасность
- [ ] Нет очевидных проблем производительности
- [ ] Нет хардкода паролей, токенов или конфиденциальных данных

### Шаблон конструктивного комментария
**Проблема:** [конкретное описание с указанием строки]

**Почему это важно:** [последствия]

**Предложение:** [как исправить или альтернатива]

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
