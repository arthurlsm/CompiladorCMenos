/* This file was generated by SableCC (http://www.sablecc.org/). */

package compilador.sablecc.node;

import compilador.sablecc.analysis.*;

@SuppressWarnings("nls")
public final class TVirg extends Token
{
    public TVirg()
    {
        super.setText(",");
    }

    public TVirg(int line, int pos)
    {
        super.setText(",");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TVirg(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTVirg(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TVirg text.");
    }
}
