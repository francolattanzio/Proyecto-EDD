/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author user
 */

public class GrafoMatriz{
    private int numVerts;
    static int MaxVerts = 100; 
    Vertice [] verts;
    private int [][] matAd;
    
    public GrafoMatriz(){
        this(MaxVerts);
    }
    public GrafoMatriz(int mx){
        matAd = new int [mx][mx];
        verts = new Vertice[mx];
        for (int i = 0; i < mx; i++)
            for (int j = 0; i < mx; i++)
                matAd[i][j] = 0;
        numVerts = 0;
    }
    public void nuevoVertice (String nom){
        boolean esta = numVertice(nom) >= 0;
        if (!esta){
            Vertice v = new Vertice(nom); 
            v.asigVert(numVerts);
            verts[numVerts++] = v;
        }
    }

    int numVertice(String vs){
        Vertice v = new Vertice(vs);
        boolean encontrado = false;
        int i = 0;
        for (; (i < numVerts) && !encontrado;){
            encontrado = verts[i].equals(v);
            if (!encontrado) i++ ; 
        }
        return (i < numVerts) ? i : -1 ;
    }
    
    public void nuevoArco(String a, String b)throws Exception{
        int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");
        matAd[va][vb] = 1;
    }
        
    public boolean adyacente(String a, String b)throws Exception{
        int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");
        return matAd[va][vb] == 1;
    }

    
}
