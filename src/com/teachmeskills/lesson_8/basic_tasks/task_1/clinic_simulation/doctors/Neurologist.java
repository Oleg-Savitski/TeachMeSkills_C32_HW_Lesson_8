package com.teachmeskills.lesson_8.basic_tasks.task_1.clinic_simulation.doctors;

import com.teachmeskills.lesson_8.basic_tasks.task_1.clinic_simulation.Doctor;
import com.teachmeskills.lesson_8.basic_tasks.task_1.clinic_simulation.patients.Patient;

public class Neurologist implements Doctor {

    @Override
    public void treat(Patient patient) {
        System.out.println("The neurologist treats a patient " + patient.getTreatmentPlan());
    }
}