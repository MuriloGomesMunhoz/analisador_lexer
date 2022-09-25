public class skip_whitespace {

    public void space(String texto, int qtde){
        int pos = 0;
        char current_char = texto.charAt(pos);
        while (current_char != '!' && current_char == ' '){
            pos += qtde;
            if (pos > (texto.length()-1)){
                current_char = '!';
            }else{
                current_char = texto.charAt(pos);
            }
        }
    }

}
