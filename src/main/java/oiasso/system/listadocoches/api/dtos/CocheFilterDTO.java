package oiasso.system.listadocoches.api.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class CocheFilterDTO {

	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
	LocalDate fechaInicio;
	
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
	LocalDate fechaFin;

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}



	
	
	
}
