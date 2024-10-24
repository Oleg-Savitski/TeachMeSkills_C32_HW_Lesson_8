package com.teachmeskills.lesson_8.basic_tasks.task_1.clinic_simulation.doctors;

import com.teachmeskills.lesson_8.basic_tasks.task_1.clinic_simulation.Doctor;
import com.teachmeskills.lesson_8.basic_tasks.task_1.clinic_simulation.patients.Patient;

public class Therapist implements Doctor {

    @Override
    public void treat(Patient patient) {
        System.out.println("The therapist prescribes treatment for the patient " + patient.getTreatmentPlan());
    }

    public void assignDoctor(Patient patient) {
        switch (patient.getTreatmentPlan()) {
            case "1":
                System.out.println("The patient is referred to the surgeon.");
                Doctor surgeon = new Surgeon();
                surgeon.treat(patient);
                break;
            case "2":
                System.out.println("The patient is referred to the dentist.");
                Doctor dentist = new Dentist();
                dentist.treat(patient);
                break;
            case "3":
                System.out.println("The patient is referred to the cardiologist.");
                Doctor cardiologist = new Cardiologist();
                cardiologist.treat(patient);
                break;
            case "4":
                System.out.println("The patient is referred to the neurologist.");
                Doctor neurologist = new Neurologist();
                neurologist.treat(patient);
                break;
            case "5":
                System.out.println("The patient is referred to the ophthalmologist.");
                Doctor ophthalmologist = new Ophthalmologist();
                ophthalmologist.treat(patient);
                break;

            default:
                System.out.println("The patient is healthy, no treatment is required.");
                break;
        }
    }
}