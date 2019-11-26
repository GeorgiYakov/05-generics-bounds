package ohm.softa.a05.utils;

import ohm.softa.a05.PlantBed;
import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.collections.SimpleListImpl;
import ohm.softa.a05.model.Flower;
import ohm.softa.a05.model.Plant;
import ohm.softa.a05.model.PlantColor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class PlantBedUtility {

    private PlantBedUtility(){

    }

    public static <T extends Plant> Map<PlantColor, SimpleList<T>> splitBedByColor(PlantBed<T> bed){


        Map<PlantColor, SimpleList<T>> result = new HashMap<>();
        for (T plant : bed.getPlants()) {
            // if the result does not contain the color of the plant
            //insert the color and a new empty list
            if (!result.containsKey(plant.getColor())) {
                result.put(plant.getColor(), new SimpleListImpl<>());
            }
            //get the corresponding list and add the current plant
            result.get(plant.getColor()).add(plant);
        }


        return result;

    }

    public static <T extends Plant> Map<PlantColor, SimpleList<? extends T>>
    splitBedByColor2(PlantBed<? extends T> plantBed) {

        Map<PlantColor, SimpleList<? extends T>> result = new HashMap<>();
        /* iterate the enum values */
        for (PlantColor color : PlantColor.values()) {
            /* get all plants of the current color */
            result.put(color, plantBed.getPlantsByColor(color));
        }
        return result;
    }
}