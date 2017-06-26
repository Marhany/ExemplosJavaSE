package br.fdagostini;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	private static final long serialVersionUID = -1791405664767768154L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JButton btnNorth = new JButton("Norte");
		btnNorth.addActionListener(e -> System.out.println("Clique no Norte"));
		contentPane.add(btnNorth, BorderLayout.NORTH);

		JButton btnWest = new JButton("Oeste");
		btnWest.addActionListener(e -> System.out.println("Clique no Oeste"));
		contentPane.add(btnWest, BorderLayout.WEST);

		JButton btnSouth = new JButton("Sul");
		btnSouth.addActionListener(e -> System.out.println("Clique no Sul"));
		contentPane.add(btnSouth, BorderLayout.SOUTH);

		JButton btnEast = new JButton("Leste");
		btnEast.addActionListener(e -> System.out.println("Clique no Leste"));
		contentPane.add(btnEast, BorderLayout.EAST);

		add(BorderLayout.CENTER, new ConjuntoCamadas());

	}
}
