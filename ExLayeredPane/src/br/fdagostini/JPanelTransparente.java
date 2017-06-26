package br.fdagostini;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

public class JPanelTransparente extends JPanel {

	private static final long serialVersionUID = 6524425099336615402L;

	public JPanelTransparente() {
		super.setOpaque(false);
		super.setBackground(Color.BLUE);
		
		// componente transparente deixa os cliques passarem por ele 
		// também. isso é bloqueado adicionando um listener vazio.
		super.addMouseListener(new MouseAdapter() {
		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setColor(this.getBackground());
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.05f));
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2.dispose();
		super.paintComponent(g);
	}

}
