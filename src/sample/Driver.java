package sample;

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

      r = PhoneAPI.placeCall("");
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
