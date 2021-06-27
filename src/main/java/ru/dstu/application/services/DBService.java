package ru.dstu.application.services;

import ru.dstu.application.csvworker.CSVWorker;
import ru.dstu.application.dao.Dao;
import ru.dstu.application.dao.entitiesDao.TaskDao;
import ru.dstu.application.dao.entitiesDao.WorkerDao;
import ru.dstu.application.entities.Task;
import ru.dstu.application.entities.Worker;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DBService {

    private String csvFile;

    public DBService(String csvFile) {
        this.csvFile = csvFile;
    }

    public void run() throws SQLException, IOException {
        CSVWorker csvWorker = new CSVWorker(csvFile);
        ArrayList<Worker> records = csvWorker.getWorkers();
        executeInsert(records);
        executeAllSelect();
        executeUpdate();
        executeConditionSelect();
    }

    private void executeInsert(ArrayList<Worker> arrayList) {
        for (Worker w : arrayList) {
            Dao<Worker> workerDao = new WorkerDao();
            workerDao.save(w);
            Dao<Task> taskDao = new TaskDao();

            int max = 100;
            int rnd = (int) (Math.random() * ++max);

            Task task = new Task(w, "test_task", rnd, 5);
            taskDao.save(task);
        }
    }

    private void executeAllSelect() throws SQLException {
        Dao<Task> taskDao = new TaskDao();
        for (Task t : taskDao.findAll()) {
            System.out.println(
                    "Task name: "+ t.getName() +
                    " Time: " + t.getTime() +
                    " Worker: " + t.getWorker().getName()
            );
        }
    }

    private void executeUpdate() {
        Dao<Task> taskDao = new TaskDao();
        Task task = taskDao.findAll().get(0);
        task.setName("Change task");
        taskDao.save(task);
        System.out.println("Task name: "+ task.getName());
    }

    private void executeConditionSelect() throws SQLException {
        TaskDao taskDao = new TaskDao();
        for (Task t : taskDao.findByCondition(50, 5, 5)) {
            System.out.println(
                    "Task name: "+ t.getName() +
                            " Time: " + t.getTime() +
                            " Worker: " + t.getWorker().getName()
            );
        }
    }

    public String getCsvFile() {
        return csvFile;
    }

    public void setCsvFile(String csvFile) {
        this.csvFile = csvFile;
    }
}
