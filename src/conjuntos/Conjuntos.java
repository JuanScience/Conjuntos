/**
 * @authors ormolgud_cardona82182@elpoli.edu.co
 *          juan_salazar82182@elpoli.edu.co 
 */
package conjuntos;

import javax.swing.JOptionPane;

public class Conjuntos {
    private static String setString = "";
    private static SetVector UniversalVector = new SetVector(0);
    private static SetList UniversalList = new SetList();
    private static SetVector AVector = new SetVector(0);
    private static SetList AList = new SetList();
    private static SetVector BVector = new SetVector(0);
    private static SetList BList = new SetList();
    private static SetVector ResultVector = new SetVector(0);
    private static SetList ResultList = new SetList();

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        String menu = "***MENÚ PRINCIPAL CONJUNTOS***"
                + "\n\n1- Trabajar con vectores\n"
                + "2- Trabajar con listas\n"
                + "3- Definir conjunto universal\n"
                + "\n0- Salir\n\n(Ingrese una opción)";
        int option = -1;
        do
        {
            try{
                option = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch(option)
                {
                    case 1: //Vectores
                        optionMenu(option);
                        break;

                    case 2: //Listas
                        optionMenu(option);
                        break;
                        
                    case 3: //Definir Universal
                        setUniversal();
                        break;

                    case 0: System.exit(0);
                        break;
                }
            }catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(null,"Opción no válida!");
            }
        }while(option != 0);       
    }

    private static void optionMenu(int option) {
        if(UniversalVector.size == 0 || UniversalList.getHead() == null){
            JOptionPane.showMessageDialog(null,"El conjunto universal es vacío");
        }else{
            String optionString = "";
            if (option == 1)
                optionString = "VECTORES";
            if (option == 2)
                optionString = "LISTAS";
            String menu = "***MENÚ " + optionString + "***"
                + "\n\n 1- Definir conjunto A\n"
                + " 2- Definir conjunto B\n"
                + " 3- Pertenencia\n"
                + " 4- Igualdad\n"
                + " 5- Inclusión\n"
                + " 6- Unión\n"
                + " 7- Intersección\n"
                + " 8- Diferencia\n"
                + " 9- Diferencia simétrica\n"
                + "10- Complemento\n"
                + "11- Producto cartesiano\n"
                + "12- Mostrar A\n"
                + "13- Mostrar B\n"
                + "14- Mostrar Universal\n"
                + "\n 0- Regresar\n\n(Ingrese una opción)";
            
            int optionM = -1;
        do
        {
            try{
                optionM = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch(optionM)
                {
                    case 1: //Definir A
                        setString = requestSet();
                        if (option == 1) {
                            AVector.define(UniversalVector, setString);
                            JOptionPane.showMessageDialog(null,"El vector A ha quedado así: "
                            + "\n\n" + AVector.show());
                        }
                        if (option == 2) {
                            AList.define(UniversalList, setString);
                            JOptionPane.showMessageDialog(null,"El vector A ha quedado así: "
                            + "\n\n" + AList.show());
                        }
                        break;

                    case 2: //Definir B
                        setString = requestSet();
                        if (option == 1) {
                            BVector.define(UniversalVector, setString);
                            JOptionPane.showMessageDialog(null,"El vector B ha quedado así: "
                            + "\n\n" + BVector.show());
                        }else if (option == 2) {
                            BList.define(UniversalList, setString);
                            JOptionPane.showMessageDialog(null,"El vector B ha quedado así: "
                            + "\n\n" + BList.show());
                        }
                        break;
                        
                    case 3: //Pertenencia
                        setString = requestElement();
                        String answer = "";
                        if (isNumeric(setString) && option == 1){
                            if (AVector.exist(Integer.parseInt(setString)))
                                answer = answer + "El elemento se encuentra en A\n";
                            if(BVector.exist(Integer.parseInt(setString)))
                                answer = answer + "El elemento se encuentra en B\n";
                        }else if(isNumeric(setString) && option == 2){
                            if (AList.exist(Integer.parseInt(setString)))
                                answer = answer + "El elemento se encuentra en A\n";
                            if(BList.exist(Integer.parseInt(setString)))
                                answer = answer + "El elemento se encuentra en B\n";
                        }else{
                            JOptionPane.showMessageDialog(null,"Ingreso inválido");
                        }
                        if (answer == "")
                            JOptionPane.showMessageDialog(null,"El elemento no se encuentra ni en A ni en B");
                        else
                            JOptionPane.showMessageDialog(null,answer);
                        break;
                        
                    case 4: //Igualdad

                        if (option == 1 && AVector.equal(BVector)) {
                            JOptionPane.showMessageDialog(null,"Los conjuntos A y B son iguales");
                        }else if (option == 2 && AList.equal(BList)) {
                            JOptionPane.showMessageDialog(null,"Los conjuntos A y B son iguales");
                        }else{
                            JOptionPane.showMessageDialog(null,"Los conjuntos A y B no son iguales");
                        }

                        break;

                    case 5: //Inclusión
                        
                        String result = "";
                        if (option == 1 && AVector.included(BVector)) {
                            result = result + "El conjunto A está incluído en B\n";
                        }
                        if (option == 1 && BVector.included(AVector)) {
                            result = result + "El conjunto B está incluído en A\n";
                        }
                        if (option == 2 && AList.included(BList)){
                            result = result + "El conjunto A está incluído en B\n";
                        }
                        if (option == 2 && BList.included(AList)){
                            result = result + "El conjunto B está incluído en A\n";
                        }
                        if (result == "")
                            JOptionPane.showMessageDialog(null, "Ni A ni B están incluídos en el otro");
                        else
                            JOptionPane.showMessageDialog(null, result);
                        break;
                    
                    case 6: //Unión

                        if (option == 1) {
                            ResultVector = AVector.union(BVector);
                            JOptionPane.showMessageDialog(null, "El conjunto resultante de la unión es:\n\n" + ResultVector.show());
                        }else if (option == 2) {
                            ResultList = AList.union(BList);
                            JOptionPane.showMessageDialog(null, "El conjunto resultante de la unión es:\n\n" + ResultList.show());
                        }

                        break;
                        
                    case 7: //Intersección

                        if (option == 1) {
                            ResultVector = AVector.intersection(BVector);
                            JOptionPane.showMessageDialog(null, "El conjunto resultante de la intersección es:\n\n" + ResultVector.show());
                        }else if (option == 2) {
                            ResultList = AList.intersection(BList);
                            JOptionPane.showMessageDialog(null, "El conjunto resultante de la intersección es:\n\n" + ResultList.show());
                        }

                        break;
                        
                    case 8: //Diferencia

                        if (option == 1) {
                            JOptionPane.showMessageDialog(null, "El conjunto resultante A - B:\n\n" + AVector.minus(BVector).show() + 
                                    "\n\nEl conjunto resultante B - A:\n\n" + BVector.minus(AVector).show());
                        }else if (option == 2) {
                            JOptionPane.showMessageDialog(null, "El conjunto resultante A - B:\n\n" + AList.minus(BList).show() + 
                                    "\n\nEl conjunto resultante B - A:\n\n" + BList.minus(AList).show());
                        }

                        break;
                        
                    case 9: //Diferencia simétrica
                        
                        if (option == 1) {
                            ResultVector = AVector.symmetricDiff(BVector);
                            JOptionPane.showMessageDialog(null, "La diferencia simétrica es:\n\n" + ResultVector.show());
                        }else if (option == 2) {
                            ResultList = AList.symmetricDiff(BList);
                            JOptionPane.showMessageDialog(null, "La diferencia simétrica es:\n\n" + ResultList.show());
                        }

                        break;
                        
                    case 10: //Complemento
                        
                        if (option == 1) {
                            JOptionPane.showMessageDialog(null, "El complemento de A es:\n\n" + AVector.complement(UniversalVector).show() + 
                                    "\n\nEl complemento de B es:\n\n" + BVector.complement(UniversalVector).show());
                        }else if (option == 2) {
                            JOptionPane.showMessageDialog(null, "El complemento de A es::\n\n" + AList.complement(UniversalList).show() + 
                                    "\n\nEl complemento de B es:\n\n" + BList.complement(UniversalList).show());
                        }

                        break;
                        
                    case 11: //Producto cartesiano
                        
                        if (option == 1) {
                            JOptionPane.showMessageDialog(null,"El producto A x B es: "
                                + "\n\n" + AVector.CartesianProduct(BVector)
                                + "\n\n" + "El producto B x A es: "
                                + "\n\n" + BVector.CartesianProduct(AVector));
                        }else if (option == 2) {
                            JOptionPane.showMessageDialog(null,"El producto A x B es: "
                                + "\n\n" + AList.CartesianProduct(BList)
                                + "\n\n" + "El producto B x A es: "
                                + "\n\n" + BList.CartesianProduct(AList));
                        }

                        break;
                        
                    case 12: //Mostrar A
                        
                        if (option == 1) {
                            JOptionPane.showMessageDialog(null,"El conjunto A es: " + AVector.show());
                        }else if (option == 2) {
                            JOptionPane.showMessageDialog(null,"El conjunto A es: " + AList.show());
                        }

                        break;
                        
                    case 13: //Mostrar B
                        
                        if (option == 1) {
                            JOptionPane.showMessageDialog(null,"El conjunto B es: " + BVector.show());
                        }else if (option == 2) {
                            JOptionPane.showMessageDialog(null,"El conjunto B es: " + BList.show());
                        }

                        break;

                    case 14: //Mostra Universal
                        
                        if (option == 1) {
                            JOptionPane.showMessageDialog(null,"El conjunto Universal es: " + UniversalVector.show());
                        }else if (option == 2) {
                            JOptionPane.showMessageDialog(null,"El conjunto Universal es: " + UniversalList.show());
                        }

                        break;                        
                        
                    case 0: //Regresar
                        break;
                }
            }catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(null,"Opción no válida!!");
            }
        }while(optionM != 0);    
        }
    }

    private static void setUniversal() {
        setString = requestSet();
        UniversalVector.defineU(setString);
        UniversalList.defineU(setString);
        JOptionPane.showMessageDialog(null,"El vector universal ha quedado así: "
                + "\n\nVector:\n" + UniversalVector.show() + "\nLista:\n" + UniversalList.show());        
    }

    private static String requestSet() { //Pide String al usuario y limpia espacios en blanco
        String set = JOptionPane.showInputDialog("Ingrese números enteros separados por coma"); //Solicita conjunto
        set = set.replaceAll("\\s", ""); //Limpia espacios en blanco
        return set;
    }
    
    private static String requestElement() {
        String set = JOptionPane.showInputDialog("Ingrese un elemento"); //Solicita elemento
        set = set.replaceAll("\\s", ""); //Limpia espacios en blanco
        return set;
    }
    
    public static boolean isNumeric(String str) {
        boolean isNumeric = str.matches("[+-]?\\d+");
        return isNumeric;
    }

    /*
    private static boolean validate(int option) {
        if((option == 1 && AVector.getSize() != 0 && BVector.getSize() != 0) || 
                (option == 2 && AList.getHead() == null && BList.getHead() == null))
            return true;
        else{
            JOptionPane.showMessageDialog(null,"Algún conjunto está vacío");
            return false;
        }            
    }
    */

}
