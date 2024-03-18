import java.util.Scanner;

public class InverterNumero {
    public static void main(String[] args) {
        // Criando um objeto Scanner para ler o número do usuário
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar ao usuário que insira um número de três algarismos
        System.out.print("Digite um número com três algarismos: ");
        int numero = scanner.nextInt();
        
        // Extrair cada dígito do número original
        int digito1 = numero / 100; // Obtém o primeiro dígito
        int digito2 = (numero / 10) % 10; // Obtém o segundo dígito
        int digito3 = numero % 10; // Obtém o terceiro dígito
        
        // Calcular o número invertido combinando os dígitos extraídos na ordem inversa
        int numeroInvertido = (digito3 * 100) + (digito2 * 10) + digito1;
        
        // Imprimir o número invertido
        System.out.println("O número invertido é: " + numeroInvertido);
        
        // Fechar o Scanner para evitar vazamentos de recursos
        scanner.close();
    }
}
