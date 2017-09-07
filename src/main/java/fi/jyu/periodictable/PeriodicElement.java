package fi.jyu.periodictable;

/**
 * Created by Denis on 08.09.2017.
 */
public class PeriodicElement {

    private int atomicNumber;
    private String elementName;
    private String symbol;

    public PeriodicElement(int atomicNumber, String elementName, String symbol) {
        this.atomicNumber = atomicNumber;
        this.elementName = elementName;
        this.symbol = symbol;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String toString(){
        return symbol+"["+atomicNumber+"]"+elementName;
    }
}
