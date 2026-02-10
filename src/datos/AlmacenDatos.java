package datos;
import java.util.ArrayList;

import modelos.Usuario;
import modelos.Cuenta;
import modelos.Moneda;

public class AlmacenDatos {
	
	public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public static ArrayList<Cuenta> listaCuentas = new ArrayList<>();
    public static ArrayList<Moneda> listaMonedas = new ArrayList<>();
    
    static {
    	listaUsuarios.add(new Usuario("10203040", "Juan Pérez", "1234"));
    	listaUsuarios.add(new Usuario("40506070", "María López", "5678"));
    	listaUsuarios.add(new Usuario("70809010", "Carlos García", "9012"));
    	listaUsuarios.add(new Usuario("09876543", "Ana Martínez", "3456"));
    	listaUsuarios.add(new Usuario("11223344", "Luis Rodríguez", "7890"));
    	listaUsuarios.add(new Usuario("55667788", "Elena Sánchez", "2345"));
    	listaUsuarios.add(new Usuario("99887766", "Pedro Gómez", "6789"));
    	listaUsuarios.add(new Usuario("44332211", "Sofía Díaz", "0123"));
    	listaUsuarios.add(new Usuario("12345678", "Jorge Fernández", "4567"));
    	listaUsuarios.add(new Usuario("87654321", "Lucía Ruiz", "8901"));
    	listaUsuarios.add(new Usuario("20304050", "Miguel Hernández", "2345"));
    	listaUsuarios.add(new Usuario("60708090", "Paula Jiménez", "6789"));
    	listaUsuarios.add(new Usuario("15253545", "David Álvarez", "0123"));
    	listaUsuarios.add(new Usuario("95857565", "Carmen Moreno", "4567"));
    	listaUsuarios.add(new Usuario("30405060", "Javier Muñoz", "8901"));
    	listaUsuarios.add(new Usuario("75859505", "Raquel Romero", "2345"));
    	listaUsuarios.add(new Usuario("10101010", "Alberto Alonso", "6789"));
    	listaUsuarios.add(new Usuario("20202020", "Marta Gutiérrez", "0123"));
    	listaUsuarios.add(new Usuario("30303030", "Diego Navarro", "4567"));
    	listaUsuarios.add(new Usuario("40404040", "Beatriz Torres", "8901"));
    }
    
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
