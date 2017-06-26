package br.fdagostini;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Painel com várias camadas, usado para simular abertura de diálogos, sem usar
 * frames ou jdialogs.
 * 
 * @author fernando
 *
 */
public class ConjuntoCamadas extends JLayeredPane {

	private static final long serialVersionUID = 6867159621359774700L;
	private int contador = 1;

	public ConjuntoCamadas() {
		adicionaCamadaPrincipal();
	}

	private void adicionaCamadaPrincipal() {
		JPanel camadaBase = new JPanel();
		camadaBase.setLayout(new BorderLayout());
		camadaBase.setBackground(Color.YELLOW);

		JButton btnOpen = new JButton("Clique para exibir diálogo");
		btnOpen.addActionListener(e -> {
			System.out.println("Clicou no botão da camada principal.");
			adicionarCamadaSecundaria(() -> System.out.println("Fechou camada"));
		});
		
		camadaBase.add(BorderLayout.NORTH, btnOpen);
		
		
		super.add(camadaBase, JLayeredPane.DEFAULT_LAYER);
	}

	protected void adicionarCamadaSecundaria(final Runnable executeOnClose) {

		JPanel camadaDialogo = new JPanelTransparente();
		camadaDialogo.setLayout(new BorderLayout());
		
		
		JButton btnOpen = new JButton(contador + " - Clique para adicionar mais um diálogo");
		btnOpen.addActionListener(e -> {
			System.out.println("Clicou no botão do diálogo.");
			adicionarCamadaSecundaria(() -> System.out.println("Fechou camada"));
		});
		
		camadaDialogo.add(BorderLayout.NORTH, btnOpen);
		
		
		
		JButton btnClose = new JButton("Botão do diálogo");
		
		btnClose.addActionListener(e -> {
			
			System.out.println("Clicou no botão do diálogo.");
			
			ConjuntoCamadas.super.remove(camadaDialogo);
			contador--;
			
			super.revalidate();
			super.repaint();
			
			executeOnClose.run();
		});
		camadaDialogo.add(BorderLayout.SOUTH, btnClose);
		
		super.add(camadaDialogo, new Integer(JLayeredPane.MODAL_LAYER + contador++));
		super.revalidate();
		super.repaint();
	}

	/**
	 * Para deixar todas as camadas do mesmo tamanho desse componente.
	 */
	@Override
	public void doLayout() {
		synchronized (getTreeLock()) {
			int w = getWidth();
			int h = getHeight();
			for (Component c : getComponents()) {
				c.setSize(w, h);
			}
		}
	}

}
