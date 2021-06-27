package ru.dstu.application.csvworker;

import ru.dstu.application.entities.Worker;

import java.io.*;
import java.util.ArrayList;

public class CSVWorker implements Serializable{
    private final String fileName;
    private final ArrayList<Worker> workers;

    public CSVWorker(String fileName) throws IOException {
        this.fileName = fileName;
        this.workers = getObjectsList(fileName);
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    private ArrayList<Worker> getObjectsList(String fileName) throws IOException {
        String del = ";";
        String[] splitString;
        ArrayList<Worker> ret = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                splitString = line.replaceAll(String.valueOf((char) 65279),"").split(del);
                if (checkInteger(splitString[0])&&checkInteger(splitString[4])&&checkInteger(splitString[5])){
                    Worker worker;
                    worker = new Worker(splitString[1], splitString[2], splitString[3], Integer.parseInt(splitString[4]), Integer.parseInt(splitString[5]));
                    ret.add(worker);
                }
                line = reader.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    private boolean checkInteger(String str){
        boolean res = false;
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if(!(ch[i] >= 48 && ch[i] <= 59)){
                return false;
            }
        }
        return true;
    }
}
