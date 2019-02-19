/*
 * package com.example.AES.controllers;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.CommandLineRunner; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.example.AES.Deportista; import
 * com.example.AES.repositories.DeportistaRepository;
 * 
 * @Controller public class pruebaBBDD implements CommandLineRunner {
 * 
 * @Autowired private DeportistaRepository rep;
 * 
 * @PostMapping("/saveuser") public String guardardep(Model model, @RequestParam
 * String Nombre, @RequestParam String Apellido,
 * 
 * @RequestParam String Password) {
 * 
 * System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAA"); rep.save(new
 * Deportista(Nombre, Apellido, Password)); List<Deportista> pacos =
 * rep.findByNombre("Rubensito"); for(Deportista paco : pacos) {
 * System.out.println(paco); } return "index";
 * 
 * }
 * 
 * @Override public void run(String... args) throws Exception{
 * 
 * rep.save(new Deportista("Paco", "Palotes", "password"));
 * 
 * List<Deportista> pacos = rep.findByNombre("Paco"); for(Deportista paco :
 * pacos) { System.out.println(paco); }
 * 
 * Deportista deppp = new Deportista();
 * deppp.setNombre(rep.getByNombre("paco"));
 * 
 * //rep.delete(pacos.get(0)); }
 * 
 * }
 */