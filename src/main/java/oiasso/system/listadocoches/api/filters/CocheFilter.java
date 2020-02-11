package oiasso.system.listadocoches.api.filters;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class CocheFilter {

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
	LocalDate fechaInicio;
	
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
