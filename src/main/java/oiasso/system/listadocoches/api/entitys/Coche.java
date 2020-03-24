package oiasso.system.listadocoches.api.entitys;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("Model Coche")
@Entity
@Table(name = "coche")
public class Coche {

	// *********************
	// ***** Atributos *****
	// *********************

	/** Matricula */
	@Id
	@ApiModelProperty(value = "Matricula del coche", required = true)
	private String matricula;

	/** Marca */
	private String marca;

	/** Modelo */
	private String modelo;

	/** Fecha de matriculacion */
	@Column(name = "fecha_matriculacion")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaMatriculacion;

	/** Motor */
	private String motor;

	// *********************
	// **** Constructor ****
	// *********************

	/** Constructor sin parametros */
	public Coche() {
		super();
	}

	public Coche(String matricula, String marca, String modelo, LocalDate fechaMatriculacion, String motor) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaMatriculacion = fechaMatriculacion;
		this.motor = motor;
	}

	// *********************
	// ** Getter y Setter **
	// *********************

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDate getFechaMatriculacion() {
		return fechaMatriculacion;
	}

	public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
		this.fechaMatriculacion = fechaMatriculacion;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}
}
