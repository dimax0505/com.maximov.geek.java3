package DataBase_Lesson6;

import java.util.HashSet;
import java.util.TreeSet;

public class Students {

    private int id;
   private String name;
    private double assesment;


    public Students(String name, double assesment) {

        this.name = name;
        this.assesment = assesment;
    }
    Students(int id, String name, double assesment) {
        this.id = id;
        this.name = name;
        this.assesment = assesment;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Students other = (Students) obj;
        if (id != other.id)
            return false;
        if (assesment != other.assesment)
            return false;
        return name.equals(((Students) obj).name);
    }

    @Override
    public String toString() {
        return String.format("Студент [id=%d, фамилия - %s, оценка-%s]",id,name,String.valueOf(assesment));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAssessment() { return assesment; }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAssesment(double assesment) {
        this.assesment = assesment;
    }
}
