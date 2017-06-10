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
public class Observer implements IObserver {
    
    Subject subject;
    List<String> names;
    
    public Observer(Subject subject){
        this.subject=subject;
        this.subject.register(this); 
        
    }

    @Override
    public void update() {
         names=subject.getNames();
    }

    public List<String> getNames() {
        return names;
    }
    
}
