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
public class Coordenada {
    private int x;
    private int y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

        private int custoCaminho(Coordenada chegada){
        int cx = chegada.getX()-x;
        int cy = chegada.getY()-y;
        if(cx<0) cx*=-1;
        if(cy<0) cy*=-1;
        return (cy+cx)*10;
    }
    
    public ArrayList<Coordenada> caminhoGuloso(ArrayList<Coordenada> caminho,Coordenada chegada,No[][] matriz,int count){
    count--;
    if(count<2)return null;
    caminho.add(this);
    
    if(chegada.getX()==x&&chegada.getY()==y)return caminho;
    ArrayList<Coordenada> coord= matriz[x][y].vizinhos();
    int custo=coord.get(0).custoCaminho(chegada);
    Coordenada escolhido=coord.get(0);
    
    for(Coordenada c: coord){
        if(c.custoCaminho(chegada)<custo){
            custo=c.custoCaminho(chegada);
            escolhido=c;
        }
    }
    return escolhido.caminhoGuloso(caminho, chegada, matriz,count);
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setCoord(int x,int y){
        this.x=x;
        this.y=y;
    }
}
