package oiasso.system.listadocoches.api.converters;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import oiasso.system.listadocoches.api.dtos.CocheDTO;
import oiasso.system.listadocoches.api.entitys.Coche;

@Component
public class CocheConverter extends AbstractConverter<Coche, CocheDTO> {

    @Override
    public Coche fromDto(CocheDTO dto) {
        Coche coche = new Coche();
        coche.setMatricula(dto.getMatricula());
        coche.setMarca(dto.getMarca());
        coche.setModelo(dto.getModelo());
        coche.setFechaMatriculacion(dto.getFechaMatriculacion());
        coche.setMotor(dto.getMotor());
        return coche;
    }

    @Override
    public CocheDTO fromEntity(Coche entity) {
        CocheDTO cocheDTO = new CocheDTO();
        cocheDTO.setMatricula(entity.getMatricula());
        cocheDTO.setMarca(entity.getMarca());
        cocheDTO.setModelo(entity.getModelo());
        cocheDTO.setFechaMatriculacion(entity.getFechaMatriculacion());
        cocheDTO.setMotor(entity.getMotor());

        // IsMatriculadoAntiguo
        LocalDate currentDate = LocalDate.now();
        if(entity.getFechaMatriculacion().isAfter(currentDate.minusYears(25))){
            cocheDTO.setIsMatriculadoAntiguo(false);
        } else {
            cocheDTO.setIsMatriculadoAntiguo(true);
        }

        return cocheDTO;
    }

    
}