package br.ufs.compilador.lexer;

import java.io.PushbackReader;

import br.ufs.compilador.node.EOF;
import br.ufs.compilador.node.InvalidToken;
import br.ufs.compilador.node.TComentarioBloco;
import br.ufs.compilador.node.TComentarioBlocoFim;

public class CustomLexer extends Lexer {
	private TComentarioBloco comentario;
	
	// Defini��o do construtor
	public CustomLexer(PushbackReader in){ 
		super(in);
	}
	
	// Defini��o de um filtro para tratar os coment�rios aninhados.
	// O funcionamento dele � igual ao do Java.
	protected void filter() throws LexerException {
		if(state.equals(State.COMENTARIO)){
			if (comentario == null) {
				comentario = (TComentarioBloco) token;
				token = null;
			}
			else {
				if (token instanceof TComentarioBlocoFim) {
					token = comentario;
					state = State.NORMAL;
					comentario = null;
				}
				else if(token instanceof EOF) {
					throw new LexerException(new InvalidToken("/*"), 
						"O comentario nao foi fechado. Linha: " + token.getLine() +
						", posicao: " + token.getPos() + "."); 
				}
				else {
					token = null;
				}	
			}
		}
	}
}
