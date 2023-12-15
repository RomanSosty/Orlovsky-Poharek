package org.example.jat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;

@WebServlet("/saveApplicationForm")
public class ApplicationFormServlet extends HttpServlet {
    private String nameOfClub;
    private String contact;
    private String nameOfChoreografi;
    private String ageCategory;
    private String danceCategory;
    private String nameOfChoreografer;
    private int numberOfDancer;
    private String lenghtOfDance;
    private int numberOfDancerInGroup;
    private String meansOfTransport;
    private String message;

    private static final String PERSISTENCE_UNIT_NAME = "myPersistenceUnit";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        nameOfClub = request.getParameter("groupName");
        contact = request.getParameter("contact");
        nameOfChoreografi = request.getParameter("choreografiName");
        ageCategory= request.getParameter("ageCategory");
        danceCategory = request.getParameter("danceCategory");
        nameOfChoreografer = request.getParameter("nameOfChoreografer");
        numberOfDancer = Integer.parseInt(request.getParameter("numOfDancer"));
        lenghtOfDance = request.getParameter("lenghtOfDance");
        numberOfDancerInGroup = Integer.parseInt(request.getParameter("numOfDancerInGroup"));
        meansOfTransport = request.getParameter("meansOfTransport");
        message = request.getParameter("message");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            ApplicationForm applicationForm = getApplicationForm();
            em.persist(applicationForm);

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

        response.sendRedirect("index.jsp");
    }

    private ApplicationForm getApplicationForm() {
        ApplicationForm applicationForm = new ApplicationForm();
        applicationForm.setNameOfClub(nameOfClub);
        applicationForm.setContact(contact);
        applicationForm.setNameOfChoreografi(nameOfChoreografi);
        applicationForm.setAgeCategory(ageCategory);
        applicationForm.setDanceCategory(danceCategory);
        applicationForm.setNameOfChoreografer(nameOfChoreografer);
        applicationForm.setNumberOfDancer(numberOfDancer);
        applicationForm.setLenghtOfDance(lenghtOfDance);
        applicationForm.setNumberOfDancerInGroup(numberOfDancerInGroup);
        applicationForm.setMeansOfTransport(meansOfTransport);
        applicationForm.setMessage(message);
        return applicationForm;
    }
}
