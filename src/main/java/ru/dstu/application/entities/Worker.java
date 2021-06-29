package ru.dstu.application.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "Worker")
@Table(name = "worker")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToMany (mappedBy="worker", fetch=FetchType.EAGER)
    private Collection<Task> tasks;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "time")
    private int time;

    @Column(name = "salary")
    private int salary;

    public Worker(
            String name,
            String surname,
            String patronymic,
            int time,
            int salary
    ) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.time = time;
        this.salary = salary;
    }

    public Worker() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Task> getTask() {
        return this.tasks;
    }

    public void setTask(Collection<Task> tasks) {
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String name) {
        this.patronymic = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "WorkerAbstract{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", time=" + time +
                ", salary='" + salary + '\'' +
                '}';
    }
}
