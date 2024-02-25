package com.quipux.prueba.controllers.equipements;

import com.quipux.prueba.models.equipements.EquipementModel;
import com.quipux.prueba.models.equipements.PlayerModel;
import com.quipux.prueba.services.equipements.EquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "equipment")
public class equipementController {
    private final EquipmentService equipmentService;
    public equipementController (EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }
    @PostMapping("/add")
    public ResponseEntity<String> addEquipment(@RequestBody EquipementModel equipment) {
        try {
            equipmentService.addEquipement(equipment);
            return ResponseEntity.status(HttpStatus.CREATED).body("Equipo creado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear equipo: " + e.getMessage());
        }
    }

    @GetMapping("/reportBasic/{equipmentIndex}")
    public String generateBasicReport(@PathVariable("equipmentIndex") int equipmentIndex) {
        EquipementModel equipment = equipmentService.findEquipement(equipmentIndex);
        if (equipment == null) {
            return "Equipo no encontrado";
        }
        return "Nombre del equipo: " + equipment.getName() + "\n" +
                "Títulos ganados: " + equipment.getTitles() + "\n" +
                "Cantidad total de jugadores: " + (equipment.getPlayers().size() + equipment.getSubstitutes().size());
    }

    @GetMapping("/reportDetailed/{equipmentIndex}")
    public String generateDetailedReport(@PathVariable("equipmentIndex") int equipmentIndex) {
        EquipementModel equipment = equipmentService.findEquipement(equipmentIndex);
        if (equipment == null) {
            return "Equipo no encontrado";
        }
        StringBuilder report = new StringBuilder();
        report.append("Nombre del equipo: ").append(equipment.getName()).append("\n");
        report.append("Detalle de titulares:\n");
        for (PlayerModel player : equipment.getPlayers()) {
            report.append("Nombre: ").append(player.getName()).append(", Posición: ").append(player.getPosition()).append("\n");
        }
        report.append("Detalle de suplentes:\n");
        for (PlayerModel player : equipment.getSubstitutes()) {
            report.append("Nombre: ").append(player.getName()).append(", Posición: ").append(player.getPosition()).append("\n");
        }
        return report.toString();
    }
}
