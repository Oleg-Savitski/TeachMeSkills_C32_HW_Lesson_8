package com.teachmeskills.lesson_8.basic_tasks.task_1.clinic_simulation.clinic;

import com.teachmeskills.lesson_8.basic_tasks.task_1.clinic_simulation.doctors.Therapist;
import com.teachmeskills.lesson_8.basic_tasks.task_1.clinic_simulation.patients.Patient;

import java.util.Random;

/** Создать программу для имитации работы клиники. Пусть в клинике будет три врача:
 * хирург, терапевт и дантист. Каждый врач имеет метод «лечить», но каждый врач лечит
 * по-своему. Так же предусмотреть класс «Пациент» с полем «План лечения» и полем
 * «Доктор». Создать объект класса «Пациент» и добавить пациенту план лечения. У
 * терапевта создать метод, который будет назначать врача пациенту согласно плану
 * лечения:
 * Если план лечения имеет код 1 – назначить хирурга и выполнить метод лечить.
 * Если план лечения имеет код 2 – назначить дантиста и выполнить метод лечить.
 * Если план лечения имеет любой другой код – назначить терапевта и выполнить метод
 * лечить.
 */


public class ClinicSimulation {
    public static void main(String[] args) {
        Random random = new Random();
        int healthStatus = random.nextInt(6);
        String treatmentPlan;
        boolean isHealthy;

        switch (healthStatus) {
            case 0:
                treatmentPlan = null;
                isHealthy = true;
                break;
            case 1:
                treatmentPlan = "1";
                isHealthy = false;
                break;
            case 2:
                treatmentPlan = "2";
                isHealthy = false;
                break;
            case 3:
                treatmentPlan = "3";
                isHealthy = false;
                break;
            case 4:
                treatmentPlan = "4";
                isHealthy = false;
                break;
            case 5:
                treatmentPlan = "5";
                isHealthy = false;
                break;
            default:
                treatmentPlan = null;
                isHealthy = true;
                break;
        }

        Patient patient = new Patient(isHealthy, treatmentPlan);

        Therapist therapist = new Therapist();

        if (patient.isHealthy()) {
            System.out.println("The patient came in healthy. A doctor's appointment is not required. The patient has been sent back.");
        } else {
            System.out.println("Patient: ");
            therapist.assignDoctor(patient);
        }
    }
}
