import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainBooks {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o titulo do livro para busca:");
        var tituloLivro = leitura.next();
        String apiKey = "AIzaSyASVK6BhChMu9pLdK8ZYNaKKosbWWI3_eU";
        String endereco = "https://www.googleapis.com/books/v1/volumes?q=" + tituloLivro + "&key=" + apiKey;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> resposta = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(resposta.body());
    }
}
