package com.rms2307.ecommerce.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.rms2307.ecommerce.domain.enums.Perfil;
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
	BCryptPasswordEncoder pe;

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

		Categoria cat1 = new Categoria(null, "Categoria 01");
		Categoria cat2 = new Categoria(null, "Categoria 02");
		Categoria cat3 = new Categoria(null, "Categoria 03");
		Categoria cat4 = new Categoria(null, "Categoria 04");
		Categoria cat5 = new Categoria(null, "Categoria 05");
		Categoria cat6 = new Categoria(null, "Categoria 06");
		Categoria cat7 = new Categoria(null, "Categoria 07");
		Categoria cat8 = new Categoria(null, "Categoria 08");

		Produto p1 = new Produto(null, "Produto 01", 20.00);
		Produto p2 = new Produto(null, "Produto 02", 8.00);
		Produto p3 = new Produto(null, "Produto 03", 40.00);
		Produto p4 = new Produto(null, "Produto 04", 2.00);
		Produto p5 = new Produto(null, "Produto 05", 10.00);
		Produto p6 = new Produto(null, "Produto 06", 4.00);
		Produto p7 = new Produto(null, "Produto 07", 2.00);
		Produto p8 = new Produto(null, "Produto 08", 8.00);
		Produto p9 = new Produto(null, "Produto 09", 10.00);
		Produto p10 = new Produto(null, "Produto 10", 2000.00);
		Produto p11 = new Produto(null, "Produto 11", 40.00);
		Produto p12 = new Produto(null, "Produto 12", 10.00);
		Produto p13 = new Produto(null, "Produto 13", 10.00);
		Produto p14 = new Produto(null, "Produto 14", 10.00);
		Produto p15 = new Produto(null, "Produto 15", 10.00);
		Produto p16 = new Produto(null, "Produto 16", 10.00);
		Produto p17 = new Produto(null, "Produto 17", 10.00);
		Produto p18 = new Produto(null, "Produto 18", 10.00);
		Produto p19 = new Produto(null, "Produto 19", 10.00);
		Produto p20 = new Produto(null, "Produto 20", 10.00);
		Produto p21 = new Produto(null, "Produto 21", 10.00);
		Produto p22 = new Produto(null, "Produto 22", 10.00);
		Produto p23 = new Produto(null, "Produto 23", 10.00);
		Produto p24 = new Produto(null, "Produto 24", 10.00);
		Produto p25 = new Produto(null, "Produto 25", 10.00);
		Produto p26 = new Produto(null, "Produto 26", 10.00);
		Produto p27 = new Produto(null, "Produto 27", 10.00);
		Produto p28 = new Produto(null, "Produto 28", 10.00);
		Produto p29 = new Produto(null, "Produto 29", 10.00);
		Produto p30 = new Produto(null, "Produto 30", 10.00);
		Produto p31 = new Produto(null, "Produto 31", 10.00);
		Produto p32 = new Produto(null, "Produto 32", 10.00);
		Produto p33 = new Produto(null, "Produto 33", 10.00);
		Produto p34 = new Produto(null, "Produto 34", 10.00);
		Produto p35 = new Produto(null, "Produto 35", 10.00);
		Produto p36 = new Produto(null, "Produto 36", 10.00);
		Produto p37 = new Produto(null, "Produto 37", 10.00);
		Produto p38 = new Produto(null, "Produto 38", 10.00);
		Produto p39 = new Produto(null, "Produto 39", 10.00);
		Produto p40 = new Produto(null, "Produto 40", 10.00);
		Produto p41 = new Produto(null, "Produto 41", 10.00);
		Produto p42 = new Produto(null, "Produto 42", 10.00);
		Produto p43 = new Produto(null, "Produto 43", 10.00);
		Produto p44 = new Produto(null, "Produto 44", 10.00);
		Produto p45 = new Produto(null, "Produto 45", 10.00);
		Produto p46 = new Produto(null, "Produto 46", 10.00);
		Produto p47 = new Produto(null, "Produto 47", 10.00);
		Produto p48 = new Produto(null, "Produto 48", 10.00);
		Produto p49 = new Produto(null, "Produto 49", 10.00);
		Produto p50 = new Produto(null, "Produto 50", 10.00);

		cat1.getProdutos()
				.addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27,
						p28, p29, p30, p31, p32, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44, p45, p46, p47,
						p48, p49, p50));
		cat2.getProdutos().addAll(Arrays.asList(p31, p32, p34, p35, p36, p37));

		p12.getCategorias().add(cat1);
		p13.getCategorias().add(cat1);
		p14.getCategorias().add(cat1);
		p15.getCategorias().add(cat1);
		p16.getCategorias().add(cat1);
		p17.getCategorias().add(cat1);
		p18.getCategorias().add(cat1);
		p19.getCategorias().add(cat1);
		p20.getCategorias().add(cat1);
		p21.getCategorias().add(cat1);
		p22.getCategorias().add(cat1);
		p23.getCategorias().add(cat1);
		p24.getCategorias().add(cat1);
		p25.getCategorias().add(cat1);
		p26.getCategorias().add(cat1);
		p27.getCategorias().add(cat1);
		p28.getCategorias().add(cat1);
		p29.getCategorias().add(cat1);
		p30.getCategorias().add(cat1);
		p31.getCategorias().add(cat1);
		p32.getCategorias().add(cat1);
		p33.getCategorias().add(cat1);
		p34.getCategorias().add(cat1);
		p35.getCategorias().add(cat1);
		p36.getCategorias().add(cat1);
		p37.getCategorias().add(cat1);
		p38.getCategorias().add(cat1);
		p39.getCategorias().add(cat1);
		p40.getCategorias().add(cat1);
		p41.getCategorias().add(cat1);
		p42.getCategorias().add(cat1);
		p43.getCategorias().add(cat1);
		p44.getCategorias().add(cat1);
		p45.getCategorias().add(cat1);
		p46.getCategorias().add(cat1);
		p47.getCategorias().add(cat1);
		p48.getCategorias().add(cat1);
		p49.getCategorias().add(cat1);
		p50.getCategorias().add(cat1);

		p31.getCategorias().add(cat2);
		p32.getCategorias().add(cat2);
		p33.getCategorias().add(cat2);
		p34.getCategorias().add(cat2);
		p35.getCategorias().add(cat2);
		p36.getCategorias().add(cat2);
		p37.getCategorias().add(cat2);

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
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		produtoRepository.saveAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25,
				p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44, p45, p46, p47,
				p48, p49, p50));

		Estado est1 = new Estado(null, "AC");
		Estado est2 = new Estado(null, "AL");
		Estado est3 = new Estado(null, "AP");
		Estado est4 = new Estado(null, "AM");
		Estado est5 = new Estado(null, "BA");
		Estado est6 = new Estado(null, "CE");
		Estado est7 = new Estado(null, "DF");
		Estado est8 = new Estado(null, "ES");
		Estado est9 = new Estado(null, "GO");
		Estado est10 = new Estado(null, "MA");
		Estado est11 = new Estado(null, "MT");
		Estado est12 = new Estado(null, "MS");
		Estado est13 = new Estado(null, "MG");
		Estado est14 = new Estado(null, "PA");
		Estado est15 = new Estado(null, "PB");
		Estado est16 = new Estado(null, "PR");
		Estado est17 = new Estado(null, "PE");
		Estado est18 = new Estado(null, "PI");
		Estado est19 = new Estado(null, "RJ");
		Estado est20 = new Estado(null, "RN");
		Estado est21 = new Estado(null, "RS");
		Estado est22 = new Estado(null, "RO");
		Estado est23 = new Estado(null, "RR");
		Estado est24 = new Estado(null, "SC");
		Estado est25 = new Estado(null, "SP");
		Estado est26 = new Estado(null, "SE");
		Estado est27 = new Estado(null, "TO");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Santo André", est2);
		Cidade c4 = new Cidade(null, "Monte Verde", est1);
		Cidade c5 = new Cidade(null, "Rio de Janeiro", est3);
		Cidade c6 = new Cidade(null, "Parati", est3);

		est1.getCidades().addAll(Arrays.asList(c1, c4));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		est3.getCidades().addAll(Arrays.asList(c5, c6));

		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));

		Cliente cli1 = new Cliente(null, "Robson de MoraeSIlva", "moraes_rsilv@hotmail.com", "36378912377",
				TipoCliente.PESSOAFISICA, pe.encode("@Feras"), "45118516");

		Cliente cli2 = new Cliente(null, "Admin", "rms.app.teste@gmail.com", "31628382740", TipoCliente.PESSOAFISICA,
				pe.encode("@Feras"), "954889297");
		cli2.addPerfil(Perfil.ADMIN);

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim América", "09330295", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Mattos", "105", "Sala 800", "Centro", "09260050", cli1, c2);
		Endereco e3 = new Endereco(null, "Avenida Barros", "1009", "Casa 01", "Jardim Ana", "04004000", cli2, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));

		clienteRepository.saveAll(Arrays.asList(cli1, cli2));

		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		Pedido ped3 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli2, e3);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pagto2);

		Pagamento pagto3 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped3, 6);
		ped3.setPagamento(pagto3);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		cli2.getPedidos().addAll(Arrays.asList(ped3));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2, pagto3));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p2, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p3, 100.00, 1, 2000.00);
		ItemPedido ip4 = new ItemPedido(ped3, p4, 100.00, 1, 2000.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		ped3.getItens().addAll(Arrays.asList(ip4));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		p4.getItens().addAll(Arrays.asList(ip4));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));
	}
}
