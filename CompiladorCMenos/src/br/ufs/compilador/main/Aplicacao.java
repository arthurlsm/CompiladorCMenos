package br.ufs.compilador.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

import br.ufs.compilador.custom.CustomLexer;
import br.ufs.compilador.lexer.LexerException;
import br.ufs.compilador.node.EOF;
import br.ufs.compilador.node.TComentarioBloco;
import br.ufs.compilador.node.TComentarioDeLinha;
import br.ufs.compilador.node.TEspacosEmBranco;
import br.ufs.compilador.node.TId;
import br.ufs.compilador.node.TNum;
import br.ufs.compilador.node.Token;

public class Aplicacao {
	
	public static void main (String [] args) {
		try {
			if (args.length == 0) {
				System.out.println("Nenhum argumento informado. Passe como argumento o "
						+ "caminho completo do arquivo com o codigo fonte.");
			}
			else {
				File in = new File(args[0]);
				FileReader reader = new FileReader(in);
				
				CustomLexer lex = new CustomLexer(new PushbackReader(reader));
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
			}
		}
		catch (LexerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
