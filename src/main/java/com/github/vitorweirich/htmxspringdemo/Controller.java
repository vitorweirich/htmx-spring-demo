package com.github.vitorweirich.htmxspringdemo;

import java.time.Instant;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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
	public String filtros(@RequestParam Map<String, String> filters, @RequestHeader(value = "HX-Partial-Request", required = false) String htmxHeader, Model model) {
	    List<Object> skus = Collections.emptyList();  // Inicialmente, sem SKUs filtradas
	    
	    model.addAttribute("pagination", Map.of("totalPages", 12));

	    if ("true".equals(htmxHeader)) {
	    	List<Object> filteredSkus = List.of(Map.of("productId", 123, "skuId", 456, "sellerId", "CSB", "status", "PENDING"));
	    	model.addAttribute("skus", filteredSkus);  // Preenche os filtros
            return "filtros :: skuCards";
        }
	    
	    model.addAttribute("skus", skus);  // Passa as SKUs para a página
	    model.addAttribute("filters", filters);  // Preenche os filtros
	    this.addCommonAttrs(model);
	    return "filtros";  // Retorna a página completa
	}

	
	private void addCommonAttrs(Model model) {
		model.addAttribute("time", Instant.now());
	}
}
