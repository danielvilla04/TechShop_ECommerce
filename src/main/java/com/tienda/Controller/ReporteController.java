package com.tienda.Controller;

import com.tienda.service.ReporteService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/principal")
    public String listado(Model model) {
        return "/reportes/principal";
    }
    
    @GetMapping("/usuarios")
    public ResponseEntity<Resource> usuarios(
            @RequestParam String tipo,
            Model model) throws IOException {
        return reporteService.generaReporte("usuarios", null, tipo);
    }
    
    @GetMapping("/productos")
    public ResponseEntity<Resource> productos(
            @RequestParam String tipo,
            Model model) throws IOException {
        return reporteService.generaReporte("productos", null, tipo);
    }
    
    @GetMapping("/facturas")
    public ResponseEntity<Resource> facturas(
            @RequestParam String tipo,
            Model model) throws IOException {
        return reporteService.generaReporte("facturas", null, tipo);
    }

}
