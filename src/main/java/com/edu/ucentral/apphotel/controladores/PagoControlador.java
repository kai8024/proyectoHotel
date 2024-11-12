package com.edu.ucentral.apphotel.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pago")
public class PagoControlador {

    @GetMapping("/lista")
    public String listarPagos(Model model) {
        // Lógica para obtener la lista de pagos
        return "pago/lista"; // Ruta de la plantilla para mostrar pagos
    }
}
