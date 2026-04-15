package com.hospital.dbms.models;

public class Appointment {
    private int id;
    private int patientId;
    private int doctorId;
    private String date;

    public Appointment() {}

    public Appointment(int id, int patientId, int doctorId, String date) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public int getId() { return id; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public String getDate() { return date; }

    public void setPatientId(int patientId) { this.patientId = patientId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }
    public void setDate(String date) { this.date = date; }
}