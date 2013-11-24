/* This file was generated by SableCC (http://www.sablecc.org/). */

package compilador.sablecc.node;

import compilador.sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TFchave extends Token
{
    public TFchave()
    {
        super.setText("}");
    }

    public TFchave(int line, int pos)
    {
        super.setText("}");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TFchave(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTFchave(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TFchave text.");
    }
}