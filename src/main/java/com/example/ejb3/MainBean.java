package com.example.ejb3;

import com.example.ejb3.entity.Employee;
import com.example.ejb3.entity.Message;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "mainBean")
@SessionScoped
public class MainBean implements Serializable {

    private Manager manager = new Manager();

    private String emptyStr;

    private Long id;

    private String name;

    private List<Message> messageList;
    private List<Employee> employeeList;

    public String readAllMessages() {
        messageList = manager.getAllMessages();
        if (messageList.isEmpty()) {
            emptyStr = "Table with messages is empty";
            return "index";
        }
        return "messages";
    }

    public String readAllEmployees() {
        employeeList = manager.getAllEmployees();
        if (employeeList.isEmpty()) {
            emptyStr = "Table with employees is empty";
            return "index";
        }
        return "employees";
    }

    public String readEmployeeById() {
        Employee employee = manager.getEmployeeById(id);
        if (employee == null) {
            emptyStr = String.format("Employee with id %d not found", id);
            return "index";
        }
        employeeList = new ArrayList<>();
        employeeList.add(employee);
        return "employees";
    }

    public String readEmployeeByName() {
        Employee employee = manager.getEmployeeByName(name);
        if (employee == null) {
            emptyStr = String.format("Employee with name %s not found", name);
            return "index";
        }
        employeeList = new ArrayList<>();
        employeeList.add(employee);
        return "employees";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmptyStr() {
        return emptyStr;
    }

    public void setEmptyStr(String emptyStr) {
        this.emptyStr = emptyStr;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
