package conjuntos;

import static conjuntos.Conjuntos.isNumeric;

public class SetList {
    //Declaración de atributos
    private Node head;
    
    //Constructor
    public SetList (){
        head = null;
    }
    
    //Métodos
    //Obtener cabeza de lista
    public Node getHead(){
        return head;
    }
    
    public void setHead(Node newNode) {
        this.head = newNode;
    }
    
//+ ConjuntoEnLista ( )
//++++++++++ Nodo getCab( )
//+ mostrar()
//+ entero cantidaddeelementos( )
//+ booleano pertenece(tipodato elemento)
//+ booleano subconjunto(ConjuntoEnLista B)
//+ booleano esvacio( )
//+ ConjuntoEnLista unión(ConjuntoEnLista B)
//+ ConjuntoEnLista intersección(ConjuntoEnLista B)
//+ booleano igualdad(ConjuntoEnLista B)
//+ ConjuntoEnLista complemento()
//+ void agregar(tipodato elemento)
//+ void borrar(tipodato elemento)
//+ entero posición(tipodato elemento)
//+ ConjuntoEnLista diferencia(ConjuntoEnLista B)
//+ ConjuntoEnLista diferenciaSimetrica(ConjuntoEnLista B)
//+ void vaciar( )

    public void defineU(String setString) {
        this.empty();
        String[] split = setString.split(",");
        for (int i = 0; i < split.length; i++){
            if (isNumeric(split[i])){
                int value = Integer.parseInt(split[i]);
                if (!this.exist(value)) {
                    this.insert(value);
                }
            }
        }
    }
    
    public void define(SetList universal, String setString) {
        this.empty();
        String[] split = setString.split(",");
        for (int i = 0; i < split.length; i++){
            if (isNumeric(split[i])){
                int value = Integer.parseInt(split[i]);
                if (!this.exist(value) && universal.exist(value)) {
                    this.insert(value);
                }
            }
        }
    }
    
    public boolean exist(int value) {
        boolean answer = false;
        if(this.getHead() != null){
            Node q = this.getHead();
            while (q != null) {
                if (q.getElement() == value)
                    answer = true;
                q = q.getLink();
            }
        }
        return answer;
    }

    public String show() {
        String answer = "{";
        if (this.getHead() != null){
            Node q = this.getHead();
            answer = answer + q.getElement();
            while (q.getLink() != null) {
                answer = answer + ", " + q.getLink().getElement();
                q = q.getLink();
            }
        }
        answer = answer + "}";
        return answer;
    }

    private void empty() {
        head = null;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (this.getHead() == null){
            this.setHead(newNode);
        }else{
            Node q = this.getHead();
            while (q.getLink() != null) {
                q = q.getLink();
            }
            q.setLink(newNode);
        }
    }

    public boolean equal(SetList BList) {
        boolean answer = true;
        if(!this.included(BList)){
            answer = false;
        }
        if(!BList.included(this)){
            answer = false;
        }
        return answer;
    }

    public boolean included(SetList BList) {
        boolean answer = true;
        Node q = this.getHead();
        while (q != null){
            if(!BList.exist(q.getElement())){
                answer = false;
            }
            q = q.getLink();
        }
        return answer;
    }

    public SetList union(SetList BList) {
        SetList result = new SetList();        
        Node q = this.getHead();
        while (q != null){
            result.insert(q.getElement());
            q = q.getLink();
        }
        q = BList.getHead();
        while (q != null){
            if(!this.exist(q.getElement())){
                result.insert(q.getElement());
            }
            q = q.getLink();
        }
        return result;
    }

    public SetList intersection(SetList BList) {
        SetList result = new SetList();
        
        Node q = this.getHead();
        while (q != null){
            if(BList.exist(q.getElement())){
                result.insert(q.getElement());
            }
            q = q.getLink();
        }
        return result;
    }

    public SetList minus(SetList BList) {
        SetList result = new SetList();
        
        Node q = this.getHead();
        while (q != null){
            if(!BList.exist(q.getElement())){
                result.insert(q.getElement());
            }
            q = q.getLink();
        }
        return result;
    }

    public SetList symmetricDiff(SetList BList) {
        SetList result = this.minus(BList).union(BList.minus(this));
        //result = this.minus(BList).union(BList.minus(this));
        return result;
    }

    public SetList complement(SetList UniversalList) {
        SetList result = UniversalList.minus(this);
        //result = UniversalList.minus(this);
        return result;
    }

    public String CartesianProduct(SetList BList) {
        String answer = "{";
        if (this.getHead() != null){
            Node q = this.getHead();
            while (q != null) {
                if (BList.getHead() != null){
                    Node r = BList.getHead();
                    while (r != null) {
                        answer = answer + "(" + q.getElement() + "," + r.getElement() + ")";
                        if(r.getLink() != null){
                            answer = answer + ",";
                        }
                        r = r.getLink();
                    }
                }
                if(q.getLink() != null){
                            answer = answer + ",";
                        }
                q = q.getLink();                
            }
        }
        answer = answer + "}";
        return answer;
    }
    
    

    
    
}
