package top.ibamboo.practice.design.patten.observer.selfdefine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bamboo on 2017/8/30.
 */
public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    private int state;


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            if(!observer.update()){
                System.out.println(observer.getClass() + "update failed");
                break;
            }
        }
        Class a =  Subject.class;
    }
}
