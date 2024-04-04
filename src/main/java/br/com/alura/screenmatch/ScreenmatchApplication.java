package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();
		String coffeeRandom = "https://coffee.alexflipnote.dev/random.json";
		String omdbApi = "https://www.omdbapi.com/?t=gilmore+girls&apikey=d1a028af";

		String jsonCoffeeRandom = consumoApi.obterDados(coffeeRandom);
		System.out.println(jsonCoffeeRandom);

		String jsonOmdbApi = consumoApi.obterDados(omdbApi);
		System.out.println(jsonOmdbApi);

		ConverteDados converteDados = new ConverteDados();
		DadosSerie dadosSerie = converteDados.obterDados(jsonOmdbApi, DadosSerie.class);
		System.out.println(dadosSerie);
	}
}
