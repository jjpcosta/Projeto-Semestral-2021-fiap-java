package br.com.jjpcosta.projetosemestral;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		JFrame janela = new JFrame("projetosemestral - rm:83992");
		
		JTabbedPane tabs = new JTabbedPane();
		JPanel cadastro = new JPanel();
		cadastro.setLayout(new BorderLayout());
		
		JPanel imagem = new JPanel();
		ImageIcon img = new ImageIcon(new ImageIcon("src/resources/matrix.JPG").getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT));
		JLabel campoImagem = new JLabel(img);
		imagem.add(campoImagem);
		cadastro.add(imagem,BorderLayout.WEST);
		
		JPanel camposPrincipais = new JPanel();
		camposPrincipais.setLayout(new GridLayout(6,1));
		
		camposPrincipais.add(new JLabel("Titulo"));
		JTextField campoTitulo = new JTextField();
		camposPrincipais.add(campoTitulo);
		
		camposPrincipais.add(new JLabel("Sinopse"));
		JTextField campoSinopse = new JTextField();
		camposPrincipais.add(campoSinopse);
		
		camposPrincipais.add(new JLabel("Genero"));
		JComboBox<String> campoGenero = new JComboBox<>();
		Arrays.asList("Ação","Drama","Comédia","Ficção cientifica","Terror").stream().forEach(genero -> {
			campoGenero.addItem(genero);
		});
		
		camposPrincipais.add(campoGenero);
		
		
		cadastro.add(camposPrincipais,BorderLayout.CENTER);
		
		JPanel selecionaveis = new JPanel();
		selecionaveis.setLayout(new GridLayout(7,1));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		selecionaveis.add(new JLabel("Onde Assistir"));
		JRadioButton netflix = new JRadioButton("Netflix");
		netflix.setActionCommand("Netflix");
		buttonGroup.add(netflix);
		selecionaveis.add(netflix);
		
		JRadioButton primeVideo = new JRadioButton("Prime Video");
		primeVideo.setActionCommand("Prime Video");
		buttonGroup.add(primeVideo);
		selecionaveis.add(primeVideo);
		
		JRadioButton pirateBay = new JRadioButton("Pirate Bay");
		pirateBay.setActionCommand("Pirate Bay");
		buttonGroup.add(pirateBay);
		selecionaveis.add(pirateBay);
		
		JCheckBox assistido = new JCheckBox("Assistido");
		selecionaveis.add(assistido);
		
		selecionaveis.add(new JLabel("Avaliação"));
		StarRater estrela = new StarRater(5);
		selecionaveis.add(estrela);
		
		cadastro.add(selecionaveis,BorderLayout.EAST);
		
		
		
		JPanel botoes = new JPanel();
	
		JButton salvar = new JButton("Salvar");
		salvar.addActionListener(clicou -> {
			Filme matrix = new Filme();
			matrix.setAssistido(assistido.isSelected());
			matrix.setAssistir(buttonGroup.getSelection().getActionCommand());
			matrix.setAvaliacao(estrela.getSelection());
			matrix.setGenero(campoGenero.getSelectedItem().toString());
			matrix.setSinopse(campoSinopse.getText());
			matrix.setTitulo(campoTitulo.getText());
			System.out.println(matrix);
		});
		
		botoes.add(salvar);
	
		JButton cancelar = new JButton("Cancelar");
		botoes.add(cancelar);
		
		cadastro.add(botoes,BorderLayout.SOUTH);
		
		tabs.add("Cadastro", cadastro);
		
		JPanel listaTabela = new JPanel();
		tabs.add("Lista", listaTabela);
		
		janela.add(tabs);
		
		
		
		janela.setSize(450,400);
		janela.setResizable(false);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
