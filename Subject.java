/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Subject implements ISubject {
    List<IObserver> observers;
    
    List<String> names;
    
    public Subject(){
        observers=new ArrayList<IObserver>();
        names=new ArrayList<String>();
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(String name) {
        names.add(name);
//        System.out.println(name);
        notifyObserver();       
    }
    
    public void removeName(String name){
        names.remove(name);
        notifyObserver();
    }

    @Override
    public void register(IObserver observer) {      
       observers.add(observer);
    }

    @Override
    public void unRegister(IObserver observer) {
         observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        
        for(IObserver ob:observers){
            ob.update();
        }
    }
    
}
