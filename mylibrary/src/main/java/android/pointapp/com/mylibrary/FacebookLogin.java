package android.pointapp.com.mylibrary;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.pointapp.com.mylibrary.DataModel.FacebookUserOutPutModel;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import static com.facebook.FacebookSdk.getApplicationContext;

public class FacebookLogin {
    CallbackManager mFacebookCallbackManager;
    FacebookUserOutPutModel facebookUserOutPutModel;
    public FacebookLogin() {


    }

    public void singInFacebook(Context context) {
        FacebookSdk.sdkInitialize(context);
        LoginManager.getInstance().registerCallback(CallbackManager.Factory.create(),
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Profile profile = Profile.getCurrentProfile();
                        Log.i("Profile", profile + "");

                        // App code
                        GraphRequest request = GraphRequest.newMeRequest(
                                loginResult.getAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(JSONObject object, GraphResponse response) {
                                        Log.v("LoginActivity", response.toString());
                                        Log.i("Object", object + "");
                                        // Application code
                                        try {
                                            String name = object.getString("name");
                                            String email = object.getString("email");
                                          FacebookUserOutPutModel facebookUserOutPutModel1 = new FacebookUserOutPutModel();
                                          facebookUserOutPutModel1.setUserEmail(email);
                                          facebookUserOutPutModel1.setUserEmail(name);
                                          facebookUserOutPutModel = facebookUserOutPutModel1;

                              //              callToSocialLogin(email, name, "");
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }

                                    }
                                });
                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "id,name,email,gender,birthday");
                        request.setParameters(parameters);
                        request.executeAsync();
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        Log.e("facebookLoginError", exception + "");
                    }
                });

        LoginManager.getInstance().logInWithReadPermissions((Activity) context, Arrays.asList("public_profile", "email"));
    }


    public FacebookUserOutPutModel getFaceboiokUserData(){

        return facebookUserOutPutModel;
    }

}
