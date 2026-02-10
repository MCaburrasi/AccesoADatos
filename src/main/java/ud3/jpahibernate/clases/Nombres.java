package ud3.jpahibernate.clases;

import java.time.LocalDate;

import jakarta.persistence.*;

/*
 CREATE TABLE NOMBRES(
   ID NUMBER(3) PRIMARY KEY,
   NOMBRE_PERSONA VARCHAR2(20 CHAR) NOT NULL,
   FECHA_NAC DATE
);
 */

@Entity // Marca esta clase como una entidad de Hibernate
@Table(name = "NOMBRES") // Especifica el nombre de la tabla en la BD

public class Nombres {
	@Id // Define la clave primaria
	int id;

	@Column(name = "nombre_persona", nullable = false, length = 20) // Mapea la columna "nombre"
	private String nombre;

	
	@Column(name = "fecha_nac" , nullable = false )
	private LocalDate fecha;

	public Nombres(int id, String nombre, LocalDate fecha) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
	}

	public Nombres() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechac() {
		return fecha;
	}

	public void setFechanac(LocalDate fecha) {
		this.fecha = fecha;
	}

}
