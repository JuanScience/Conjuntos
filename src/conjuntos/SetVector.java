package conjuntos;

import static conjuntos.Conjuntos.isNumeric;

public class SetVector {

    //Declaración de atributos
    protected int size; //Número de elementos
    protected int[] vec; //Vector
    
    //Constructor
    public SetVector (int n){
        this.size = n;
        this.vec = new int[size];
    }
    
    //Métodos
    public int getDato (int pos){
        return vec[pos];
    }
    
    public void setDato (int dato, int pos){
        vec[pos] = dato;
    }
    
    public int getSize(){
        return size;
    }
    
    public void setSize(int a){
        size = a;
    }
    
    public int[] getVec(){
        return vec;
    }
    
    public void setVec (int[] newVec){
        vec = newVec;
    }
    
//+ ConjuntoVector(entero n)
//+ entero getN( )
//+ mostrar()
//+ tipodato getDato(entero pos)
//+ void setDato(tipodato dato)
//+ entero cantidaddeelementos( )
//+ booleano pertenece(tipodato elemento)
//+ booleano subconjunto(ConjuntoEnVector B)
//+ booleano esvacio( )
//+ ConjuntoVector unión(ConjuntoVector B)
//+ ConjuntoVector intersección(ConjuntoVector B)
//+ booleano igualdad(ConjuntoVector B)
//+ ConjuntoVector complemento()
//+ void agregar(tipodato elemento)
//+ void borrar(tipodato elemento)
//+ entero posición(tipodato elemento)
//+ ConjuntoVector diferencia(ConjuntoVector B)
//+ ConjuntoVector diferenciaSimetrica(ConjuntoVector B)
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
    
    public void define(SetVector universal, String setString) {
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
        for (int i = 0; i < this.getSize() ; i++) {
            if (this.getDato(i) == value)
                answer = true;
        }
        return answer;
    }

    public String show() {
        String answer = "{";
        for (int i = 0; i < this.getSize() ; i++) {
            answer = answer + this.getDato(i);
            if (i + 1 != this.getSize())
                answer = answer + ", ";
        }
        answer = answer + "}";
        return answer;
    }

    public void empty() {
        size = 0;
        vec = new int[0];
    }

    public void insert(int value) {
        int[] newVector = new int[this.size + 1];
        for (int i = 0; i < this.getSize(); i++) {
            newVector[i] = this.getDato(i);            
        }
        newVector[this.getSize()] = value;
        this.setVec(newVector); 
        this.setSize(this.getSize() + 1);
    }
    
    public boolean equal(SetVector BVector) {
        boolean answer = true;
        if (!this.included(BVector)){
            answer = false;
        }
        if (!BVector.included(this)){
            answer = false;
        }
        return answer;
    }

    public boolean included(SetVector BVector) {
        boolean answer = true;
        for (int i = 0; i < this.getSize(); i++) {
            if (!BVector.exist(this.getDato(i)))
                answer = false;
        }
        return answer;
    }

    public SetVector union(SetVector BVector) {
        SetVector answer = new SetVector(0);
        answer.setVec(this.vec);
        answer.setSize(this.getSize());
        for (int i = 0; i < BVector.getSize(); i++){
            if (!answer.exist(BVector.getDato(i))){
                answer.insert(BVector.getDato(i));
            }
        }
        return answer;
    }

    public SetVector intersection(SetVector BVector) {
        SetVector answer = new SetVector(0);

        for (int i = 0; i < this.getSize(); i++){
            if (BVector.exist(this.getDato(i))){
                answer.insert(this.getDato(i));
            }
        }
        return answer;
    }

    public SetVector minus(SetVector BVector) {
        SetVector answer = new SetVector(0);

        for (int i = 0; i < this.getSize(); i++){
            if (!BVector.exist(this.getDato(i))){
                answer.insert(this.getDato(i));
            }
        }
        return answer;
    }

    public SetVector symmetricDiff(SetVector BVector) {
        SetVector answer = new SetVector(0);
        answer = this.minus(BVector).union(BVector.minus(this));
        return answer;
    }

    public SetVector complement(SetVector UniversalVector) {
        SetVector answer = new SetVector(0);
        answer = UniversalVector.minus(this);
        return answer;
    }

    public String CartesianProduct(SetVector BVector) {
        String answer = "{";
        for (int i = 0; i < this.getSize() ; i++) {
            for (int j = 0; j < BVector.getSize(); j++) {
                answer = answer + "(" + this.getDato(i) + "," + BVector.getDato(j) + ")";
                if (j + 1 != BVector.getSize())
                    answer = answer + ",";
            }
            if (i + 1 != this.getSize())
                    answer = answer + ",";
        }
        answer = answer + "}";
        return answer;
    }
    
    

    
}
