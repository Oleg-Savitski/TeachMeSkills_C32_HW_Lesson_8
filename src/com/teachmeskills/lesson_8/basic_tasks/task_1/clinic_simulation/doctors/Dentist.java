package com.teachmeskills.lesson_8.basic_tasks.task_1.clinic_simulation.doctors;

import com.teachmeskills.lesson_8.basic_tasks.task_1.clinic_simulation.Doctor;
import com.teachmeskills.lesson_8.basic_tasks.task_1.clinic_simulation.patients.Patient;

public class Dentist implements Doctor {

    @Override
    public void treat(Patient patient) {
        System.out.println("The dentist treats the patient " + patient.getTreatmentPlan());
    }
}