package com.example.demo;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Scanner;

@Service
public class FileWriter extends Info{
    File txt = new File("EnrolledStudents.txt");  //kerrotaan mihin tiedostoon tallennetaan tiedot

    public String enroll(String enrollStudent, String enrollCourse) throws IOException{     //tallennetaan tiedot tiedostoon
        java.io.FileWriter WriteToFile = new java.io.FileWriter("EnrolledStudents.txt", true);
        WriteToFile.append(enrollStudent);
        WriteToFile.append(enrollCourse);
        WriteToFile.close();
        return "Opiskelija lisätty kurssille!" + back; //opiskelija lisätty kurssille, haetaan Info luokasta back muuttujalla buttoni jolla palataan index.html etusivulle

    }
    public String GetEnrolled(){            //haetaan oppilaat kursseilla
        StringBuilder data = new StringBuilder();
        try{
            if(txt.length()==0){          //mikäli ei yhtään oppilaita ilmoitettuna kursseille tulostetaan viesti
                return "Ei yhtään oppilaita ilmoitettuna kursseille!" +back;
            }else {
                                            //näytetään oppilaat kursseilla, mikäli .txt tiedostoa ei ole, se luodaan tässä
                Scanner filu = new Scanner(txt);
                while (filu.hasNextLine()) {
                    data.append(filu.nextLine());
                }
                filu.close();
            }
        }catch (Exception e) {
            return "Tippuiko tiedostoni katiskaan, nyt on kaikki hukassa" + back;
        }
        return data + back;
    }
}
