package br.fdagostini;

import java.math.BigDecimal;

public class Programa {
	
	public static void main(String[] args) {
		
        Conta contaRoot = new Conta();

        for (String[] par : Dados.CONTAS) {
        
        	int id = Integer.valueOf(par[0]);
            String codigo = par[1];

            Conta conta = new Conta();
            conta.setId(id);
            conta.setCodigo(codigo);

            contaRoot.add(conta);
        }

        System.out.println(contaRoot.toString());

        System.out.println("\n\n*********************************************************\n\n");

        // Atribui valor para algumas contas.
        for (String par : Dados.CONTAS_COM_VALOR) {
            contaRoot.setValor(par, new BigDecimal(10));
        }

        // Zera todos os nulos.
        contaRoot.zeraNulos();

        // Calcula valores dos totalizadores.
        contaRoot.updateTotalizadores();

        System.out.println(contaRoot.toString());
	}

}
