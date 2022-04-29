package com.example.ejb3;

import com.example.ejb3.entity.Employee;
import com.example.ejb3.entity.Message;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class Manager {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("practice");
    private final EntityManager entityManager = factory.createEntityManager();

    public Manager() { }

    public boolean createMessage(Message message) {
        if (!validMessage(message)) {
            return false;
        }
        entityManager.getTransaction().begin();
        entityManager.persist(message);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return true;
    }

    public List<Message> getAllMessages() {
        String req = "SELECT * FROM messages";
        Query query = entityManager.createNativeQuery(req, Message.class);
        return (List<Message>) query.getResultList();
    }

    public List<Employee> getAllEmployees() {
        String req = "SELECT * FROM emp";
        Query query = entityManager.createNativeQuery(req, Employee.class);
        return (List<Employee>) query.getResultList();
    }

    public Employee getEmployeeById(Long id) {
        if (id == null) {
            return null;
        }
        Message message = new Message();
        message.setText(String.valueOf(id));
        message.setDate(LocalDateTime.now());
        createMessage(message);
        return entityManager.find(Employee.class, id);
    }

    public Employee getEmployeeByName(String name) {
        if (name == null) {
            return null;
        }
        Message message = new Message();
        message.setText(name);
        message.setDate(LocalDateTime.now());
        createMessage(message);
        String req = "SELECT * FROM emp WHERE ename=?1";
        Query query = entityManager.createNativeQuery(req, Employee.class);
        query.setParameter(1, name);
        return (Employee)query.getSingleResult();
    }

    private boolean validMessage(Message message) {
        return message != null && message.getText() != null && !message.getText().equals("");
    }
}
