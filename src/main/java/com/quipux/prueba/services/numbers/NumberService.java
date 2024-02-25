package com.quipux.prueba.services.numbers;
import org.springframework.stereotype.Service;

@Service
public class NumberService {
    public String verificarNumero(int number) {
            if (number %  2 !=  0) {
                return "Quipux";
            } else {
                if (number >=  2 && number <=  5) {
                    return "No Quipux";
                } else if (number >=  6 && number <=  20) {
                    return "Quipux";
                } else if (number >  20) {
                    return "No Quipux";
                }
            }
            return "";
        }
    }


