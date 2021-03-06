package fi.jyu.periodictable;

/**
 * Created by Denis on 08.09.2017.
 */
public class PeriodicElement {

    private int atomicNumber;
    private String elementName;
    private String symbol;
    private String definition;

    public PeriodicElement(String elementName){
        this.elementName = elementName;
    }

    public PeriodicElement(int atomicNumber, String elementName, String symbol) {
        this.atomicNumber = atomicNumber;
        this.elementName = elementName;
        this.symbol = symbol;
    }

    public PeriodicElement(int atomicNumber, String elementName, String symbol, String definition) {
        this(atomicNumber, elementName, symbol);
        this.definition = definition;
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

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String toString(){
        return symbol+"["+atomicNumber+"]"+elementName;
    }

    public String toJSON(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"atomicNumber\":"+atomicNumber+",");
        sb.append("\"elementName\":\""+elementName+"\",");
        sb.append("\"symbol\":\""+symbol+"\",");
        sb.append("\"definition\":\""+definition.replace("\"", "'").replace("\n", " ").replace("\\","/")+"\"");
        sb.append("}");
        return sb.toString();
    }
}
