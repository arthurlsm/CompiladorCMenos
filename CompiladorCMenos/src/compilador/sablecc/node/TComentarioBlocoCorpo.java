/* This file was generated by SableCC (http://www.sablecc.org/). */

package compilador.sablecc.node;

import compilador.sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TComentarioBlocoCorpo extends Token
{
    public TComentarioBlocoCorpo(String text)
    {
        setText(text);
    }

    public TComentarioBlocoCorpo(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TComentarioBlocoCorpo(getText(), getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTComentarioBlocoCorpo(this);
    }
}