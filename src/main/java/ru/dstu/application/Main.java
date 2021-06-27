package ru.dstu.application;

import ru.dstu.application.services.DBService;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        String inputFile;
        if (args.length == 0) {
            inputFile = "input.csv";
        } else {
            inputFile = args[0];
        }

        DBService dbService = new DBService(inputFile);
        dbService.run();
    }
}
