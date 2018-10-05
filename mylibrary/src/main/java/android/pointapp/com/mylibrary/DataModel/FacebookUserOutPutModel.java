package android.pointapp.com.mylibrary.DataModel;

import java.io.Serializable;

public class FacebookUserOutPutModel implements Serializable{
    String UserName,UserEmail;

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserName() {

        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
