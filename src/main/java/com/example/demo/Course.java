package com.example.demo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

public class Course extends Info{           //Luodaan course luokka joka perii info luokan
    private int courseid;                 //luodaan muuttujat
    private String course;
    private String teacher;
    private static int oldid=1;             //1 kurssi hard koodataan, aloitetaan ID kasvattaminen 1+1 arvosta

    private final List<Course> courses = new ArrayList<>();

    public Course (int courseid, String  course, String teacher) {
        this.courseid = oldid++;        //automaattisesti nostetaan id kun luodaan uusi kurssi,
        this.course = course;           //ensimmäisenä tulee arvo 2, koska yksi kurssi hard koodattuna
        this.teacher = teacher;
    }

    public Course() {       //hard koodataan yksi kurssi valmiiksi listalle
        courses.add(new Course(1, "Java-ohjelmointi", "Reima Riihimäki"));

    }

    private int getCourseid() {
        return courseid;
    }

    private String getCourse() {
        return course;
    }

    private String getTeacher() {
        return teacher;
    }

    public String setCourse(String course, String teacher){ //uuden kurssin lisäys, id kasvaa automaattisesti
        Course c = new Course(courseid, course, teacher);
        courses.add(c);
        return "Kurssi lisätty!" +back;   //kurssi lisätty, haetaan Info luokasta back muuttujalla buttoni jolla palataan index.html etusivulle
    }
    public String getCourses(){         //haetaan kurssit ja tulostetaan tiedot
        StringBuilder valueString= new StringBuilder();
        for (Course c : courses) {
            valueString.append("<br><br>Kurssin ID: ").append(c.getCourseid());
            valueString.append("<br>Kurssin nimi: ").append(c.getCourse());
            valueString.append("<br>Kurssin opettaja: ").append(c.getTeacher());
        }return ""+ valueString;
    }
    public String  getCourseId(String courseid){        //haetaan kurssin tiedot ID tunnuksella
        int getid = Integer.parseInt(courseid);
        Course s = courses.get(getid-1);
        return "<br>Kurssin nimi: " + s.getCourse() + "<br>Opettajan nimi: " + s.getTeacher();
    }
}
