package mx.com.sintelti.capacitacion.hibernate;

import mx.com.sintelti.capacitacion.hibernate.entity.EmpleadoEntity;
import mx.com.sintelti.capacitacion.hibernate.service.EmpleadoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: Benek
 * Date: 05/10/13
 * Time: 12:25
 * www.javamexico.org
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpleadoService empleadoService = context.getBean("empleadoService", EmpleadoService.class);
        EmpleadoEntity empleado = context.getBean("empleadoEntity", EmpleadoEntity.class);

        //buscarEmpleadoPorNombre(empleadoService);
        agregarEmpleado(empleadoService, empleado);
    }

    public static void buscarEmpleadoPorNombre(EmpleadoService empleadoService){
        EmpleadoEntity empleado = empleadoService.buscarEmpleadoPorNombre("Linus");
        System.out.println("Encontrado empleado: " + empleado.getApellidoPaterno());
    }

    public static void buscarEmpleadoPorId(EmpleadoService empleadoService){
        EmpleadoEntity empleado = empleadoService.buscarEmpleadoPorId(1);
        System.out.println("Encontrado empleado: " + empleado.getNombre());
    }


    public static void agregarEmpleado(EmpleadoService empleadoService, EmpleadoEntity empleado){
        empleado.setId(3L);
        empleado.setNombre("Bill");
        empleado.setApellidoPaterno("Gates");
        empleado.setApellidoMaterno("Ramirez");
        empleado.setEdad(45);
        empleado.setCorreo("bill@microsoft.com");
        empleado.setPuesto("CEO Microsoft");

        empleadoService.agregarEmpleado(empleado);
    }

}
