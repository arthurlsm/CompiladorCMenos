package br.ufs.compilador.lexer;

import java.io.PushbackReader;

import br.ufs.compilador.node.EOF;
import br.ufs.compilador.node.InvalidToken;
import br.ufs.compilador.node.TComentarioBloco;
import br.ufs.compilador.node.TComentarioBlocoFim;

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
						throw new LexerException(new InvalidToken("/*"), 
								"O comentario nao foi fechado. Linha: " + token.getLine() +
								", posicao: " + token.getPos() + "."); 
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
