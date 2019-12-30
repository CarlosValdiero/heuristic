/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristica;
   
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class No {
    private No pai;
    private ArrayList<Coordenada> vizinhos;
    private Coordenada coordenada;
    private int g;
    private int h;
    private int f;
    private int tipo;
    private boolean fechado;
    

    public No(int tipo) {
        this.tipo = tipo;
        fechado=false;
        vizinhos=new ArrayList<>();
    }

    public boolean isFechado() {
        return fechado;
    }

    public void setFechado(boolean fechado) {
        this.fechado = fechado;
    }
    
    
    
    public void addVizinho(Coordenada vizinho){
        vizinhos.add(vizinho);
    }
    
    public ArrayList<Coordenada> vizinhos(){
        return vizinhos;
    }
            
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public void setH(Coordenada chegada) {
        int x = chegada.getX()-coordenada.getX();
        int y = chegada.getY()-coordenada.getY();
        if(x<0) x*=-1;
        if(y<0) y*=-1;
        this.h = (y+x)*10;
    }
    


    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        setG(pai.getG()+calculaG(pai));
        this.pai = pai;
    }
    
    public ArrayList<Coordenada> retornaCaminho(ArrayList<Coordenada> c){
        c.add(coordenada);
        System.out.println(tipo);
        if(pai==null)
            return c;
        else
            return pai.retornaCaminho(c);
    }

    public int getG() {
        return g;
    }

    public int getF() {
        return pai.getG()+calculaG()+h;
    }
    
    public int getF(No pai) {
        if(this.pai==null){
            this.pai=pai;
            this.setG(pai.getG()+calculaG(pai));
            f=pai.getG()+calculaG()+h;
        }else{
            if(pai.getG()+calculaG(pai)+h<f){
                this.pai=pai;
                this.setG(pai.getG()+(tipo+1)*10);
                f=pai.getG()+calculaG()+h;
            }
        }
        
        return f;
    }

    public void setG(int g) {
        this.g = g;
    }
    
    private int calculaG(No pai){
        if(pai.getCoordenada().getX()==coordenada.getX()||pai.getCoordenada().getY()==coordenada.getY()) 
            return (tipo+1)*10;
        else 
            return (tipo+1)*14;
    }
    private int calculaG(){
        if(pai.getCoordenada().getX()==coordenada.getX()||pai.getCoordenada().getY()==coordenada.getY())
            return (tipo+1)*10;
        else 
            return (tipo+1)*14;
    }
    
    
}
