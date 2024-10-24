package com.teachmeskills.lesson_8.basic_tasks.task_1.clinic_simulation.doctors;

import com.teachmeskills.lesson_8.basic_tasks.task_1.clinic_simulation.Doctor;
import com.teachmeskills.lesson_8.basic_tasks.task_1.clinic_simulation.patients.Patient;

public class Ophthalmologist implements Doctor {

    @Override
    public void treat(Patient patient) {
        System.out.println("The ophthalmologist treats a patient: " + patient.getTreatmentPlan());
    }
}