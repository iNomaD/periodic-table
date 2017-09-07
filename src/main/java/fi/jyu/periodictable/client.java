package fi.jyu.periodictable;

import net.webservicex.Periodictable;
import net.webservicex.PeriodictableSoap;

import java.util.List;

/**
 * Created by Denis on 08.09.2017.
 */
public class client {

    public static void main(String[] args){
        System.out.println("Hello!");

        try {
            List<PeriodicElement> list = PeriodicTableResponseParser.getElements();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
