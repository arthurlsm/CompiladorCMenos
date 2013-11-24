package compilador.analiseLexica;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;

import compilador.sablecc.lexer.CustomLexer;
import compilador.sablecc.lexer.LexerException;
import compilador.sablecc.node.EOF;
import compilador.sablecc.node.TComentarioBloco;
import compilador.sablecc.node.TComentarioDeLinha;
import compilador.sablecc.node.TEspacosEmBranco;
import compilador.sablecc.node.TId;
import compilador.sablecc.node.TNum;
import compilador.sablecc.node.Token;

public class Aplicacao {
	
	public static void main (String [] args) {
		CustomLexer lex = new CustomLexer(new PushbackReader(new InputStreamReader(System.in)));
		try {
			Token token = lex.next();
			
			while (!(token instanceof EOF)) {
				String tclass = token.getClass().getName();
				tclass = tclass.substring(tclass.lastIndexOf( '.' ) + 1);
				
				if(token instanceof TEspacosEmBranco) {
					System.out.print(token.getText());
				}
				else if (token instanceof TId){
					System.out.print("ID(" + token.getText() + ") ");
				}
				else if (token instanceof TNum){
					System.out.print("NUM(" + token.getText() + ") ");
				}
				else if(token instanceof TComentarioBloco) {
					System.out.print("");
				}
				else if(token instanceof TComentarioDeLinha) {
					System.out.print("");
				}
				else {
					System.out.print(tclass + " ");
				}
				
				token = lex.next();
			}
		} catch (LexerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
