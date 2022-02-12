import java.util.Scanner;

public class Verificador {

	public static void main(String[] args) {

		// Variáveis

		// Entrada de dados via teclado
		Scanner sc = new Scanner(System.in);

		// Variavel 'cpf' recebe o documento que será validado
		String cpf;

		// Variáveis v1 a v9 recebem os 9 primeiros dígitos
		String v1, v2, v3, v4, v5, v6, v7, v8, v9, confere = "";

		// Variáveis de n1 a n9 recebem as strings convertidas em int
		int n1, n2, n3, n4, n5, n6, n7, n8, n9, verificador1, verificador2;

		// Entrada de dados via teclado
		System.out.println("---------- Sistema de Verificação de CPF ----------");
		System.out.println("Informe um CPF no formato a seguir: xxx.xxx.xxx.-xx");
		cpf = sc.nextLine();

		// Separação dos digitos e conversão de String para int
		v1 = cpf.substring(0, 1);
		n1 = Integer.parseInt(v1);

		v2 = cpf.substring(1, 2);
		n2 = Integer.parseInt(v2);

		v3 = cpf.substring(2, 3);
		n3 = Integer.parseInt(v3);

		// o intervalo aumenta em 1 para que o '.' seja desconsiderado
		v4 = cpf.substring(4, 5);
		n4 = Integer.parseInt(v4);

		v5 = cpf.substring(5, 6);
		n5 = Integer.parseInt(v5);

		v6 = cpf.substring(6, 7);
		n6 = Integer.parseInt(v6);

		// o intervalo aumenta em 1 para que o '.' seja desconsiderado
		v7 = cpf.substring(8, 9);
		n7 = Integer.parseInt(v7);

		v8 = cpf.substring(9, 10);
		n8 = Integer.parseInt(v8);

		v9 = cpf.substring(10, 11);
		n9 = Integer.parseInt(v9);

		// Estrutura responsavel por validar o cpf

		verificador1 = (n1 * 10 + n2 * 9 + n3 * 8 + n4 * 7 + n5 * 6 + n6 * 5 + n7 * 4 + n8 * 3 + n9 * 2);

		if ((verificador1 % 11) < 2) {

			verificador1 = 0;

		} else {

			verificador1 = 11 - (verificador1 % 11);

		}

		verificador2 = (n1 * 11 + n2 * 10 + n3 * 9 + n4 * 8 + n5 * 7 + n6 * 6 + n7 * 5 + n8 * 4 + n9 * 3
				+ verificador1 * 2);

		if ((verificador2 % 11) < 2) {

			verificador2 = 0;

		} else {

			verificador2 = 11 - (verificador2 % 11);

		}

		// Concatenação e validação do CPF informado
		confere = (v1 + v2 + v3 + "." + v4 + v5 + v6 + "." + v7 + v8 + v9 + "-" + verificador1 + "" + verificador2);

		if (confere.equals(cpf)) {

			System.out.println("O CPF:" + cpf + " é Válido!");
		} else {

			System.out.println("O CPF:" + cpf + " é inválido!");

		}

	}

}
