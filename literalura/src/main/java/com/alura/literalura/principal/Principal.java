package com.alura.literalura.principal;

import com.alura.literalura.model.ApiResponse;
import com.alura.literalura.model.Libro;
import com.alura.literalura.repository.LibroRepository;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvierteDatos;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<Libro> libros;
    private LibroRepository repositorio;
    private ApiResponse apiResponse;

    public Principal(LibroRepository repository) {
        this.repositorio = repository;
    }

    public void muestraElMenu() {
        var opcion = -1;

        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado anio
                    5 - Listar libros por idioma
                                                      
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibrosPorToitulo();
                    break;
                case 2:
                    //buscarEpisodioPorSerie();
                    break;
                case 3:
                    //mostrarSeriesBuscadas();
                    break;
                case 4:
                    //buscarSeriesPorTitulo();
                    break;
                case 5:
                    //buscarTop5Series();
                    break;

                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }


    }

    private void mostrarSeriesBuscadas() {
        libros = repositorio.findAll();

        libros.stream()
                .sorted(Comparator.comparing(Libro::getId))
                .forEach(System.out::println);
    }

    private void buscarLibrosPorToitulo() {
        System.out.println("Escribe el nombre del libro del cual quieres buscar");
        var titulo = teclado.nextLine();

        if (apiResponse == null) {
            var json = consumoApi.obtenerDatos(URL_BASE);
            apiResponse = conversor.obtenerDatos(json, ApiResponse.class);
        }
        System.out.println(apiResponse);
        Libro libroEncontrado = obtenerLibroPorNombre(titulo);
        if (libroEncontrado != null) {
            repositorio.save(libroEncontrado);
            System.out.println(libroEncontrado);
        }

    }

    public Libro obtenerLibroPorNombre(String nombre) {
        if (apiResponse.getResults() != null && !apiResponse.getResults().isEmpty()) {
            Optional<Libro> libroOpt = apiResponse.getResults().stream()
                    .filter(libro -> libro.getTitle().equalsIgnoreCase(nombre))
                    .findFirst();

            return libroOpt.get();
        }

        return null;

    }

}


