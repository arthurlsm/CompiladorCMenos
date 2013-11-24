package compilador.sablecc.lexer;

import java.io.PushbackReader;

import compilador.sablecc.node.EOF;
import compilador.sablecc.node.InvalidToken;
import compilador.sablecc.node.TComentarioBloco;
import compilador.sablecc.node.TComentarioBlocoFim;

public class CustomLexer extends Lexer {
	private int cont;
	private TComentarioBloco comentario;
	
	// Definição do construtor
	public CustomLexer(PushbackReader in){ 
		super(in);
	}
	
	// Definição de um filtro que reconhece os comentários aninhados.
	protected void filter() throws LexerException {
		if(state.equals(State.COMENTARIO)){
			if (comentario == null) {
				comentario = (TComentarioBloco) token;
				cont = 1;
				token = null;
			}
			else {
				if (token instanceof TComentarioBloco) {
					cont++;
				}
				else if (token instanceof TComentarioBlocoFim) {
					cont--;
				}
				else if(token instanceof EOF) {
					if (cont > 0){
						throw new LexerException(new InvalidToken("/*"), "Um comentario nao foi fechado."); 
					}
				}
				
				if (cont != 0) {
					token = null;
				}
				else {
					token = comentario;
					state = State.NORMAL;
					comentario = null;
				}
			}
		}
	}
}
