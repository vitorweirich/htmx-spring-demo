package com.github.vitorweirich.htmxspringdemo;

import java.time.Instant;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping
	public String home(Model model) {
		Map<String, Object> skus = new LinkedHashMap<>();
        skus.put("labels", List.of("Com Erro", "Com Sucesso", "Incompletas"));
        skus.put("data", List.of(2138, 2138, 2138));
        skus.put("colors", List.of("#FF6384", "#4CAF50", "#FFC107"));

        model.addAttribute("chartData", skus);
        
        this.addCommonAttrs(model);
		
		return "index";
	}
	
	@GetMapping("/filtros")
    public String filtros(@RequestParam Map<String, String> filters, Model model) {
        List<Object> filteredSkus = Collections.emptyList();

        // Passa os filtros para preencher os campos e as SKUs filtradas para exibir
        model.addAttribute("filters", filters);  // Para poder preencher os campos de filtro
        model.addAttribute("skus", filteredSkus);  // Passa as SKUs filtradas para a página
        
        this.addCommonAttrs(model);

        return "filtros";  // Nome da página HTML que será renderizada
    }
	
	@PostMapping("/filtros")
    public String filtrosWithFilters(@RequestParam Map<String, String> filters, Model model) {
        List<Object> filteredSkus = List.of(Map.of("productId", 123, "skuId" , 456, "sellerId", "CSB", "status", "PENDING"));
        
        System.out.println();
        System.out.println(filters);
        System.out.println();

        // Passa os filtros para preencher os campos e as SKUs filtradas para exibir
        model.addAttribute("filters", filters);  // Para poder preencher os campos de filtro
        model.addAttribute("skus", filteredSkus);  // Passa as SKUs filtradas para a página
        
        this.addCommonAttrs(model);

        return "filtros";  // Nome da página HTML que será renderizada
    }
	
	private void addCommonAttrs(Model model) {
		model.addAttribute("time", Instant.now());
	}
}
