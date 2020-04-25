package projeto.interfaces;

/**
 * @param<T>
 * @author guinh
 */
public interface FilaTAD<T> {
    public int tamanho();
    public boolean estaVazia();
    public boolean estaCheia();
    public boolean enfileirar(T item);
    public boolean remover();
    public boolean buscar(T item);
    public int indice(T item);
    public String exibir(int indice);
    public String exibir();
    public boolean limpar();
}
