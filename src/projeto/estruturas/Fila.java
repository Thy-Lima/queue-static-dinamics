package projeto.estruturas;

import projeto.interfaces.FilaTAD;

/**
 * @param<T>
 * @author guinh
 */
public class Fila<T> implements FilaTAD<T> {
    private T[] elementos;
    private int tamanhoAtual;
    
    public Fila(int cap){
        this.elementos = (T[]) new Object[cap];
        this.tamanhoAtual = 0;
    }
    
    public Fila(){
        this.elementos = (T[]) new Object[10];
        this.tamanhoAtual = 0;
    }

    @Override
    public int tamanho() {
        return this.tamanhoAtual;
    }

    @Override
    public boolean estaVazia() {
        return this.tamanho() == 0;
    }

    @Override
    public boolean estaCheia() {
        return this.tamanho() == this.elementos.length;
    }

    @Override
    public boolean enfileirar(T item) {
        if(this.estruturaNula() || this.itemNulo(item) || this.estaCheia()){
            return false;
        }
        
        this.elementos[this.tamanho()] = item;
        this.tamanhoAtual++;
        return true;
    }

    @Override
    public boolean remover() {
        if(this.estruturaNula() || this.estaVazia()){
            return false;
        }
        
        for(int i=0; i<this.tamanho()-1; i++){
            this.elementos[i] = this.elementos[i+1];
        }
        this.elementos[this.tamanho()-1] = null;
        this.tamanhoAtual--;
        return true;
    }

    @Override
    public boolean buscar(T item) {
        if(this.estruturaNula() || this.estaVazia() || this.itemNulo(item)){
            return false;
        }
        
        for(int i=0; i<this.tamanho(); i++){
            if(this.elementos[i].equals(item)){
                return true;
            }
        }
    
        return false;
    }

    @Override
    public int indice(T item) {
        if(this.estruturaNula() || this.estaVazia() || this.itemNulo(item)){
            return -1;
        }
        
        for(int i=0; i<this.tamanho(); i++){
            if(this.elementos[i].equals(item)){
                return i;
            }
        }
        
        return -1;
    }

    @Override
    public String exibir(int indice) {
        if(this.estruturaNula()|| this.indiceInvalido(indice)){
            return "";
        }
        
        StringBuilder conteudo = new StringBuilder();
        conteudo.append("[").append(this.elementos[indice].toString()).append("]");
        
        return conteudo.toString();
    }

    @Override
    public String exibir() {
        if(this.estruturaNula()){
            return "";
        }
        
        StringBuilder conteudo = new StringBuilder();
        conteudo.append("[");
        
        for(int i=0; i<this.tamanho()-1; i++){
            conteudo.append(this.elementos[i].toString());
            conteudo.append(",");
        }
        
        if(this.tamanho()>0){
            conteudo.append(this.elementos[this.tamanho()-1].toString());
        }
        
        conteudo.append("]");
        
        return conteudo.toString();
    }

    @Override
    public boolean limpar() {
        if(this.estruturaNula() || this.estaVazia()){
            return false;
        }
        
        while(this.remover());
        return true;
    }
    
    private boolean estruturaNula(){
        if(this.elementos == null){
            return true;
        }
        
        return false;
    }
    
    private boolean indiceInvalido(int indice){
        if(indice < 0 || indice > this.tamanho()){
            return true;
        }
        
        return false;
    }
    
    private boolean itemNulo(T item){
        boolean retorno = true;
        
        if(item != null){
            retorno = false;
        }
        
        return retorno;
    }
}
