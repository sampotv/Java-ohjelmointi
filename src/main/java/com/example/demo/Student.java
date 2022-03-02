package com.example.demo;


import java.util.ArrayList;
import java.util.List;

public class Student extends Info{          //Luodaan student luokka joka perii info luokan

    private String fname;                   //luodaan muuttujat
    private String lname;
    private int studentid;
    private static int oldid =1;
    private final List<Student> students = new ArrayList<>();


    public Student( int studentid, String fname, String lname) {

        this.studentid= oldid++;        //automaattisesti nostetaan id kun luodaan uusi oppilas,
        this.fname = fname;             //ensimmäisenä tulee arvo 2, koska yksi oppilas hard koodattuna
        this.lname = lname;

    }

public Student(){       // hard koodataan yksi oppilas valmiiksi listalle
        students.add(new Student(1, "Malli", "Oppilas"));
}
    public String setStudent(String fname, String lname) {
        //uuden opiskelijan lisäys, id kasvaa automaattisesti
        //studentid=studentid+1;
        Student s = new Student(studentid, fname, lname);
        students.add(s);
        return "Oppilas lisätty!" + back;     //opiskelija lisätty, haetaan Info luokasta back muuttujalla buttoni jolla palataan index.html etusivulle
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getStudentid() {
        return studentid;
    }
    public String getStudents(){                //haetaan opiskelijat ja tulostetaan tiedot
        StringBuilder valueString=new StringBuilder();
        if(students.isEmpty()){
            return "Ei yhtään opiskelijaa! Lisää ensin opiskelijoita.";
        }
        for (Student s : students) {
            valueString.append("<br><br>Oppilas ID: ").append(s.getStudentid());
            valueString.append("<br>Etunimi: ").append(s.getFname());
            valueString.append("<br>Sukunimi: ").append(s.getLname());
        }return ""+ valueString;
    }
    public String  getStudentId(String studentid){      //haetaan oppilaan tiedot ID tunnuksella
            int id = Integer.parseInt(studentid);
            Student s = students.get(id - 1);
            return "<br><br>Oppilaan nimi: " + s.getFname() + " " + s.getLname();
        }
    }


