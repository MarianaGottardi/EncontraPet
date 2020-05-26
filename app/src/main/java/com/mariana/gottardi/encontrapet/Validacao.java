package com.mariana.gottardi.encontrapet;

public class Validacao {

    public static String converterMaiuscula(String c){
        return c.toUpperCase();
    }//fecha converterMaiuscula

    public static boolean verificarNome(String nome){
        return nome.matches("^[a-zA-ZáÁéÉíÍóÓúÚçÇãÃõÕ ]{2,80}$");
    }//fecha verificarNome

}
