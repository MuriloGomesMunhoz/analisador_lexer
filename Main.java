import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
      try {
          File file = new File("code.txt");
          Scanner sc = new Scanner(file);
          int line = 1;
          while (sc.hasNextLine()) {
              String text = sc.nextLine();
              Lexer lexer = new Lexer(text);
              Token token = lexer.getNextToken();
                  // imprime todos os tokens
                  while (!token.getTipo().equals("EOF")) {
                      System.out.println(token);
                      token = lexer.getNextToken();
                  }
              }
          sc.close();
    } catch (RuntimeException re) {
      System.out.println("Error: " + re.getMessage());
    } catch (FileNotFoundException e) {
          throw new RuntimeException(e);
      }
  }
}
