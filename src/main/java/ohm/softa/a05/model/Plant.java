package ohm.softa.a05.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

abstract public class Plant implements Comparable<Plant>{
    private double height;
    private String family;
    private String name;

    public Plant( String family, String name, double height){
        this.height = height;
        this.family = family;
        this.name = name;
    }

    public double getHeight(){
        return height;
    }

    public String getFamily(){
        return family;
    }

    public String getName(){
        return  name;
    }

     abstract public PlantColor getColor();

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return  true;
        if(!(obj instanceof Plant)) return false;

        Plant plant = (Plant) obj;

        return new EqualsBuilder()
                .append(getHeight(),plant.getHeight())
                .append(getColor(), plant.getColor())
                .append(getFamily(), plant.getFamily())
                .append(getName(), plant.getName())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17,37)
                .append(getColor())
                .append(getFamily())
                .append(getHeight())
                .append(getName())
                .toHashCode();

    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("height", height)
                .append("family", family)
                .append("name", name)
                .append("color", getColor())
                .toString();
    }

    @Override
    public int compareTo(Plant other) {
        return Double.compare(this.height, other.height);
    }


}


