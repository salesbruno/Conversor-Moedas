
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ObterCambio {

    public double pegacambio(String de, String para) {
        try {
            // URL da API ExchangeRate-API com sua chave pessoal e moeda base
            String endereco = "https://v6.exchangerate-api.com/v6/92024a9bcc3f27264f6e7241/latest/" + de;

            // Cria o cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Cria a requisição HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            // Envia a requisição e pega a resposta como String
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Analisa o JSON
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            // Retorna a taxa de conversão para a moeda desejada
            return json.getAsJsonObject("conversion_rates").get(para).getAsDouble();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return -1;
        }
    }
}
