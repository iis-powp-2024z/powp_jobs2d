package edu.kis.powp.jobs2d.helpers;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;

public enum LineType { 
    BASIC{
        @Override 
        public ILine getLine() { return LineFactory.getBasicLine(); }
    }, 
    DOTTED{
        @Override 
        public ILine getLine() { return LineFactory.getDottedLine(); }
    }, 
    SPECIAL{
        @Override 
        public ILine getLine() { return LineFactory.getSpecialLine(); }
    },  
    CUSTOM{
        @Override
        public ILine getLine() {
            throw new UnsupportedOperationException("Custom lines are managed externally.");
        }
    };
    
    public abstract ILine getLine();
}
