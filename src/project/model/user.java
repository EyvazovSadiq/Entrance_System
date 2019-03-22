package project.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Sadiq
 * Date: 1/1/17
 * Time: 3:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class user {

    private int id;
    private String name ;
    private String surname ;
    private String end_time ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", end_time='" + end_time + '\'' +
                '}';
    }
}




