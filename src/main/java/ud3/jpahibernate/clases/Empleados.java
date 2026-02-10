package ud3.jpahibernate.clases;


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity 
@Table(name = "EMPLEADOS")
public class Empleados {

	@Id
    //@GeneratedValue(strategy=GenerationType.AUTO) -- Autoincrement
	@Column(name = "emp_no", nullable = false)
	private short empNo;	
	
	@ManyToOne
	@JoinColumn(name="dept_no")
	private Departamentos departamentos;
	
	private String apellido;
	private String oficio;
	private Short dir;
	
	@Column(name = "fecha_alt")
	private Date fechaAlt;
	
	private BigDecimal salario;
	private BigDecimal comision;
	
	@OneToMany(mappedBy="dir") //atributo en Empleados
	private Set<Empleados> empleacargo = new HashSet<Empleados>(0);

	public Set<Empleados> getEmpleacargo() {
		return empleacargo;
	}

	public void setEmpleacargo(Set<Empleados> empleacargo) {
		this.empleacargo = empleacargo;
	}

	public Empleados() {
	}

	public Empleados(short empNo) {
		this.empNo = empNo;
	}

	public Empleados(short empNo, Departamentos departamentos, String apellido, String oficio, Short dir, Date fechaAlt,
			BigDecimal salario, BigDecimal comision) {
		this.empNo = empNo;
		this.departamentos = departamentos;
		this.apellido = apellido;
		this.oficio = oficio;
		this.dir = dir;
		this.fechaAlt = fechaAlt;
		this.salario = salario;
		this.comision = comision;
	}

	public short getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(short empNo) {
		this.empNo = empNo;
	}

	public Departamentos getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(Departamentos departamentos) {
		this.departamentos = departamentos;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getOficio() {
		return this.oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public Short getDir() {
		return this.dir;
	}

	public void setDir(Short dir) {
		this.dir = dir;
	}

	public Date getFechaAlt() {
		return this.fechaAlt;
	}

	public void setFechaAlt(Date fechaAlt) {
		this.fechaAlt = fechaAlt;
	}

	public BigDecimal getSalario() {
		return this.salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getComision() {
		return this.comision;
	}

	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}

}
