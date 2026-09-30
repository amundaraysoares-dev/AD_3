import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import java.io.Serializable;

public class producto implements Serializable {
    private String nome;
    private int num1;
    private int num2;

    public producto(String nome, int num1,int num2){
        this.nome = nome;
        this.num1 = num1;
        this.num2 = num2;
    }

    public static void almacenar(String ruta,producto ob){
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
    public static producto leer(String ruta){
        producto ob2 = null;
        try(
                FileInputStream copia = new FileInputStream(ruta);
                ObjectInputStream objeto = new ObjectInputStream(copia)
        ){

            ob2 = (producto) objeto.readObject();
            System.out.println("objeto leido");
            System.out.println(ob2.nome);

        } catch (IOException | ClassNotFoundException e){
            System.out.println("algo ha salido mal");



        }
        return ob2;
    }







    public static void main(String[] args){
        producto pro_1 = new producto("leche",12,133);

        producto.leer("objetitos");




}


}
