package com.teachmeskills.lesson_8.basic_tasks.task_1.clinic_simulation.patients;

public class Patient {
    private String treatmentPlan;
    private boolean isHealthy;

    public Patient(boolean isHealthy, String treatmentPlan) {
        this.isHealthy = isHealthy;
        this.treatmentPlan = treatmentPlan;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }
}