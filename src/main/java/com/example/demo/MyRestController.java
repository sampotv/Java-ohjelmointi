/**Tästä koodista vastasi Sampo Vuorento kurssille Java-ohjelmointi.
 * Käyttöliittymään en viitsinyt panostaa kun javasta oli vain kyse.
 * Pitäisi täyttyä vaatimukset arvosanaan 5.*/

package com.example.demo;


import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
public class MyRestController extends Info{



    Course c = new Course();
    Student s = new Student();
    FileWriter f = new FileWriter();



    @PostMapping("addcourse")       //tällä lisätään uusi kurssi
    public String addCourse(@RequestParam String course, @RequestParam String teacher){

        return c.setCourse(course, teacher);
    }
    @GetMapping("courses")          //tällä haetaan kurssit ja saadaan ne näkymään selaimessa
    public String getCourses() {
        return c.getCourses() + back;   //haetaan Info luokasta back muuttujalla buttoni jolla palataan index.html etusivulle
    }

    @PostMapping("addstudent")      //tällä lisätään uusi oppilas
    public String addStudent(@RequestParam String fname, @RequestParam String lname){
        return s.setStudent(fname, lname);
    }

    @GetMapping("students")         //tällä haetaan oppilaat ja saadaan ne tulostettua selaimeen
    public String getStudents(){
        return s.getStudents() + back;
    }

    @PostMapping("enroll")           //tällä lisätään olemassa oleva oppilas olemassa olevalle kurssille

    public String enroll(@RequestParam String courseid, @RequestParam String  studentid) throws IOException{

        String enrollStudent = s.getStudentId(studentid);
        String enrollCourse = c.getCourseId(courseid);
        return f.enroll(enrollStudent, enrollCourse);
    }

    @GetMapping("getenroll")         //tällä saadaan haettua tiedostoon talletetut kursseille lisätyt oppilaat
    public String getenroll(){
        return f.GetEnrolled();
    }
}
