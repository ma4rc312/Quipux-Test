package com.quipux.prueba.controllers.numbers;

import com.quipux.prueba.models.numbers.NumberModel;
import com.quipux.prueba.services.numbers.NumberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class numberController {
    private final NumberService numberService;
    public numberController(NumberService numberService) {
         this.numberService = numberService;
    }
    @PostMapping("/verifyNumber")
    public String verificarNumero(@RequestBody NumberModel request) {
        return numberService.verificarNumero(request.getNumber());
    }
}
