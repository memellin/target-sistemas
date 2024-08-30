import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Timer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 2o Exercício
        System.out.println("Segundo exercício, SEQUÊNCIA DE FIBONACCI");
        Thread.sleep(1000);
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um numero: ");
        int num = sc.nextInt();
        sc.nextLine();
        boolean fibonacci = Fibonacci(num);

        if (!fibonacci) {
            System.out.println("O Número "+ num + " não está na sequência de fibonnaci");
        } else {
            System.out.println("O Número " + num + " pertence a sequência de fibonacci");
        }
        Thread.sleep(2200);
        System.out.println("\n");
        // 4o Exercício
        System.out.println("Quarto exercício, PERCENTUAL FATURAMENTO");
        Thread.sleep(1100);
        faturamentoPercentual();
        Thread.sleep(2200);
        // 5o exercício
        System.out.println("Quinto exercício, INVERTENDO STRING");
        Thread.sleep(1100);
        System.out.print("Digite uma string para inverter: ");
        String palavra = sc.nextLine();
        String stringReversa = stringReversa(palavra);
        System.out.println("String invertida com sucesso! -> " + stringReversa);
        sc.close();

    }
    public static boolean Fibonacci(int num) {
        int n1 = 0, n2 = 1;
        if (num == 1 || num == 0) {
            return true;
        } else{
            for (int i = 0; i <= num; i++) {
                int aux = n2;
                n2 = n2 + n1;
                n1 = aux;
                if (n2 == num){
                    return true;
                }

            }
        }
        return false;
    }

    // 4o exercício
    public static void faturamentoPercentual() {
        // Definindo os valores de faturamento para cada estado
        System.out.println("Faturamento percentual por estado da empresa: ");
        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;
        double faturamentoTotal = sp + rj + mg + es + outros;

        // Calculando o percentual de cada estado
        double percentualSP = (sp / faturamentoTotal) * 100;
        double percentualRJ = (rj / faturamentoTotal) * 100;
        double percentualMG = (mg / faturamentoTotal) * 100;
        double percentualES = (es / faturamentoTotal) * 100;
        double percentualOutros = (outros / faturamentoTotal) * 100;

        System.out.printf("Percentual de SP: %.2f%%\n", percentualSP);
        System.out.printf("Percentual de RJ: %.2f%%\n", percentualRJ);
        System.out.printf("Percentual de MG: %.2f%%\n", percentualMG);
        System.out.printf("Percentual de ES: %.2f%%\n", percentualES);
        System.out.printf("Percentual de Outros: %.2f%%\n", percentualOutros);
    }

    // 5o exercício
    public static String stringReversa(String palavra) {
        char[] inverted = new char[palavra.length()];

        for (int i = 0; i < palavra.length(); i++) {
            // Atribuir o caractere na posição correta do array invertido
            inverted[i] = palavra.charAt(palavra.length() - 1 - i);
        }
        // Converter o array de caracteres invertidos de volta para uma string
        return new String(inverted);
    }
}