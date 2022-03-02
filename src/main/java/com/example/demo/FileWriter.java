package com.example.demo;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Scanner;

@Service
public class FileWriter extends Info{
    File filer = new File("EnrolledStudents.txt");  //kerrotaan mihin tiedostoon tallennetaan tiedot

    public String enroll(String enrollStudent, String enrollCourse) throws IOException{     //talletetaan tiedot
        java.io.FileWriter WriteToFile = new java.io.FileWriter("EnrolledStudents.txt", true);
        WriteToFile.append(enrollStudent);
        WriteToFile.append(enrollCourse);
        WriteToFile.close();
        return "Oppilas lisätty kurssille!" + back; //opiskelija lisätty kurssille, haetaan Info luokasta back muuttujalla buttoni jolla palataan index.html etusivulle

    }
    public String GetEnrolled(){            //haetaan oppilaat kursseilla
        StringBuilder data = new StringBuilder();
        try{
            if(filer.length()==0){          //mikäli ei yhtään oppilaita ilmoitettuna kursseille tulostetaan viesti
                return "Ei yhtään oppilaita ilmoitettuna kursseille!" +back;
            }else {
                                            //lisätään oppilas kurssille, mikäli .txt tiedostoa ei ole, se luodaan tässä
                Scanner myFiler = new Scanner(filer);
                while (myFiler.hasNextLine()) {
                    data.append(myFiler.nextLine());
                }
                myFiler.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
            return "Tippuiko tiedostoni katiskaan, nyt on kaikki hukassa" + back;
        }
        return data + back;
    }
}
