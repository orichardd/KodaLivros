package koda.livros.farfetchd.utils;

public interface Utils {

    public static String LongToHex(Long l) {
        return(Long.toHexString(l).toUpperCase());
    }

    public static String GenerateCode(String prefix, Long id){
        String hex = LongToHex(id);
        int length = 10 - prefix.length() - hex.length();
        if(length < 0){
            throw new IllegalArgumentException("Número de dados excedido");
        }
        String code = prefix;
        for(int i = length; i > 0; i--){
            code = code.concat("0");
        }
        code = code.concat(hex);
        System.out.println(code);
        return code;
    }

}
