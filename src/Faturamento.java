import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

// 3o exercício, Irei utilizar a biblioteca jackson para tratar o arquivo json
public class Faturamento {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Leia o JSON do arquivo
            JsonNode rootNode = mapper.readTree(new File("src/faturamento.json"));
            processarFaturamento(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processarFaturamento(JsonNode rootNode) {
        // lógica para calcular os valores desejados
        double menorValor = Double.MAX_VALUE;
        double maiorValor = Double.MIN_VALUE;
        double soma = 0;
        int diasComFaturamento = 0;

        Iterator<JsonNode> elements = rootNode.elements();

        while (elements.hasNext()) {
            JsonNode dia = elements.next();
            double valor = dia.get("valor").asDouble();

            // Ignorando os dias sem faturamento (valor 0 de faturamento)
            if (valor > 0) {
                if (valor < menorValor) {
                    menorValor = valor;
                }
                if (valor > maiorValor) {
                    maiorValor = valor;
                }
                soma += valor;
                diasComFaturamento++;
            }
        }

        double media = soma / diasComFaturamento;

        System.out.println("Menor valor de faturamento: " + menorValor);
        System.out.println("Maior valor de faturamento: " + maiorValor);
        System.out.println("Média de faturamento: " + media);

        // Conta os dias acima da média
        int diasAcimaDaMedia = 0;
        elements = rootNode.elements();
        while (elements.hasNext()) {
            JsonNode dia = elements.next();
            double valor = dia.get("valor").asDouble();
            if (valor > media) {
                diasAcimaDaMedia++;
            }
        }

        System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
    }
}