import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        Gson gson = new GsonBuilder().create();

        System.out.println("*******************************************");
        System.out.println("Bem vindo à aplicação de consultas de CEPs");
        System.out.println("*******************************************");
        System.out.println("Digite o CEP desejado (somente números): ");

        String cepDesejado = leitura.nextLine();

        System.out.println("CEP desejado: " + cepDesejado);

        String requisicao = "https://viacep.com.br/ws/" + cepDesejado + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requisicao))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        String json = response.body();

        if(response.statusCode() == 400) {
            System.out.println("*******************************************");
            System.out.println("CEP não encontrado. Execute o aplicativo novamente.");
            System.out.println("*******************************************");

        } else {



        }

    }
}
