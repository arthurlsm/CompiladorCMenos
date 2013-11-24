/* This file was generated by SableCC (http://www.sablecc.org/). */

package compilador.sablecc.analysis;

import java.util.*;
import compilador.sablecc.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseTElse(TElse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIf(TIf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInt(TInt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTString(TString node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTReturn(TReturn node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTVoid(TVoid node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTWhile(TWhile node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSoma(TSoma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSub(TSub node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMult(TMult node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDiv(TDiv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMenorq(TMenorq node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMenorig(TMenorig node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMaiorq(TMaiorq node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMaiorig(TMaiorig node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIgual(TIgual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNao(TNao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAtrib(TAtrib node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPtvirg(TPtvirg node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTVirg(TVirg node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTApar(TApar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFpar(TFpar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAcol(TAcol node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFcol(TFcol node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAchave(TAchave node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFchave(TFchave node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTId(TId node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNum(TNum node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTStringLiteral(TStringLiteral node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEspacosEmBranco(TEspacosEmBranco node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComentarioDeLinha(TComentarioDeLinha node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComentarioBloco(TComentarioBloco node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComentarioBlocoFim(TComentarioBlocoFim node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComentarioBlocoCorpo(TComentarioBlocoCorpo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEstrela(TEstrela node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBarra(TBarra node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
