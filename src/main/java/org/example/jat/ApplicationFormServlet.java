package org.example.jat;

import jakarta.persistence.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Optional;

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
    @Transactional
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

            Dance dance = getDance();
            em.persist(dance);

            DanceGroup danceGroup  = duplicityDanceGroup(nameOfClub, em).orElse(null);
            if(danceGroup == null) {
                danceGroup = getDanceGroup();
            }
            em.persist(danceGroup);

            ApplicationForm applicationForm = getApplicationForm();
            applicationForm.setDance(dance);
            applicationForm.setDancegroup(danceGroup);
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
        applicationForm.setContact(contact);
        applicationForm.setAgeCategory(ageCategory);
        applicationForm.setMeansOfTransport(meansOfTransport);
        applicationForm.setMessage(message);
        return applicationForm;
    }

    private Dance getDance(){
        Dance dance = new Dance();
        dance.setName(nameOfChoreografi);
        dance.setChoreographer(nameOfChoreografer);
        dance.setCategory(danceCategory);
        dance.setNumOfDancer(numberOfDancer);
        dance.setLenght(lenghtOfDance);
        return dance;
    }

    private DanceGroup getDanceGroup(){
        DanceGroup danceGroup = new DanceGroup();
        danceGroup.setName(nameOfClub);
        danceGroup.setNumOfDancer(numberOfDancerInGroup);
        return danceGroup;
    }

    private Optional<DanceGroup> duplicityDanceGroup(String nameOfClub, EntityManager em){

        try {
            TypedQuery<DanceGroup> query = em.createQuery(
                    "SELECT k FROM DanceGroup k WHERE k.name = :name", DanceGroup.class);
            query.setParameter("name", nameOfClub);
            return Optional.of(query.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }

    }
}
