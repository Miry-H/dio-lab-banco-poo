
public abstract class Conta implements IConta {
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println(cliente.getNome() + ": Saque de R$" + valor + " realizado. Saldo atual: R$" + saldo);
        } else {
            System.out.println(cliente.getNome() + ": Saldo insuficiente para realizar o saque de R$" + valor);
        }
    }

	@Override
	public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println(cliente.getNome() + ": Depósito de R$" + valor + " realizado. Saldo atual: R$" + saldo);
        } else {
            System.out.println(cliente.getNome() + ": O valor de depósito deve ser positivo.");
        }
    }

	public void transferir(double valor, Conta contaDestino) {
		if (valor > 0 && saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println(cliente.getNome() + ": Transferência de R$" + valor + " realizada com sucesso");
        } else {
            System.out.println(cliente.getNome() + ": Saldo insuficiente para realizar a transferência de R$" + valor);
        }
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s (CPF: %s)", this.cliente.getNome(), this.cliente.getCfp()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
