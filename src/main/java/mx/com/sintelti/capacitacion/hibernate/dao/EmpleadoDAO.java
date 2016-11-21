package mx.com.sintelti.capacitacion.hibernate.dao;

import mx.com.sintelti.capacitacion.hibernate.entity.EmpleadoEntity;
import mx.com.sintelti.capacitacion.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

/**
 * Author: Benek
 * Date: 05/10/13
 * Time: 12:31
 * www.javamexico.org
 */
@Component
public class EmpleadoDAO {
    public String agregarEmpleado(EmpleadoEntity empleado) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(empleado);

        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();

        return "Se agrego un empleado con id: " + empleado.getId();
    }
    public EmpleadoEntity buscarEmpleadoPorId(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        EmpleadoEntity empleado = (EmpleadoEntity) session.get(EmpleadoEntity.class, 1L);
        HibernateUtil.getSessionFactory().close();
        return empleado;
    }
    public EmpleadoEntity buscarEmpleadoPorNombre(String nombre) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EmpleadoEntity.class);
        EmpleadoEntity empleadoEntity = (EmpleadoEntity) criteria.add(Restrictions.eq("nombre", nombre)).uniqueResult();
        //List<EmpleadoEntity> listaEmpleados = criteria.list();
        HibernateUtil.getSessionFactory().close();
        return empleadoEntity;
    }
    public String actualizarEmpleado(EmpleadoEntity empleado) {
        return null; //TODO Implementar metodo
    }
    public String eliminarEmpleado(int id) {
        return null; //TODO Implementar metodo
    }
}
