import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class productosTrancient implements Serializable{
    private String nome;
    transient int num1;
    private int num2;

    public productosTrancient(String nome, int num1,int num2){
        this.nome = nome;
        this.num1 = num1;
        this.num2 = num2;
    }

    public static void almacenar_t(String ruta,productosTrancient ob){
        try(
                FileOutputStream copia = new FileOutputStream(ruta);
                ObjectOutputStream objeto = new ObjectOutputStream(copia)
        ){

            objeto.writeObject(ob);
            System.out.println("objeto guardado");

        } catch (IOException e){
            System.out.println("algo ha salido mal");



        }
    }
    public static productosTrancient leer_t(String ruta){
        productosTrancient ob3 = null;
        try(
                FileInputStream copia = new FileInputStream(ruta);
                ObjectInputStream objeto = new ObjectInputStream(copia)
        ){

            ob3 = (productosTrancient) objeto.readObject();
            System.out.println("objeto leido");
            System.out.println(ob3.nome);

        } catch (IOException | ClassNotFoundException e){
            System.out.println("algo ha salido mal");
        }
        return ob3;
    }


    public static void main(String[] args){

        productosTrancient pro_3 = new productosTrancient("filipinos",12,133);
        productosTrancient.leer_t("filipinos");


    }

}
