package ProgressSave;

import SubjectState.Subject;

import java.util.ArrayList;
import java.util.Arrays;

public class Memento {
    private int time;
    private ArrayList<Subject> subjectList;
    private double[][] contactTimes;
    private double[][] infectionTimes;

    public Memento(int time, ArrayList<Subject> subjectList, double[][] contactTimes, double[][]infectionTimes) {
        this.time = time;
        this.subjectList = new ArrayList<>(subjectList.size());

        for (Subject subject: subjectList) {
            try {
                this.subjectList.add((Subject) subject.clone());
            } catch (CloneNotSupportedException e) {

            }
        }

        this.contactTimes = deepCopy(contactTimes);
        this.infectionTimes = deepCopy(infectionTimes);
    }

    private double[][] deepCopy(double[][] original) {
        if (original == null) {
            return null;
        }

        int rows = original.length;
        int cols = original[0].length;
        double[][] copy = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, cols);
        }

        return copy;
    }

    public int getTime() {
        return time;
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    public double[][] getContactTimes() {
        return contactTimes;
    }

    public double[][] getInfectionTimes() {
        return infectionTimes;
    }
}
