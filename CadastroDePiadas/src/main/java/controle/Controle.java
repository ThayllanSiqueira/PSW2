/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.Piada;
import entidade.PiadaDAO;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.http.RequestEntity.method;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author RA21551794
 */
@RestController //Define Spring na classe, com as definições de URL
public class Controle {
   
   @CrossOrigin(origins = "http://editor.swagger.io")
   @RequestMapping(method = RequestMethod.POST, value = "/piada") 
   public Piada salvarPiada(@RequestBody Piada p){
       PiadaDAO dao = new PiadaDAO();
       Piada piadaSalva = dao.salvar(p);
               
        return piadaSalva;
   }
   
   @CrossOrigin(origins = "http://editor.swagger.io")
   @RequestMapping("/piada")
   public List<Piada> consultarPiada(){
       List resultado = new ArrayList<>();
        
        PiadaDAO dao = new PiadaDAO();
         resultado.add(dao.consultar("", true)) ;
         
        return resultado;
   }
   
   @CrossOrigin(origins = "http://editor.swagger.io")
    @RequestMapping("/piada/{id}")
    public Piada buscarPiada(@PathVariable("id") int id){
        
        PiadaDAO dao = new PiadaDAO();
        
       Piada p = dao.buscar(id);
        
        return p;
    }
   
}
