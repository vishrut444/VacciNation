package com.vishrut.VacciNation.service;

import com.vishrut.VacciNation.Enum.AppointmentStatus;
import com.vishrut.VacciNation.Enum.Specialization;
import com.vishrut.VacciNation.converter.AppointmentConverter;
import com.vishrut.VacciNation.dto.Response.AppointmentResponse;
import com.vishrut.VacciNation.exception.AppointmentNotFoundException;
import com.vishrut.VacciNation.exception.DoctorNotFoundException;
import com.vishrut.VacciNation.exception.PatientNotFoundException;
import com.vishrut.VacciNation.model.Appointment;
import com.vishrut.VacciNation.model.Doctor;
import com.vishrut.VacciNation.model.Patient;
import com.vishrut.VacciNation.repository.AppointmentRepository;
import com.vishrut.VacciNation.repository.DoctorRepository;
import com.vishrut.VacciNation.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    @Autowired
    JavaMailSender javaMailSender;

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public AppointmentResponse bookAppointment(String applicationNo, Specialization specialization) {
        //check if patient is registered
        Optional<Patient> optionalPatient = patientRepository.findByApplicationNo(applicationNo);
        if(optionalPatient.isEmpty()) throw new PatientNotFoundException("Patient Not Registered!");

        //check if doctor with specialization is present
        Optional<Doctor> optionalDoctor = doctorRepository.findBySpecialization(specialization);
        if(optionalPatient.isEmpty()) throw new DoctorNotFoundException("Currently there are no Doctors wit this "+specialization+" Specialization!");

        Patient patient = optionalPatient.get();
        Doctor doctor = optionalDoctor.get();

        //Booking Appointment
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setApplicationNo(patient.getApplicationNo());
        appointment.setAppointmentStatus(AppointmentStatus.BOOKED);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        //saving the appointment to DB
        Appointment savedAppointment = appointmentRepository.save(appointment);

        //sending e-Mail
//        sendMail(savedAppointment);

        //model -> dto
        return AppointmentConverter.appointmentToAppointmentResponse(savedAppointment);

    }

    private void sendMail(Appointment savedAppointment) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("springtest444@gmail.com");
        simpleMailMessage.setTo(savedAppointment.getPatient().getEmail());
        simpleMailMessage.setSubject("Appointment Confirmed!");
        simpleMailMessage.setText("Your Appointment with appointment Id: "+savedAppointment.getAppointmentId()+" has been confirmed for the Date: "+
                savedAppointment.getDateOfAppointment()+" And your Doctor Name: " +savedAppointment.getDoctor().getName()+
                " And his/her contact Details Mobile No: "+savedAppointment.getDoctor().getMobile()+" And e-mail: "+savedAppointment.getDoctor().getEmail());
        javaMailSender.send(simpleMailMessage);
    }

    public AppointmentResponse getAppointmentDetails(String applicationNo) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findByApplicationNo(applicationNo);
        if(optionalAppointment.isEmpty()) throw new AppointmentNotFoundException("There is No Appointment Booked For this "+applicationNo+" Applicaation No!");

        Appointment appointment = optionalAppointment.get();
        //model -> response
        return AppointmentConverter.appointmentToAppointmentResponse(appointment);
    }


    public AppointmentResponse cancelAppointment(String applicationNo) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findByApplicationNo(applicationNo);
        if(optionalAppointment.isEmpty()) throw new AppointmentNotFoundException("There is no Appointment Booked to be cancelled");

        //getting appointment
        Appointment appointment = optionalAppointment.get();

        //checking if appointment is already cancelled
        if(appointment.getAppointmentStatus().equals(AppointmentStatus.CANCELLED)) throw new AppointmentNotFoundException("Your Appointment has Already been Cancelled");

        //canceling the appointment
        appointment.setAppointmentStatus(AppointmentStatus.CANCELLED);
        appointment.setDateOfAppointment(appointment.getDateOfAppointment());

        //saving it to DB
        appointmentRepository.save(appointment);
        //sending mail
        sendMailCancell(appointment);

        //model to response
        return AppointmentConverter.appointmentToAppointmentResponse(appointment);
    }

    private void sendMailCancell(Appointment appointment) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("springtest444@gmail.com");
        simpleMailMessage.setTo(appointment.getPatient().getEmail());
        simpleMailMessage.setSubject("Appointment Cancelled Successfully!");
        simpleMailMessage.setText("Your Appointment with appointment Id: "+appointment.getAppointmentId()+" has been Cancelled!");
        javaMailSender.send(simpleMailMessage);
    }


}
