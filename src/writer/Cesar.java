package writer;

import java.util.Locale;

public class Cesar implements IEncripta{
    private String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    @Override
    public String Encripta(String texto) {
        String textoCifrado = "";

        texto = texto.toUpperCase();
        char caracter;

        for (int i = 0; i<texto.length(); i++){
            caracter = texto.charAt(i);
            int pos = abecedario.indexOf(caracter);
            if (pos == -1){
                textoCifrado += caracter;
            }else{
                textoCifrado+=abecedario.charAt((pos + 3) % abecedario.length());
            }

        }
        return textoCifrado;
    }

    @Override
    public String Desencripta(String textoEncriptado) {
        String textoDescifrado = "";

        textoEncriptado = textoEncriptado.toUpperCase();
        char caracter;

        for (int i = 0; i<textoEncriptado.length(); i++){
            caracter = textoEncriptado.charAt(i);
            int pos = abecedario.indexOf(caracter);
            if (pos == -1){
                textoDescifrado += caracter;
            }else{
                if(pos-3 < 0){
                    textoDescifrado+=abecedario.charAt(abecedario.length() + ( pos - 3));
                }else{
                    textoDescifrado+=abecedario.charAt((pos - 3) % abecedario.length());
                }

            }

        }
        return textoDescifrado;
    }
}
