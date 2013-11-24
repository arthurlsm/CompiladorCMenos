package compilador.analiseLexica;

import java.io.PushbackReader;
import java.io.StringReader;

import org.junit.*;

import static org.junit.Assert.*;
import compilador.sablecc.lexer.CustomLexer;
import compilador.sablecc.lexer.Lexer;
import compilador.sablecc.lexer.LexerException;

public class TesteLexico {
	public CustomLexer initLexer(String input) {
		CustomLexer lex = new CustomLexer(new PushbackReader(new StringReader(input)));
		return lex;
	}
	
	public String nextTokenClass(Lexer lex) throws Exception {
		String tclass = lex.next().getClass().getName();
		tclass = tclass.substring(tclass.lastIndexOf( '.' ) + 1);
		return tclass;
	}
	
	public void testeTokens(String input, String ... tokens) throws Exception {
		CustomLexer lex = initLexer(input);
		
		for(String tok : tokens) {
			String tclass = nextTokenClass(lex);
			assertEquals("O tipo de Token não casou com a entrada", tok, tclass);
		}
	}
	
	@Test
	public void numeros() throws Exception {
		testeTokens("5", "TNum");
		testeTokens("20", "TNum");
	}
	
	@Test
	public void strings() throws Exception {
		testeTokens("\"isso e uma string\"", "TStringLiteral");
		testeTokens("\"teste\"", "TStringLiteral");
		testeTokens("\"teste\t de uma string\f\"", "TStringLiteral");
	}
	
	@Test
	public void identificadores() throws Exception {
		testeTokens("soma", "TId");
		testeTokens("totalProdutos", "TId");
		testeTokens("idade", "TId");
	}
	
	@Test
	public void palavrasReservadas() throws Exception {
		testeTokens("else", "TElse");
		testeTokens("if", "TIf");
		testeTokens("int", "TInt");
		testeTokens("string", "TString");
		testeTokens("return", "TReturn");
		testeTokens("void", "TVoid");
		testeTokens("while", "TWhile");
	}
	
	@Test
	public void simbolosEspeciais() throws Exception {
		testeTokens("+", "TSoma");
		testeTokens("-", "TSub");
		testeTokens("*", "TMult");
		testeTokens("/", "TDiv");
		testeTokens("<", "TMenorq");
		testeTokens("<=", "TMenorig");
		testeTokens(">", "TMaiorq");
		testeTokens(">=", "TMaiorig");
		testeTokens("==", "TIgual");
		testeTokens("!=", "TNao");
		testeTokens("=", "TAtrib");
		testeTokens(";", "TPtvirg");
		testeTokens(",", "TVirg");
		testeTokens("(", "TApar");
		testeTokens(")", "TFpar");
		testeTokens("[", "TAcol");
		testeTokens("]", "TFcol");
		testeTokens("{", "TAchave");
		testeTokens("}", "TFchave");
	}
	
	@Test
	public void comentarioDeLinha() throws Exception {
		testeTokens("//Teste de comentario de linha1", "TComentarioDeLinha");
		testeTokens("//Teste de comentario de linha 2\r", "TComentarioDeLinha");
		testeTokens("//Teste de comentario de linha 3\n", "TComentarioDeLinha");
		testeTokens("//Teste de comentario de linha 4\r\n", "TComentarioDeLinha");
		testeTokens("//Teste de comentario de linha 5\u001a", "TComentarioDeLinha");
		testeTokens("//Teste //de comentario de linha 5\u001a", "TComentarioDeLinha");
	}
		
	@Test
	public void comentarioDeBloco() throws Exception {
		testeTokens("/* Comentário de bloco válido */", "TComentarioBloco");
		testeTokens("/* /* Comentário de bloco válido */ */", "TComentarioBloco");
	}
	
	@Test(expected=LexerException.class)
	public void comentarioDeBlocoErroFechamento() throws Exception {
		testeTokens("/* /* Comentario sem um fechamento */", "InvalidToken");
	}
	
	@Test(expected=LexerException.class)
	public void tokensInvalidos() throws Exception {
		testeTokens("_soma", "InvalidToken");
		testeTokens("$idade", "InvalidToken");
	}
	
}
