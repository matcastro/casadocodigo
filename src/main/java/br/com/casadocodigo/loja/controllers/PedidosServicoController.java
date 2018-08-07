package br.com.casadocodigo.loja.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.models.Pedido;

@Controller
@RequestMapping("/pedidos")
public class PedidosServicoController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getPedidos() {
		ModelAndView modelAndView = new ModelAndView("pedidos");
		String uri = "https://book-payment.herokuapp.com/orders";
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos = restTemplate.getForObject(uri, List.class);
		modelAndView.addObject("pedidos", pedidos);
		return modelAndView;
	}
}
