package web.services.xml.adaptateurs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdaptateur extends XmlAdapter<String,Date> {

    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    @Override
    public Date unmarshal(String v) throws Exception {
        return df.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return df.format(v);
    } 
}
