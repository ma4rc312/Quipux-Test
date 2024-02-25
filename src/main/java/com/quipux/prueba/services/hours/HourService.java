package com.quipux.prueba.services.hours;


import org.springframework.stereotype.Service;

@Service
public class HourService {

    public String convertHoursIntoWords(int hour, int minutes) {
        if (hour >=  1 && hour <  12 && minutes >=  0 && minutes <  60) {
            String[] hoursInWords = {"cero", "una", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "once"};
            String[] minutesInWords = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve", "veinte", "veintiún", "veintidós", "veintitrés", "veinticuatro", "veinticinco", "veintiséis", "veintisiete", "veintiocho", "veintinueve", "treinta", "treinta y uno", "treinta y dos", "treinta y tres", "treinta y cuatro", "treinta y cinco", "treinta y seis", "treinta y siete", "treinta y ocho", "treinta y nueve", "cuarenta", "cuarenta y uno", "cuarenta y dos", "cuarenta y tres", "cuarenta y cuatro", "cuarenta y cinco", "cuarenta y seis", "cuarenta y siete", "cuarenta y ocho", "cuarenta y nueve", "cincuenta", "cincuenta y uno", "cincuenta y dos", "cincuenta y tres", "cincuenta y cuatro", "cincuenta y cinco", "cincuenta y seis", "cincuenta y siete", "cincuenta y ocho", "cincuenta y nueve"};

            String timeInWords = hoursInWords[hour];
            String minutesInFinalWords = "";

            if (minutes ==  0) {
                minutesInFinalWords = "en punto";
            } else if (minutes %  15 ==  0) {
                minutesInFinalWords = "y " + minutesInWords[minutes];
            } else if (minutes <  30) {
                minutesInFinalWords = "y " + minutesInWords[minutes];
            } else {
               // minutosEnPalabrasFinal = "menos " + minutosEnPalabras[60 - minutos];
                minutesInFinalWords = "y " + minutesInWords[minutes];
            }

            if (minutes !=  0 && minutes !=  15 && minutes !=  30) {
                minutesInFinalWords += " minutos";
            }

            return timeInWords + " " + minutesInFinalWords;
        } else {
            return "Entrada inválida. Por favor, asegúrate de que la hora está entre  1 y  11 y los minutos están entre  0 y  59.";
        }
    }
}
