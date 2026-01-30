import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		// Libreria --- es un conjunto de clases desarrollados por alguien mas para que
				// nuestras aplicaciones funcionen correctamente
				Scanner lectura = null;

				
				
				int numEmp, menuPri, subMenu, indice;
				String nombre, departamento;
				float sueldo;

				Empleados empleado;

				List<Empleados> lista = new ArrayList<Empleados>();

				do {
					System.out.println("Bienvenido al catalogo de empleados");
					System.out.println("1---Alta");
					System.out.println("2--Mostrar");
					System.out.println("3--Buscar");
					System.out.println("4---Editar");
					System.out.println("5---Eliminar");
					System.out.println("6---Buscar por nombre");
					System.out.println("7---Buscar por departamento");
					System.out.println("8---Calcular el total de dinero a pagar");
					System.out.println("9---Eliminar buscando por número empleado");
					System.out.println("10---Salir");

					lectura = new Scanner(System.in);
					menuPri = lectura.nextInt();

					switch (menuPri) {
					case 1:
						try {
							System.out.println("Ingrese el num empleado");
							lectura = new Scanner(System.in);
							numEmp = lectura.nextInt();

							System.out.println("Ingrese el nombre");
							lectura = new Scanner(System.in);
							nombre = lectura.nextLine();

							System.out.println("Ingrese el departamento");
							lectura = new Scanner(System.in);
							departamento = lectura.nextLine();

							System.out.println("Ingrese el sueldo");
							lectura = new Scanner(System.in);
							sueldo = lectura.nextFloat();

							// Crear el objeto
							empleado = new Empleados(numEmp, nombre, departamento, sueldo);

							// Agregar a la lista
							lista.add(empleado);
							System.out.println("Se agrego el registro");

						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error al guardar");
						}
						break;
					case 2:
						if (lista.size() > 0)
							System.out.println(lista);
						else
							System.out.println("No hay registros en la lista");
						break;
					case 3:
						try {
							if (lista.size() > 0) {
								System.out.println("Ingrese el indice del registro a buscar");
								lectura = new Scanner(System.in);
								indice = lectura.nextInt();

								// Buscar
								empleado = lista.get(indice);
								System.out.println("Se encontro el registro " + empleado);

							} else
								System.out.println("No hay registros para buscar");

						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("No existe ese registro");
						}
						break;
					case 4:
						try {
							// Para editar primero hay que buscar
							System.out.println("Ingrese el indice del registro para editar");
							lectura = new Scanner(System.in);
							indice = lectura.nextInt();

							// Buscar
							empleado = lista.get(indice);
							System.out.println("Se encontro el empleado para editar " + empleado.getNombre());

							// Actualizacion --- nombre y sueldo
							do {
								System.out.println("SubMenu para editar");
								System.out.println("1---Nombre");
								System.out.println("2---Sueldo");
								System.out.println("3---Regresar");

								lectura = new Scanner(System.in);
								subMenu = lectura.nextInt();

								switch (subMenu) {
								case 1:
									System.out.println("Ingrese el nuevo nombre");
									lectura = new Scanner(System.in);
									nombre = lectura.nextLine();

									// Actualizar
									empleado.setNombre(nombre);
									System.out.println("Se edito");
									break;
								case 2:
									System.out.println("Ingrese el sueldo");
									lectura = new Scanner(System.in);
									sueldo = lectura.nextFloat();

									// Actualizar
									empleado.setSueldo(sueldo);
									System.out.println("Se edito");
									break;
								case 3:
									break;
								}

							} while (subMenu < 3);

						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("No se puedo editar");
						}
						break;
					case 5:
						try {
							System.out.println("Ingrese el indice del registro a eliminar");
							lectura = new Scanner(System.in);
							indice = lectura.nextInt();

							// Eliminar
							lista.remove(indice);
							System.out.println("Se elimino");

						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("No se elimino");
						}
						break;
					case 6:
						//Algoritmo
						//1-- Pedir el nombre del empleado
						//2--- Recorrer los registros de la lista
						//3---Comparacion
						
						boolean bandera = false;
						//Sintais---- Programacion
						System.out.println("Ingrese el nombre del empleado a buscar");
						lectura = new Scanner(System.in);
						nombre = lectura.nextLine();
						
						//foreach ---ciclo mejorado
						for (Empleados e : lista) {
							if (e.getNombre().equals(nombre));{
								System.out.println(e);
								bandera = true;
								break; //Para detener el ciclo
							}
						}
						
						if (bandera == false)
							System.out.println("No existe ese empleado");
						break;
					case 7:
						System.out.println("Ingrese el departamento a buscar");
						lectura = new Scanner(System.in);
						departamento = lectura.nextLine();
						
						boolean bandera2 = false;
						
						for (int i = 0; i <lista.size(); i++) {
							
							Empleados e = lista.get(i);
							if (e.getDepartamento().equals(departamento)) {
								bandera2 = true;
								System.out.println(e);
							}
						}
						
					
					if (bandera2)
						System.out.println("No hay empleado en ese departamento");
					break;
					
					case 8:
						try {
							if (lista.size() > 0) {
								float total = 0;

								for (Empleados e : lista) {
									total += e.getSueldo();
								}

								System.out.println("El total de dinero a pagar es: $" + total);
							} else {
								System.out.println("No hay empleados registrados");
							}
						} catch (Exception e) {
							System.out.println("Error al calcular el total");
						}
						break;
					case 9:
						try {
							System.out.println("Ingrese el número de empleado a eliminar");
							lectura = new Scanner(System.in);
							numEmp = lectura.nextInt();

							boolean eliminado = false;

							for (int i = 0; i < lista.size(); i++) {
								if (lista.get(i).getNumEmpleado() == numEmp) {
									lista.remove(i);
									eliminado = true;
									System.out.println("Empleado eliminado correctamente");
									break;
								}
							}

							if (eliminado == false)
								System.out.println("No existe ese empleado");

						} catch (Exception e) {
							System.out.println("Error al eliminar");
						}
						break;
					case 10:
						break;
					}
						
				} while (menuPri < 10);

				}
				

	

}
