import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.json.JSONString;

/**
 * @GOOD&BAD
 * Deserialization is performed by specialized libraries like Jackson
 * 1.)Apache is easiest to use for building your own REST client
 * 2.)Using jackson for json parsing instead of Gson
 * 3.)Apache has HTTP2 and NIO support
 * 4.)Apache can establish a pool connection for a host
 * 5.)Apache has just about every useful function you will ever need
 * 6.)Apache is one of the fastest asynchronous (non-blocking) clients out there
 * 7.)Apache is very reliable, basic, portable, and usable
 * 8.)Apache has it's own middleware stack (API) and implements a Fetch API
 * 9.)Apache is not a browser compatible as other clients
 * 10.)Very High latency
 */

public class YouAreEll {
    YouAreEll() {
    }

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        YouAreEll urlhandler = new YouAreEll();

        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
        //StringEntity requestEntity = new StringEntity(JSONString,ContentType.APPLICATION_JSON);
        //HttpPost postMethod = new HttpPost("http://zipcode.rocks:8085");
        //postMethod.setEntity(requestEntity);
    }

    public String get_ids() {
        return MakeURLCall("/ids", "GET", "");
    }

    public String get_messages() {
        return MakeURLCall("/messages", "GET", "");
    }

    public String MakeURLCall(String mainurl, String method, String jpayload) {
        return "wtf";
        }
    }