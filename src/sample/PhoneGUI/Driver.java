import main.PhoneAPI;
import main.PhoneAPIResponse;

public class Driver {
    public static void main(String args[]) {
      PhoneAPIResponse r = PhoneAPI.verifyConnection();
      System.out.println("verify connection");
      if ( r.isSuccess() ) {
        System.out.println("success");
      } else {
        System.out.println("failed");
      }
      System.out.println("message is " + r.getMessage());
      System.out.println("data is " + r.getData().toString());

      r = PhoneAPI.placeCall("1-802-123-4567");
      System.out.println("place call");
      if ( r.isSuccess() ) {
        System.out.println("success");
      } else {
        System.out.println("failed");
      }
      System.out.println("message is " + r.getMessage());
      System.out.println("data is " + r.getData().toString());

    }
}
