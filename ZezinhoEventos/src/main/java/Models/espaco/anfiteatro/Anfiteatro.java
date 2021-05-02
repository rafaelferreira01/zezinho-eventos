/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.espaco.anfiteatro;

import Models.espaco.anfiteatro.assento.Cabine;
import Models.espaco.anfiteatro.assento.Cadeira;
import Models.espaco.anfiteatro.assento.VagaEspecial;
import java.util.ArrayList;
import java.util.List;
import models.espaco.Espaco;

/**
 *
 * @author Leonardo
 */
public class Anfiteatro extends Espaco{

    private ArrayList<Cadeira> cadeiraList;
    private ArrayList<Cabine> cabineList;
    private ArrayList<VagaEspecial> vagaEspecialList;
    

    public Anfiteatro() {
        this.cadeiraList = new ArrayList<>();
        this.cabineList = new ArrayList<>();
        this.vagaEspecialList = new ArrayList<>();
        this.capacidadeTotal = capacidadeTotalSoma();
        this.tipoEspaco = "Anfiteatro";
    }

    public Anfiteatro(ArrayList<Cadeira> cadeiraList, ArrayList<Cabine> cabineList, ArrayList<VagaEspecial> vagaEspecialList, int idEspaco, int capacidadeTotal, double custoExtra, String tipoEspaco) {
        super(idEspaco, capacidadeTotal, custoExtra, "Anfiteatro");
        this.cadeiraList = new ArrayList<>();
        this.cabineList = new ArrayList<>();
        this.vagaEspecialList = new ArrayList<>();
        this.capacidadeTotal = capacidadeTotalSoma();
    }
    
    public int capacidadeTotalSoma(){
        int totalVagas = 0;
        for (Cadeira cadeira : cadeiraList) {
            totalVagas++;
        }
        for (Cabine cabine : cabineList) {
            totalVagas++;
        }
        for (VagaEspecial vagaEspecial : vagaEspecialList) {
            totalVagas++;
        }
        return totalVagas;
        
    }
    

    
}
