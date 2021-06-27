package ru.dstu.application.entities;

import javax.persistence.*;

@Entity(name = "Task")
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @Column(name = "name")
    private String name;

    @Column(name = "spent_time")
    private int spent_time;

    @Column(name = "priority")
    private int priority;

    public Task(
            Worker worker,
            String name,
            int spent_time,
            int priority
    ) {
        this.worker = worker;
        this.name = name;
        this.spent_time = spent_time;
        this.priority = priority;
    }

    public Task() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return spent_time;
    }

    public void setTime(int spent_time) {
        this.spent_time = spent_time;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    @Override
    public String toString() {
        return "WorkerAbstract{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", spent_time=" + spent_time +
                ", priority='" + priority + '\'' +
                ", worker=" + worker +
                '}';
    }
}
