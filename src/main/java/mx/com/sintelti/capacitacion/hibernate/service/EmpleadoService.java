package mx.com.sintelti.capacitacion.hibernate.service;

import mx.com.sintelti.capacitacion.hibernate.dao.EmpleadoDAO;
import mx.com.sintelti.capacitacion.hibernate.entity.EmpleadoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Author: Benek
 * Date: 05/10/13
 * Time: 12:31
 * www.javamexico.org
 */
@Component
public class EmpleadoService {

    EmpleadoDAO empleadoDAO;

    public String agregarEmpleado(EmpleadoEntity empleado) {
        return empleadoDAO.agregarEmpleado(empleado);
    }

    public EmpleadoEntity buscarEmpleadoPorId(int id) {
        return empleadoDAO.buscarEmpleadoPorId(id);
    }

    public EmpleadoEntity buscarEmpleadoPorNombre(String nombre) {
        return empleadoDAO.buscarEmpleadoPorNombre(nombre);
    }

    public String actualizarEmpleado(EmpleadoEntity empleado) {
        return empleadoDAO.actualizarEmpleado(empleado);
    }

    public String eliminarEmpleado(int id) {
        return empleadoDAO.eliminarEmpleado(id);
    }

    @Autowired
    @Qualifier("empleadoDAO")
    public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }
}
