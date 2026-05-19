package es.ies.puerto.services;
import java.util.List;
import es.ies.puerto.modelos.Reservas;
import es.ies.puerto.repositories.interfaces.IReservaRepository;
import es.ies.puerto.services.interfaces.IReservaService;
import es.ies.puerto.utils.Validaciones;
/**
 * @author AlejandroDonGar y JavierReyPer
 * @version 1.0.0
 * 
 * Clase ReservaService donde implementamos los metodos de IReservaService
 */
public class ReservaService implements IReservaService{

    IReservaRepository reservaRepository;

    @Override
    public List<Reservas> findAll() {
        return reservaRepository.findAll();
    }
    @Override
    public Reservas findByID(Integer id) {
        Reservas reserva = new Reservas(id);
        if(!reservaRepository.findAll().contains(reserva)) {
            return null;
        }
        if(!Validaciones.esIntegerValido(id)) {
            return null;
        }
        return reservaRepository.findByID(id);
    }
    @Override
    public boolean save(Reservas reserva) {
        if(!Validaciones.esReservaValida(reserva)) {
            return false;
        }
        return reservaRepository.save(reserva);
    }
    @Override
    public boolean update(Reservas reserva) {
        if(!Validaciones.esReservaValida(reserva)) {
            return false;
        }
        return reservaRepository.update(reserva);
    }
    @Override
    public boolean delete(Integer id) {
        Reservas reserva = new Reservas(id);
        if(!reservaRepository.findAll().contains(reserva)) {
            return false;
        }
        if(!Validaciones.esIntegerValido(id)) {
            return false;
        }
        return reservaRepository.delete(id);
    }
    @Override
    public Integer numeroDePlazasDisponibles(Integer idActividad) {
        if(!Validaciones.esIntegerValido(idActividad)) {
            return -1;
        }
        return reservaRepository.numeroDePlazasDisponibles(idActividad);
    }   
}
