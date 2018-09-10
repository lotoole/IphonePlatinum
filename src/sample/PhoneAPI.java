package sample;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class PhoneAPI {
    /**
     * Holds all of the valid endpoints that the PHONE API accepts. When implementing new
     * methods to new endpoints within this class, always use an Endpoint enum.
     */
    public enum Endpoint {
        verify_connection, place_call
    }

    /**
     * The location of the PHONE API file on UVM's server.
     */
    public static final String URL = "https://jhibbele.w3.uvm.edu/PHONE/api/";

    /**
     * When we send a request to the PHONE API, we should to tell it what kind of 'device/browser' it
     * is coming from. This is an arbitrary name that we just made up.
     */
    public static final String USER_AGENT = "PhoneAPI/Java";

    /**
     * Like all API's, credentials are a good idea. This is the location of the .txt file that holds
     * the credentials. That file should never be checked in to version control, and the credentials
     * should never be hard coded in this class.
     */
    public static final String CREDENTIALS_FILE = "phone_api_credentials.txt";


    /**
     * Make a call
     *
     * @param phoneNumber The number you are calling
     *
     * @return Everything you need to know about the request.
     * @see    PhoneAPIResponse
     */
    public static PhoneAPIResponse placeCall(String phoneNumber) {
        PhoneAPIResponse response = sendRequest(Endpoint.place_call, "number=" + phoneNumber);
        return response;
    }


    /**
     * A helper 'test' method to verify that connection to the PHONE API works.
     *
     * @return Everything you need to know about the request.
     * @see    PhoneAPIResponse
     */
     
    public static PhoneAPIResponse verifyConnection() {
        PhoneAPIResponse response = sendRequest(Endpoint.verify_connection, null);
        return response;
    }

    /**
     * Try's to retrieve the API key from the credentials file.
     *
     * @return String This gives you the api key, or the error code (which is a camel case message).
     */
    private static String getAPIKey() {
        String apiKey = "invalid_key";
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(CREDENTIALS_FILE));
        } catch (FileNotFoundException e) {
            return "no_credentials_file";
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            apiKey = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                apiKey = "buffer_error";
            }
        }
        return apiKey.trim();
    }

   /**
     * This provides the core functionality for sending requests to the PHONE API. It will return
     * a PhoneAPIResponse object that is populated with data, or the information about what went wrong.
     *
     * @param endpoint The endpoint you'd like to hit on the API.
     * @param data     A query string of data you'd like to send along. ex. "var1=dog&var2=cat"
     *
     * @return         Everything you need to know about the request.
     * @see            PhoneAPIResponse
     */
    private static PhoneAPIResponse sendRequest(Endpoint endpoint, String data) {
        PhoneAPIResponse phoneResponse = new PhoneAPIResponse();
        try {
            // Create the full query string to send along with the request.
            String fullData = "api_endpoint=" + endpoint.toString() + "&api_key=" + getAPIKey() + "&" + data;
            // Create the URL object, and then create and send the request with it.

System.out.println("sending |" + fullData + "|");

            URL obj = new URL(URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(fullData.getBytes());
            os.flush();
            os.close();
            // Now that we have the response, let's fill out the PhoneAPIResponse appropriately.
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                JsonElement jsonElement = new JsonParser().parse(response.toString());
                return new PhoneAPIResponse(jsonElement);
            } else {
                phoneResponse.setMessage("API failed with response code: " + responseCode);
            }
        } catch (IOException ex) {
            phoneResponse.setMessage("Unable to send request to API.");
        }
        return phoneResponse;
    }
}

