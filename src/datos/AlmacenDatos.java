package datos;
import java.time.LocalDateTime;
import java.util.ArrayList;

import modelos.Usuario;
import modelos.Cuenta;
import modelos.Moneda;
import modelos.Transaccion;

public class AlmacenDatos {
	
	public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public static ArrayList<Cuenta> listaCuentas = new ArrayList<>();
    public static ArrayList<Moneda> listaMonedas = new ArrayList<>();
    public static ArrayList<Transaccion> listaTransacciones = new ArrayList<>();
    public static int incrementadorCuenta = 4355;
    
    static {
    	
    	Moneda sol = new Moneda("S/.", "Soles", 1.00);
    	Moneda dolar = new Moneda("$", "Dolares", 3.85);
    	listaMonedas.add(sol);
    	listaMonedas.add(dolar);
    	
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
    	
    	listaCuentas.add(new Cuenta("CTA-1143359867", listaUsuarios.get(0), sol, 1250.50, "ACTIVO"));
    	listaCuentas.add(new Cuenta("CTA-1143360867", listaUsuarios.get(0), dolar, 1250.50, "ACTIVO"));
        listaCuentas.add(new Cuenta("CTA-1143369867", listaUsuarios.get(1), dolar, 3400.00, "ACTIVO"));
        listaCuentas.add(new Cuenta("CTA-1143379867", listaUsuarios.get(2), sol, 890.20, "ACTIVO"));
        listaCuentas.add(new Cuenta("CTA-1143389867", listaUsuarios.get(3), sol, 5600.00, "ACTIVO"));
        listaCuentas.add(new Cuenta("CTA-1143399867", listaUsuarios.get(4), dolar, 120.75, "ACTIVO"));
        listaCuentas.add(new Cuenta("CTA-1143409867", listaUsuarios.get(5), sol, 2340.00, "ACTIVO"));
        listaCuentas.add(new Cuenta("CTA-1143419867", listaUsuarios.get(6), dolar, 450.50, "ACTIVO"));
        listaCuentas.add(new Cuenta("CTA-1143429867", listaUsuarios.get(7), sol, 9800.00, "ACTIVO")); 
        listaCuentas.add(new Cuenta("CTA-1143439867", listaUsuarios.get(8), sol, 15.00, "ACTIVO"));   
        listaCuentas.add(new Cuenta("CTA-1143449867", listaUsuarios.get(9), dolar, 2100.30, "ACTIVO"));
        listaCuentas.add(new Cuenta("CTA-1143459867", listaUsuarios.get(10), sol, 670.00, "ACTIVO")); 
        listaCuentas.add(new Cuenta("CTA-1143469867", listaUsuarios.get(11), sol, 1200.00, "ACTIVO"));
        listaCuentas.add(new Cuenta("CTA-1143479867", listaUsuarios.get(12), dolar, 300.40, "ACTIVO"));
        listaCuentas.add(new Cuenta("CTA-1143489867", listaUsuarios.get(13), sol, 4500.60, "ACTIVO"));
        listaCuentas.add(new Cuenta("CTA-1143499867", listaUsuarios.get(14), sol, 89.90, "ACTIVO"));  
        listaCuentas.add(new Cuenta("CTA-1143509867", listaUsuarios.get(15), dolar, 1500.00, "ACTIVO"));
        listaCuentas.add(new Cuenta("CTA-1143519867", listaUsuarios.get(16), sol, 3200.00, "ACTIVO"));
        listaCuentas.add(new Cuenta("CTA-1143529867", listaUsuarios.get(17), dolar, 10.50, "ACTIVO"));
        listaCuentas.add(new Cuenta("CTA-1143539867", listaUsuarios.get(18), sol, 440.00, "ACTIVO")); 
        listaCuentas.add(new Cuenta("CTA-1143549867", listaUsuarios.get(19), sol, 2750.80, "ACTIVO"));
        
        for (int i = 0; i < listaCuentas.size(); i++) {

            Cuenta cuenta = listaCuentas.get(i);

            Transaccion t1 = new Transaccion(cuenta.getNumeroCuenta(), Transaccion.Tipo.Deposito, 500.00);
            t1.setFecha(LocalDateTime.now().minusDays(3)); 

            Transaccion t2 = new Transaccion(cuenta.getNumeroCuenta(), Transaccion.Tipo.Retiro, 150.50);
            t2.setFecha(LocalDateTime.now().minusDays(2)); 

            Transaccion t3 = new Transaccion(cuenta.getNumeroCuenta(), Transaccion.Tipo.Transferencia, 200.00);
            t3.setFecha(LocalDateTime.now().minusDays(1)); 

            listaTransacciones.add(t1);
            listaTransacciones.add(t2);
            listaTransacciones.add(t3);

            if (cuenta.getMovimientos() == null) {
                cuenta.setMovimientos(new ArrayList<>());
            }
            
            cuenta.getMovimientos().add(t1);
            cuenta.getMovimientos().add(t2);
            cuenta.getMovimientos().add(t3);
        }
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
    
    public static Cuenta cuentaPorNumero(String numeroCuenta) {
    	for(int i = 0; i < listaCuentas.size(); i++) {
    		Cuenta cuenta = listaCuentas.get(i);
    		if(cuenta.getNumeroCuenta().equals(numeroCuenta)) {
    			return cuenta;
    		}
    	}
    	return null;
    }
    
    public static Moneda monedaPorNombre(String nombre) {
    	for(int i = 0; i < listaMonedas.size(); i++) {
    		Moneda moneda = listaMonedas.get(i);
    		if(moneda.getNombre().equalsIgnoreCase(nombre.trim())) {
    			return moneda;
    		}
    	}
    	return null;
    }
    
    public static Cuenta cuentaPorDni(String dni) {
        for (int i = 0; i < listaCuentas.size(); i++) {
        	Cuenta c = listaCuentas.get(i);
        	if (c.getUsuario().getDNI().equals(dni)) {
                return c;
            }
        }
        return null;
    }
    

}