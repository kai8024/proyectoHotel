package ucentral.edu.co.apphotel.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ucentral.edu.co.apphotel.dto.PagoDto;
import ucentral.edu.co.apphotel.dto.ReservaDto;
import ucentral.edu.co.apphotel.servicios.ServicioPagos;
import ucentral.edu.co.apphotel.servicios.ServicioReservas;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ControladorPago {

    private final ServicioReservas servicioReservas;
    private final ServicioPagos servicioPagos;

    public ControladorPago(ServicioReservas servicioReservas, ServicioPagos servicioPagos) {
        this.servicioReservas = servicioReservas;
        this.servicioPagos = servicioPagos;
    }

    @GetMapping("/pago")
    public String pagoModal(Model model){
        List<ReservaDto> listaReservas = servicioReservas.consultarT();
        List<String> nombres = listaReservas.stream()
                .map(ReservaDto::getNombre)
                .distinct()
                .collect(Collectors.toList());
        model.addAttribute("nombres", nombres);
        return "pago";
    }

    @GetMapping("/pago/reservas")
    public String pagoReservasModal(Model model){
        return "pagoReservas";
    }

    @GetMapping(value = "/pagar")
    public String pagar(@RequestParam Long id,Model model) {
        ReservaDto reserva = servicioReservas.findDtoById(id);
        long dias = reserva.calcularDiasEstadia();
        reserva.setDias(dias);
        long monto = dias*reserva.getAdultos() * reserva.getHabitacion();
        reserva.setMonto(monto);
        PagoDto pagoLlenar = new PagoDto();
        model.addAttribute("pagoLlenar", pagoLlenar);
        model.addAttribute("reserva", reserva);
        List<PagoDto> listaPagos = servicioPagos.consultarP();
        model.addAttribute("listaPagos", listaPagos);
        return "pagar";
    }

    @GetMapping("/pago/confirmado")
    public String pagarReservaModal(Model model){
        return "reservaConfirmada";
    }

    @PostMapping("/buscar/pago")
    public String buscarPago(@RequestParam  String nombre, org.springframework.ui.Model model) {
        List<ReservaDto> listaReservas = servicioReservas.consultarT();

        List<ReservaDto> reservasFiltradas = listaReservas.stream()
                .filter(reserva -> reserva.getNombre().equals(nombre))
                .collect(Collectors.toList());

        reservasFiltradas.forEach(reserva -> {
            long dias = reserva.calcularDiasEstadia();
            reserva.setDias(dias);
            long monto = dias * reserva.getAdultos() * reserva.getHabitacion();
            reserva.setMonto(monto);
        });

        // Verificar si hay resultados
        if (reservasFiltradas.isEmpty()) {
            model.addAttribute("mensaje", "No se encontraron reservas para el nombre: " + nombre);
            return "pago"; // Página que muestra el mensaje de no resultados
        }

        // Agregar las reservas filtradas al modelo
        model.addAttribute("listaReservas", reservasFiltradas);
        return "pagoReservas"; // Página para mostrar las reservas filtradas
    }
    @PostMapping("/pagar/reserva")
    public String reservaPagada(@RequestParam("nombre") String nombre,
                               @RequestParam("numeroTarjeta") String numeroTarjeta,
                               @RequestParam("fechaVencimiento") String fechaVencimiento,
                               @RequestParam("cvv") String cvv,
                               @RequestParam("metodoPago") String metodoPago,
                               Model model) {
        //List<PagoDto> listapagos = servicioReservas.consultarT();
       // model.addAttribute("mensajeExito", "Pago realizado con éxito!");
        return "reservaConfirmada";  // Redirige a una página de confirmación
    }
    @PostMapping("/pago/reserva")
    public String pagoReserva(@ModelAttribute("pagoLlenar") PagoDto pago){
        servicioPagos.crear(pago);
        return "redirect:/pagando/reserva";
    }

    @GetMapping("/pagando/reserva")
    public String cargarPagosModal(Model model){
        PagoDto pagoLlenar = new PagoDto();
        model.addAttribute("pagoLlenar", pagoLlenar);
        List<PagoDto> listaPagos = servicioPagos.consultarP();
        model.addAttribute("listaPagos", listaPagos);
        return "reservaConfirmada";
    }
}
