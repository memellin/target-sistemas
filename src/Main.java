import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 2o Exercício
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um numero: ");
        int num = sc.nextInt();
        boolean fibonacci = Fibonacci(num);

        if (!fibonacci) {
            System.out.println("O Número "+ num + " não está na sequência de fibonnaci");
        } else {
            System.out.println("O Número " + num + " pertence a sequência de fibonacci");
        }


        ArrayList<Double> vetor = new ArrayList<>();

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

}