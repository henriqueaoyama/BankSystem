import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Nome completo: ");
        String nome = leitura.nextLine();
        System.out.println("CPF: ");
        String cpf = leitura.nextLine();
        System.out.println("Saldo: ");
        double saldo = leitura.nextDouble();

        System.out.println("Bem vindo " + nome);

        int numero;
        do {
            //Exibir o menu
            String mensagem = String.format("""
                ********************************
                Seus dados:
                
                Nome:       %s
                CPF:        %s
                Saldo:      R$%.2f
                ********************************
                
                Operações 
                
                1- Consultar Saldo
                2- Receber Valor
                3- Transferir valor
                4- Sair
                
                Digite a opção desejada:
                
                """, nome, cpf, saldo);
        System.out.println(mensagem);

        numero = leitura.nextInt();

        switch (numero) {
            case 1:
                System.out.println("Seu saldo atual é: R$" + saldo);
                break;

            case 2:
                System.out.println("Digite o valor a receber: R$");
                double valorReceber = leitura.nextDouble();
                saldo += valorReceber;
                System.out.println("Valor recebido com sucesso");
                break;

            case 3:
                System.out.println("Digite o valor que deseja transferir: R$");
                double valorTransferir = leitura.nextDouble();
                if (valorTransferir <= saldo) {
                    saldo -= valorTransferir;
                    System.out.println("Transferencia realizada com sucesso");
                } else {
                    System.out.println("Saldo insuficiente");
                }
                break;

            case 4:
                System.out.println("Saindo... Obrigado por usar o nosso sistema!");
                break;

            default:
                System.out.println("Opção inválida. Tente Novamente.");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    } while (numero != 4); // Sai do loop quando digitar 4

    leitura.close();
    }
}