package conjuntos;

public class Node {
    //Declaración de atributos
    protected int element;
    protected Node link; //Nodo
    
    //Constructor
    public Node (int element){
        this.element = element;
        link = null;
    }
    
    //Métodos
     
    //Retorna el elemento
    public int getElement(){
       return element; 
    }
    
    //Asigna un valor al elemento
    public void setElement(int element){
        this.element = element;
    }
    
    //Retorna la liga
    public Node getLink(){
       return link; 
    }
    
    //Asigna un valor a la liga
    public void setLink(Node link){
        this.link = link;
    }
}
