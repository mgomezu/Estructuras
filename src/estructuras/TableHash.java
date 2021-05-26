package estructuras;


public class TableHash <T>{
    private int tamaño;
    private static int[] tamaños;
    private int indiceTam;
    private int ocupados;
    private float porcentajeUtil;
    private float FactorUtil;
    private NodoHash[] vectorHash;
    
    public TableHash() {
        this.tamaños = new int[]{23,47,97,211,431,997,1597,1997,2593,2999,3989,4999,5987,6991,7993,9973};
        this.indiceTam=0;
        this.ocupados=0;
        this.FactorUtil=65.0f;
        this.tamaño=tamaños[indiceTam];
        this.vectorHash= new NodoHash[tamaño];
        this.porcentajeUtil=calcularPorcentajeUtil();
    }

    private float calcularPorcentajeUtil() {
        return (ocupados*100)/tamaño;
    }
    private int funcion1(int clave){
        return clave%tamaño;
    }
    private int Funcion2(int clave){
        return 1+(clave%(tamaño-1));
    }
    private int generarClave(String id){
        String codigo=id;
        if(codigo.length()>9){
            return reduccion(codigo);
        }else{
            return Integer.parseInt(codigo);
        }
    }

    private int reduccion(String codigo) {
        int tmp=0;
        while(codigo.length()>9){
            String aux="";
            for (int i = codigo.length()/2; i < codigo.length(); i++) {
                aux+=codigo.charAt(i);
            }
            if(aux.length()>9){
                tmp=reduccion(aux);
                aux="";
            }else{
                tmp=Integer.parseInt(aux);
                aux="";
            }
            codigo=tmp+"";
            
        }
        return tmp;
    }
    private int DobleHashing(String id, int factor){
        int tmp=generarClave(id);
        return funcion1(tmp)+(factor*Funcion2(tmp)%tamaño);
    }
    public void insertar(String idt, T cuenta ){
        boolean insertado=false;
        if(porcentajeUtil<=65.00f){
            for (int i = 0; i < tamaño; i++) {
                int posicion= DobleHashing(idt, i);
                if(posicion>tamaño){
                    posicion-=tamaño;
                }
                if(vectorHash[posicion]==null || vectorHash[posicion].estado=='b'){
                    vectorHash[posicion] = new NodoHash(idt, cuenta);
                    ocupados+=1;
                    porcentajeUtil=calcularPorcentajeUtil();
                    insertado=true;
                    break;
                }else{
                    if(vectorHash[posicion].id.equals(idt)){
                        break;
                    }else{
                    }
                }
            }
        }
        else{
            rehashing();
            insertar(idt, cuenta);
        }
    }
    
    private void rehashing() {
        NodoHash[] temp= vectorHash;
        int tamañotmp=tamaño;
        if(indiceTam<tamaños.length){
            indiceTam+=1;
        }
        tamaño=tamaños[indiceTam];
        vectorHash=new NodoHash[tamaño];
        ocupados=0;
        porcentajeUtil=calcularPorcentajeUtil();
        for (int i = 0; i < tamañotmp; i++) {
            if(temp[i]!=null){
                insertar(temp[i].id, (T) temp[i].cuenta);
            }
            
        }
    }
    
    public NodoHash ExtraerNodo(String id){
        boolean encontrado=false;
        NodoHash tmp=null;
        int pos=0;
        for (int i = 0; i < tamaño; i++) {
            int posicion= DobleHashing(id,i);
            if(posicion>=tamaño){
                posicion-=tamaño;
                pos=posicion;
            }
            if(vectorHash[posicion]!=null){
                if(vectorHash[posicion].id.equals(id)){
                    tmp=vectorHash[posicion];
                    encontrado=true;
                    break;
                }
            }
        }
        return tmp;
    }
}