package org.example.jat.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.jat.UserResponse;
import org.example.jat.entity.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/loginPage")
public class LoginPageServlet extends HttpServlet {
    private static final String PERSISTENCE_UNIT_NAME = "loginPersistenceUnit";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login.jsp");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        UserResponse formUserResponse = objectMapper.readValue(stringBuilder.toString(), UserResponse.class);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            String login = formUserResponse.getLogin();
            String password = formUserResponse.getPassword();

            User user = loginCheck(password, login, em).orElse(null);

            if(user == null){
                System.out.println("Přihlášení se nezdařilo");
                response.sendRedirect("/JAT_war_exploded/index.jsp");
            }else{
                System.out.println("Přihlášen");
                response.sendRedirect("/JAT_war_exploded/overview.jsp");
            }

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
    }

    private Optional<User> loginCheck(String password, String login, EntityManager em){

        try {
            TypedQuery<User> query = em.createQuery(
                    "SELECT k FROM User k WHERE k.login = :login AND k.password = :password", User.class);
            query.setParameter("password", password);
            query.setParameter("login", login);
            return Optional.of(query.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }
}
