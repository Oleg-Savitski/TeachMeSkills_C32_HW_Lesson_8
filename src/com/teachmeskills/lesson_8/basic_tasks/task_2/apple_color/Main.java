package com.teachmeskills.lesson_8.basic_tasks.task_2.apple_color;

import com.teachmeskills.lesson_8.basic_tasks.task_2.apple_color.other_colors.GreenApple;
import com.teachmeskills.lesson_8.basic_tasks.task_2.apple_color.other_colors.RedApple;
import com.teachmeskills.lesson_8.basic_tasks.task_2.apple_color.other_colors.YellowApple;

/** Создать класс Apple и добавить в него поле color с модификатором доступа private и
 * инициализировать его. В методе main другого класса создать объект Apple, и не
 * используя сеттеры изменить значение поля color
 */

public class Main {
    public static void main(String[] args) {
        Apple[] apples = new Apple[3];
        apples[0] = new GreenApple();
        apples[1] = new RedApple();
        apples[2] = new YellowApple();

        for (Apple apple : apples) {
            System.out.println("Color: " + apple.getColor());
        }
    }
}