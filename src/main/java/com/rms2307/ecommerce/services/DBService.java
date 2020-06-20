package com.rms2307.ecommerce.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms2307.ecommerce.domain.Categoria;
import com.rms2307.ecommerce.domain.Cidade;
import com.rms2307.ecommerce.domain.Cliente;
import com.rms2307.ecommerce.domain.Endereco;
import com.rms2307.ecommerce.domain.Estado;
import com.rms2307.ecommerce.domain.ItemPedido;
import com.rms2307.ecommerce.domain.Pagamento;
import com.rms2307.ecommerce.domain.PagamentoComBoleto;
import com.rms2307.ecommerce.domain.PagamentoComCartao;
import com.rms2307.ecommerce.domain.Pedido;
import com.rms2307.ecommerce.domain.Produto;
import com.rms2307.ecommerce.domain.enums.EstadoPagamento;
import com.rms2307.ecommerce.domain.enums.TipoCliente;
import com.rms2307.ecommerce.repositories.CategoriaRepository;
import com.rms2307.ecommerce.repositories.CidadeRepository;
import com.rms2307.ecommerce.repositories.ClienteRepository;
import com.rms2307.ecommerce.repositories.EnderecoRepository;
import com.rms2307.ecommerce.repositories.EstadoRepository;
import com.rms2307.ecommerce.repositories.ItemPedidoRepository;
import com.rms2307.ecommerce.repositories.PagamentoRepository;
import com.rms2307.ecommerce.repositories.PedidoRepository;
import com.rms2307.ecommerce.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public void instantiateTestDatabase() throws ParseException {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Cama Mesa e Banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Perfumaria");
		Categoria cat6 = new Categoria(null, "Jardim");
		Categoria cat7 = new Categoria(null, "Decoração");
		Categoria cat8 = new Categoria(null, "Teste");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de Escritório", 2000.00);
		Produto p5 = new Produto(null, "Toalha", 800.00);
		Produto p6 = new Produto(null, "Colcha", 80.00);
		Produto p7 = new Produto(null, "Tv", 2000.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajur", 80.00);
		Produto p10 = new Produto(null, "Pendente", 2000.00);
		Produto p11 = new Produto(null, "Shampoo", 800.00);
		Produto p12 = new Produto(null, "Cadeira", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4, p12));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		Cidade c4 = new Cidade(null, "Monte Verde", est1);

		est1.getCidades().addAll(Arrays.asList(c1, c4));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@email.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("12341234", "4567845678"));
		Cliente cli2 = new Cliente(null, "Jose Silva", "jose@email.com", "19078912459", TipoCliente.PESSOAFISICA);
		cli2.getTelefones().addAll(Arrays.asList("45991100", "954338797"));

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "09234904", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Mattos", "105", "Sala 800", "Centro", "12334904", cli1, c2);
		Endereco e3 = new Endereco(null, "Avenida Barros", "1009", "Casa 01", "Jardim Ana", "09440392", cli2, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));

		clienteRepository.saveAll(Arrays.asList(cli1, cli2));

		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p2, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p3, 100.00, 1, 2000.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}