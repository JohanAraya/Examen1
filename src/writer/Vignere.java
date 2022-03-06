package writer;

public class Vignere implements IEncripta{
    String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    @Override
    public String Encripta(String texto) {
        String salida="";
        String clave = "POLLO";
        char []claveEquals= new char[texto.length()];
        char []Msg = texto.toUpperCase().toCharArray();
        int cont = 0;

        for (int c = 0; c<texto.length(); c++ ) {
            if (texto.charAt(c) == ' ') {
                c++;
            }

            claveEquals[c] = clave.charAt(cont);
            cont++;
            if (cont == clave.length()) {
                cont = 0;
            }
        }
        int x=0,y=0,z;
        for (int c=0; c<texto.length(); c++){
            if (texto.charAt(c)==' '){

                salida+=" ";
                c++;
            }
            for (int f=0; f<abecedario.length();f++){
                if(Msg[c] == abecedario.charAt(f)){
                    x=f;
                }
                if (claveEquals[c] == abecedario.charAt(f)){
                    y=f;
                }
            }
            z=(x+y)%27;
            salida+=abecedario.charAt(z);
        }
        return salida;
    }

    @Override
    public String Desencripta(String textoEncriptado) {
        String salida="";
        String clave = "POLLO";
        char []claveEquals= new char[textoEncriptado.length()];
        char []Msg = textoEncriptado.toUpperCase().toCharArray();
        int cont = 0;
        for (int c=0; c<textoEncriptado.length();c++){
            if (textoEncriptado.charAt(c)== ' ')
            {
                c++;
            }
            claveEquals[c]=clave.charAt(cont);
            cont++;
            if (cont==clave.length()){
                cont=0;
            }
        }
        cont=0;
        int x=0,y=0,z;
        for (int c=0; c<textoEncriptado.length();c++){
            if (textoEncriptado.charAt(c)==' '){
                salida+=" ";
                c++;
            }
            for (int f = 0;f<abecedario.length();f++){
                if (Msg[c]==abecedario.charAt(f)){
                    x=f;
                }
                if (claveEquals[c]==abecedario.charAt(f)){
                    y=f;
                }
            }
            z=(y-x);
            if (z<=0){
                if (z==0){
                    salida += "A";
                }else{
                    for (int j =1;j<abecedario.length();j++){
                        cont++;
                        if (cont==(z*-1)){
                            salida+=abecedario.charAt(j);
                            break;
                        }
                    }
                }

            }else{
                for (int i=26;i>=0;i--){
                    cont++;
                    if (cont==z){
                        salida+=abecedario.charAt(i);
                        break;
                    }
                }
            }
            cont=0;
        }
        return salida;
    }
}
