package br.com.casadocodigo.loja.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.Relatorio;

@Controller
@RequestMapping("/relatorio-produtos")
public class RelatorioProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Relatorio relatorioProdutos(@RequestParam(value="data", required=false) String data) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		try {
			List<Produto> produtos;
			if(data != null) {
				calendar.setTime(sdf.parse(data));
				produtos = produtoDAO.listarPorData(calendar);
			} else {
				produtos = produtoDAO.listar();
			}
			Relatorio relatorio = new Relatorio();
			relatorio.setProdutos(produtos);
			relatorio.setQuantidade(produtos.size());
			relatorio.setDataGeracao(Calendar.getInstance());
			return relatorio;
		} catch (ParseException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
