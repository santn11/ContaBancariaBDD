package stepDefinitions;
import java.nio.channels.AcceptPendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*Classe para simulações de operações bancárias*/

public class Banco {
	private float saldo;
	private String tipo;

	/*Método Given (Um cliente especial com saldo atual de -{int} reais)*/
	@Given("Um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		saldo = int1;
		tipo = "Especial";
	}

	/*Método When (For solicitado um saque no valor de {int} reais)*/
	@When("For solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(int arg1){
		System.out.println("Saldo: " + saldo);
		System.out.println("Saque: " + arg1);
		if (tipo.equals("Especial")) {
			saldo -= arg1;
		}
	}

	/*Método Then (Deve efetuar o saque e atualizar o saldo da conta para -{int} reais)*/
	@Then("Deve efetuar o saque e atualizar o saldo da conta para -{int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(int arg1)
	throws Throwable {
		if (saldo == arg1) {
			System.out.println("Saldo realizado com sucesso!");
			System.out.println("Saldo atual: " + saldo);
		}
	}

	@Then("Check more outcomes")
	public void check_more_outcomes() throws Throwable {

	}

	/*Método Given (Um cliente comum com saldo atual de -{int} reais)*/
	@Given("Um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer int1) {
		saldo = int1;
		tipo = "Comum";
	}

	/*Método When (For solicitado um saque no valor de {int} reais)*/
	@When("Solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer int1) {
		System.out.println("Saldo: " + saldo);
		System.out.println("Saque: " + int1);
	}

	/*Método Then (Não deve efetuar o saque e deve retornar a mensagem de saldo insuficiente)*/
	@Then("Nao deve efetuar o saque e deve retornar a mensagem de saldo insuficiente")
	public void nao_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_de_saldo_insuficiente() {
		System.out.println("Saldo insuficiente!");
	}

}
