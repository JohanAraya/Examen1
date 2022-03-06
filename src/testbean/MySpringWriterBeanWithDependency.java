package testbean;

import com.sun.org.apache.xpath.internal.objects.XNumber;
import org.springframework.beans.factory.annotation.Autowired;
import writer.IEncripta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class MySpringWriterBeanWithDependency {

    private IEncripta writer;
    @Autowired
    public void setWriter(IEncripta pWriter){this.writer = pWriter;}

    static PrintStream out= System.out;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public void run() throws IOException {
        int opc = -1;

        out.println("Menú");
        out.println("¿Que desea realizar?");
        out.println("1-Encriptar");
        out.println("2-Desencriptar");
        out.println("0-Salir");
        out.println("Elija una opción");

        opc = Integer.parseInt(in.readLine());


        procesarOpcion(opc);

    }

    private void procesarOpcion(int opc) throws IOException {

        switch (opc){
            case 0:
                System.exit(0);
                break;
            case 1:
                menuEncriptar();
                break;
            case 2:
                menuDesencriptar();
                break;
            default:
                run();
                break;
        }
    }

    private void menuEncriptar() throws IOException {
        out.println("Escriba la palabara que desea encriptar");
        String texto = in.readLine();
        out.println("Texto Encriptado: " + writer.Encripta(texto));
        out.println(" ");
        run();
    }

    private void menuDesencriptar() throws IOException {

        out.println("Escriba el texto encriptado para desencriptar");
        String texto = in.readLine();
        out.println("Texto Desencriptado: " + writer.Desencripta(texto));
        run();
    }
}
