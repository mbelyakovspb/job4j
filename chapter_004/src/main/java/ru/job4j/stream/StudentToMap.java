package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * Класс StudentToMap
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 21.10.2019
 * @version 1
 */
public class StudentToMap {
    /**
     * Метод преобразует список студентов в карту(отображение)
     * @param students - список студентов
     * @return - преобразованный список студентов в карту(отображение)
     */
   public Map<String, Student> transformation(List<Student> students) {
       return students.stream().collect(
               Collectors.toMap(
                       Student::getName, s -> s)
       );
   }
}
