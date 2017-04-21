/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.Pincel;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.server.PathParam;
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
@RestController
public class Controle {
    
    @CrossOrigin(origins = "http://editor.swagger.io")
    @RequestMapping(method = RequestMethod.PUT, value = "/pincel/{id}")
    public Pincel atualizarPincel(@RequestBody Pincel p, @PathVariable("id") int id){
        //jogar p no BD e receher do BD o id
        //preencher o id de p
        p.setNum_serie(9876);
        return p;
    }
    
    @CrossOrigin(origins = "http://editor.swagger.io")
    @RequestMapping(method = RequestMethod.POST, value = "/pincel")
    public Pincel criarPincel(@RequestBody Pincel p){
        //jogar p no BD e receher do BD o id
        //preencher o id de p
        p.setNum_serie(9876);
        return p;
    }
    
    @CrossOrigin(origins = "http://editor.swagger.io")
    @RequestMapping("/pincel/{id}")
    public Pincel buscarPincel(@PathVariable("id") int id){
        
        Pincel p = new Pincel();
        p.setCor("Vermelho");
        p.setIdentificador(99);
        p.setNum_serie(id);
        
        return p;
    }
    
    //GET Pincel
    @CrossOrigin(origins = "http://editor.swagger.io")
    @RequestMapping("/pincel")
    public List<Pincel> buscarPincel(){
        List resultado = new ArrayList<>();
        
        Pincel p1 = new Pincel();
        p1.setCor("Azul");
        p1.setIdentificador(1);
        p1.setNum_serie(999);
        
        resultado.add(p1);
        
        Pincel p2 = new Pincel();
        p1.setCor("Verde");
        p1.setIdentificador(2);
        p1.setNum_serie(777);
        
        resultado.add(p2);
        
        return resultado;
                
    }
}
