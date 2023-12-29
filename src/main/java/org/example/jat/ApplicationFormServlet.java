package org.example.jat;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Optional;

@WebServlet("/saveApplicationForm")
public class ApplicationFormServlet extends HttpServlet {
    private  FormResponse formResponse;
    private static final String PERSISTENCE_UNIT_NAME = "myPersistenceUnit";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        BufferedReader reader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        formResponse = objectMapper.readValue(stringBuilder.toString(), FormResponse.class);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Dance dance = getDance();

            for(Member member : formResponse.getMembers()){
                Member mem = duplicityMember(member.getName(), member.getLastName(), member.getDateOfBirth(), em).orElse(null);
                if(mem == null){
                    mem = getMember(member);
                }
                mem.getDances().add(dance);
                dance.getMembers().add(mem);
                em.persist(mem);
            }

            em.persist(dance);

            DanceGroup danceGroup  = duplicityDanceGroup(formResponse.getGroupName(), em).orElse(null);
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

        response.setContentType("application/json");
        response.sendRedirect("index.jsp");
    }

    private ApplicationForm getApplicationForm() {
        ApplicationForm applicationForm = new ApplicationForm();
        applicationForm.setContact(formResponse.getContact());
        applicationForm.setAgeCategory(formResponse.getAgeCategory());
        applicationForm.setMeansOfTransport(formResponse.getMeansOfTransport());
        applicationForm.setMessage(formResponse.getMessage());
        return applicationForm;
    }

    private Dance getDance(){
        Dance dance = new Dance();
        dance.setName(formResponse.getChoreografiName());
        dance.setChoreographer(formResponse.getNameOfChoreografer());
        dance.setCategory(formResponse.getDanceCategory());
        dance.setNumOfDancer(formResponse.getNumOfDancer());
        dance.setLenght(formResponse.getLenghtOfDance());
        return dance;
    }

    private DanceGroup getDanceGroup(){
        DanceGroup danceGroup = new DanceGroup();
        danceGroup.setName(formResponse.getGroupName());
        danceGroup.setNumOfDancer(formResponse.getNumOfDancerInGroup());
        return danceGroup;
    }

    private Member getMember(Member member){
        Member mem = new Member();
        mem.setName(member.getName());
        mem.setLastName(member.getLastName());
        mem.setDateOfBirth(member.getDateOfBirth());
        return mem;
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

    private Optional<Member> duplicityMember(String name, String lastName, String dateOfBirth, EntityManager em){

        try {
            TypedQuery<Member> query = em.createQuery(
                    "SELECT k FROM Member k " +
                            "WHERE k.name = :name " +
                            "AND k.lastName = :lastName " +
                            "AND k.dateOfBirth = :dateOfBirth", Member.class);
            query.setParameter("name", name);
            query.setParameter("lastName", lastName);
            query.setParameter("dateOfBirth", dateOfBirth);
            return Optional.of(query.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }

    }
}
