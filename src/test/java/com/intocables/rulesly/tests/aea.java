package com.intocables.rulesly.tests;

import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.LinkedList;
import java.util.List;
//import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


//import com.intocables.rulesly.dto.QuantityxAddedDto;
import com.intocables.rulesly.repository.IUserPunishRepository;


@SpringBootTest
class aea {
	@Autowired
	IUserPunishRepository erPunhisRepository;
	
	/*@Test
	public void arrays() throws Exception{
		List<?> ga = erPunhisRepository.findSQLByQuantityAndAddeds();
	
		List<QuantityxAddedDto> _QuantityxAddedDtos = new ArrayList<QuantityxAddedDto>();
		for(Object obj : ga) {
		
			_QuantityxAddedDtos.add(new QuantityxAddedDto(obj));
			
		}	
		for(QuantityxAddedDto obj : _QuantityxAddedDtos) {
			
		
			
		}	
		System.out.print(_QuantityxAddedDtos);
	}*/
	@Test
	void arrayss() {
		/*List<Object> ga = erPunhisRepository.findSQLByQuantityAndAddeds();
		List<Object> lsts = new ArrayList<Object>();
		for(Object ls: ga) {
			lsts.add(ls);
		}
		String[] arrs = lsts.toArray(new String[] {});
		System.out.println(Arrays.deepToString(arrs));
		*/
	

 
      // System.out.println(hash_Set);
		// Definir un HashMap
		int i1, i2 = 90;
		BigInteger ga = erPunhisRepository.findSQLByQuantity();
		
System.out.println("myInteger es de tipo " +  ((Object)ga).getClass().getSimpleName());
i1 = ga.intValue();
System.out.println(i1/i2);
	
List<Object[]> gas = (List<Object[]>) erPunhisRepository.findSQLByQuantityAndAddeds();
System.out.println(gas);
for(Object[] tupla:gas){
	int aw =((BigInteger) tupla[0]).intValue();
	System.out.println(aw);
	System.out.println("myInteger es de tipo " +  ((Object)tupla[1]).getClass().getSimpleName());
    System.out.println("NOMBRE PROYECTO : " + tupla[0]);
    System.out.println("CODPRO : " + tupla[1].toString());
}
			/*	HashMap<Long, String> global = new HashMap<Long, String>();
		 
				// Insertar valores "key"-"value" al HashMap
				global.put(new Long(667895789),"Laura");
				global.put(new Long(645895756),"Pepe");
				global.put(new Long(55895711),"Abelardo");
				global.put(new Long(667111788),"Daniel");
				global.put(new Long(667598623),"Arturo");
		 
				// Definir Iterator para extraer o imprimir valores 
				for( Iterator it = global.keySet().iterator(); it.hasNext();) { 
					Long s = (Long)it.next();
					String s1 = (String)global.get(s);
					System.out.println("Alumno: "+s + " - " + "Telefono: "+s1);
					System.out.println(it);
				}
		
		// LinkedList
		List lista1 = new LinkedList();
 
		// Añadimos nodos y creamos un Iterator
		lista1.add("Madrid");
		lista1.add("Sevilla");
		lista1.add("Valencia");
		Iterator iterador = lista1.iterator();
 
		// Recorremos y mostramos la lista
		while (iterador.hasNext()) {
			String elemento = (String) iterador.next();
			System.out.print(elemento + " ");
		}
		System.out.println("--LinkedList--");
		
		List<Object> lst = new ArrayList<Object>();
		lst.add("sample");
		lst.add("simple");
		String[] arr = lst.toArray(new String[] {});
		System.out.println(Arrays.deepToString(arr));
	
		String sCadena = "Hola Mundo";
		String sSubCadena = sCadena.substring(5,10);
		System.out.println(sSubCadena);*/
	}
}
