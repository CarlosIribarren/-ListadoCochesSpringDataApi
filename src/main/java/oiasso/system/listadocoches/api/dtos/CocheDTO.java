package oiasso.system.listadocoches.api.dtos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * CocheDTO
 */
public class CocheDTO {

    // *********************
	// ***** Atributos *****
	// *********************

	/** Matricula */
	@ApiModelProperty(value = "Matricula del coche", required = true)
	private String matricula;

	/** Marca */
	private String marca;

	/** Modelo */
	private String modelo;

	/** Fecha de matriculacion */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaMatriculacion;

	/** Motor */
    private String motor;
    
    /** Si la antiguedad del vehiculo es mayor de 25 años */
    private Boolean isMatriculadoAntiguo;

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getFechaMatriculacion() {
        return this.fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public String getMotor() {
        return this.motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }


    public Boolean isIsMatriculadoAntiguo() {
        return this.isMatriculadoAntiguo;
    }

    public Boolean getIsMatriculadoAntiguo() {
        return this.isMatriculadoAntiguo;
    }

    public void setIsMatriculadoAntiguo(Boolean isMatriculadoAntiguo) {
        this.isMatriculadoAntiguo = isMatriculadoAntiguo;
    }


}