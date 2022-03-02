package com.example.demo;

import org.springframework.stereotype.Service;

import javax.security.sasl.SaslClient;
import java.io.*;
import java.util.Scanner;

@Service
public class FilerService extends Info{
    File filer = new File("EnrolledStudents.txt");  //kerrotaan mihin tiedostoon tallennetaan tiedot

    public String enroll(String enrollStudent, String enrollCourse) throws IOException{     //talletetaan tiedot
            FileWriter WriteToFile = new FileWriter("EnrolledStudents.txt", true);
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

                Scanner myFiler = new Scanner(filer);
                while (myFiler.hasNextLine()) {
                    data.append(myFiler.nextLine());
                }
                myFiler.close();
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            return "Lisäys ei onnistunut, tiedosto hukassa" + back;
        }
        return data + back;
    }
}
