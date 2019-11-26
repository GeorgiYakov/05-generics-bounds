package ohm.softa.a05;

import ohm.softa.a05.collections.SimpleFilter;
import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.collections.SimpleListImpl;
import ohm.softa.a05.model.Plant;
import ohm.softa.a05.model.PlantColor;

import java.util.Iterator;

public class PlantBed <T extends Plant> {

    private SimpleList<T> plants = new SimpleListImpl<>();

    public void add(T o){
        plants.add(o);
    }

    public int size(){
        return plants.size();
    }

    public SimpleList<T> getPlantsByColor(PlantColor color){
        return plants.filter(new SimpleFilter<T>() {
            @Override
            public boolean include(T item) {
                return item.getColor().equals(color) ;
            }
        });
    }

    public SimpleList<T> getPlants() {
        //hack to get a copy of the current list
        return plants.map(p -> p);
    }
}
