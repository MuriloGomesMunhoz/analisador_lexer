import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isDigit;

public class Lexer{

  private String texto;
  private int pos;
  private char current_char;

  private List<AFD> afds;
  public Lexer(String texto){
    this.texto = texto;
    this.pos = 0;  
    this.current_char = texto.charAt(pos);
    this.afds = new ArrayList<>();

  }

  public void error(){
    throw new RuntimeException("INVALID CARACTER");
  }

  public void advance(int qtde){
    pos += qtde;
    if (pos > (texto.length()-1)){
      current_char = '!';
    }else{
      current_char = texto.charAt(pos);
    }
  }

  public void skip_whitespace(){
    while (current_char != '!' && current_char == ' ' ){
      advance(1);
    }
  }

  public Token getNextToken(){

    while(current_char != '!'){
      if (current_char == ' '){
        skip_whitespace();
        continue;
      }

      afds.add(new PLUS());
      afds.add(new LPAREN());
      afds.add(new RPAREN());
      afds.add(new LCHAVE());
      afds.add(new RCHAVE());
      afds.add(new SUB());
      afds.add(new MUL());
      afds.add(new DIV());
      afds.add(new EOF());
      afds.add(new RESERVADA_INT());
      afds.add(new RESERVADA_FLOAT());
      afds.add(new RESERVADA_RETURN());
      afds.add(new COMENTARIO());
      afds.add(new NUMERO());
      afds.add(new ID());
      afds.add(new FLUTUANTE());
      afds.add(new ERROR());



      for (AFD afd : afds) {
        Token reconhecido = afd.processa(pos, texto);
        if (reconhecido != null) {
          advance(reconhecido.getLength());
          return reconhecido;
        }
      }

      //error();
    }
    return new Token("EOF", "!", 1);
  }
}
