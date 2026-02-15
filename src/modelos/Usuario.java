package modelos;

public class Usuario {
	private String DNI;
	private String nombre;
	private String clave;
	public Object cuenta;
	
	
	public Usuario(String DNI, String nombre, String clave) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.clave = clave;
		
	}

	

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return clave;
	}

	public void setPassword(String password) {
		this.clave = password;
	}
	
	
}


