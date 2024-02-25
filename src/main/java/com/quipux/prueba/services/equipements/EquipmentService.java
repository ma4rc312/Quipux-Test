package com.quipux.prueba.services.equipements;
import java.util.ArrayList;
import java.util.List;

import com.quipux.prueba.models.equipements.EquipementModel;
import org.springframework.stereotype.Service;
@Service
public class EquipmentService {
    private final List<EquipementModel> equipementList = new ArrayList<>();

    public void addEquipement(EquipementModel equipement) {
    equipementList.add(equipement);
    }

    public EquipementModel findEquipement(int  equipementIndex) {
        // lógica para encontrar un equipo por índice
    if (equipementIndex < 0 || equipementIndex >= equipementList.size()){
        return null;
    }
    return equipementList.get(equipementIndex);
    }

}
