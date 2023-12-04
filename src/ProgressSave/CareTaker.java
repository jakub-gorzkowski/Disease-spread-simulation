package ProgressSave;

import java.util.ArrayList;

public class CareTaker {
    private ArrayList<Memento> mementoList = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMemento(int timeIndex) {
        return mementoList.get(timeIndex);
    }

    public void removeSkippedMementos(int timeIndex) {
        if (timeIndex >= 0 && timeIndex < mementoList.size()) {
            mementoList.subList(timeIndex + 1, mementoList.size()).clear();
        }
    }

}
