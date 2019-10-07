import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class GetWarning {


    //String resp=getURL("http://yugmeteo.donpac.ru//bullettin/warning.jsp");

    public String getURL(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse respl=httpClient.execute(httpGet);

        String sResp= EntityUtils.toString(respl.getEntity());
        int i=1;
        String sFirst="";

        while (i<sResp.lastIndexOf("</h3>")){
            int sRespIntStart=sResp.indexOf("<h3>", i);
            int sRespIntEnd = sResp.indexOf("</h3>", i);
            //System.out.println(sResp.substring(sRespIntStart+4, sRespIntEnd));
            sFirst=sFirst + sResp.substring(sRespIntStart+4, sRespIntEnd);
            i=sRespIntEnd+1;
        }

        return sFirst;
    }
}
