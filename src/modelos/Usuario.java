package modelos;

public class Usuario {
	private String DNI;
	private String nombre;
	private String password;
	
	public Usuario(String DNI, String nombre, String password) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.password = password;
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
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}


