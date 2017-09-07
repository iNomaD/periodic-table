package fi.jyu.periodictable;

import java.util.List;

/**
 * Created by Denis on 08.09.2017.
 */
public class client {

    public static void main(String[] args){
        System.out.println("Hello!");

        try {
            List<PeriodicElement> list = ServiceResponseProcessor.getElements();
            for(PeriodicElement element : list){
                ServiceResponseProcessor.fillElement(element);
                ServiceResponseProcessor.defineElement(element);
                System.out.println(element);
                System.out.println(element.getDefinition());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
