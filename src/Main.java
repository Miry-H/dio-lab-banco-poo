
public class Main {
	public static void main(String[] args) {
		Cliente mariazinha = new Cliente("99999999999", "Mariazinha");
		Cliente pedrinho = new Cliente("99999999998", "Pedrinho");

		
		Conta correnteMariazinha = new ContaCorrente(mariazinha);
		Conta poupancaPedrinho = new ContaPoupanca(pedrinho);

		correnteMariazinha.depositar(100);
		correnteMariazinha.transferir(100, poupancaPedrinho);
		
		correnteMariazinha.imprimirExtrato();
		poupancaPedrinho.imprimirExtrato();
		
	}

}
