import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostWeb {

        private final String USER_AGENT = "Mozilla/5.0";

        public String sendGet() throws Exception {

            String url = "http://yugmeteo.donpac.ru//bullettin/warning.jsp";

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            System.out.println("Sending 'GET' request to URL : " + url);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "windows-1251"));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String sResp= response.toString();

            int i=1;
            String sFirst="";

            while (i<sResp.lastIndexOf("</h3>")){
                int sRespIntStart=sResp.indexOf("<h3>", i);
                int sRespIntEnd = sResp.indexOf("</h3>", i);
                sFirst=sFirst + sResp.substring(sRespIntStart+4, sRespIntEnd);
                i=sRespIntEnd+1;
            }
            sFirst=sFirst.replace("&#13;", "\n");
            return sFirst;

        }

    }


