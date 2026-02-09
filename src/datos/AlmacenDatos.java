package datos;
import java.util.ArrayList;

import modelos.Usuario;
import modelos.Cuenta;
import modelos.Moneda;

public class AlmacenDatos {
	
	public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public static ArrayList<Cuenta> listaCuentas = new ArrayList<>();
    public static ArrayList<Moneda> listaMonedas = new ArrayList<>();
    
    public static Usuario clientePorDni(String dni) {
    	for(int i = 0; i < listaUsuarios.size(); i++) {
    		Usuario user = listaUsuarios.get(i);
    		if(user.getDNI().equals(dni)) {
    			return user;
    		}
    	}
    	return null;
    }
    
    

}
