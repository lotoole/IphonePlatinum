package sample;

//import org.json.*;

//import gson-2.6.2.jar;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class PhoneAPIResponse {

    /**
     * A boolean value that will tell us if the response worked or not.
     */
    private boolean success;
    /**
     * A message summarizing the response. This will either be a success message, or a sentence
     * describing what went wrong if there was an error.
     */
    private String message;
    /**
     * A JsonObject holding data that may have been returned from the JDH API.
     *
     * @see JsonObject
     */
    private JsonObject data;

    /**
     * We set up the default response to provide a generic error message, no data, and failure.
     * This way if something goes wrong someone along the line and the response object can be modified,
     * we will know right away because these values will persist.
     */
    public PhoneAPIResponse() {
        this(false, "ERROR", null);
    }

    /**
     * This constructor is used when we are retrieving the raw json element from the JDH API.
     * This json element will contain members for success, message, and data. This constructor
     * will parse that json element and correctly populate the PhoneAPIResponse object
     * for quick and easy access to each field.
     *
     * @param json The raw json response from the JDH API.
     */
    public PhoneAPIResponse(JsonElement json) {
        JsonObject jsonObject = json.getAsJsonObject();
        success = jsonObject.get("success").getAsBoolean();
        message = jsonObject.get("message").getAsString();
        data = jsonObject.getAsJsonObject("data");
    }

    /**
     * The only purpose of this constructor it to allow for a cleaner looking default constructor.
     *
     * @param success Was the response a success?
     * @param message The message summarizing what happened.
     * @param data The actual data that may have been returned.
     */
    public PhoneAPIResponse(boolean success, String message, JsonObject data) {
        this.setSuccess(success);
        this.setMessage(message);
        this.setData(data);
    }

    /**
     * success getter.
     *
     * @return Whether or not the response was a success.
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * success setter.
     *
     * @param success Whether or not the response was a success.
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * message getter.
     *
     * @return The message summarizing what happened.
     */
    public String getMessage() {
        return message;
    }

    /**
     * message setter
     *
     * @param message The message summarizing what happened.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * data getter.
     *
     * @return The actual data pertaining to the response.
     */
    public JsonObject getData() {
        return data;
    }

    /**
     * data setter.
     *
     * @param data The actual data pertaining to the response.
     */
    public void setData(JsonObject data) {
        this.data = data;
    }

}
