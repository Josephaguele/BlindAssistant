package xyz.redbooks.umme.database;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.File;
import java.util.UUID;

public class FireDataBase {

    /*
    //Storage
   // static MyDBHandler dbHandler;
    public String passValue;

    public static FirebaseStorage storage = FirebaseStorage.getInstance();
    public static StorageReference storageReference = storage.getReference();
    public static String downloadURL="";
    public static String uploadImage(Uri filePath, final Context context) {

        if (filePath != null) {
            final String uploadPath = "images/" + UUID.randomUUID().toString() + "." + getMimeType(context, filePath);
            final StorageReference ref = FireDataBase.storageReference.child(uploadPath);

            UploadTask uploadTask= (UploadTask) ref.putFile(filePath);

            Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }
                    // Continue with the task to get the download URL
                    return ref.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()) {
                        Uri downloadUri = task.getResult();
                    } else {
                        // Handle failures
                        // ...
                    }
                }
            });
            urlTask.addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    downloadURL=uri.toString();
                    Toast.makeText(context, "d"+downloadURL, Toast.LENGTH_SHORT).show();



                   // dbHandler = new MyDBHandler(FireDataBase.this,null,null,1);
                    //String msg = "I AM IN DANGER!";
                    //String contacts = dbHandler.getData();


                    //SmsManager sms = SmsManager.getDefault();

                    //s//ms.sendTextMessage(contacts,null,downloadURL,null,null);
                    //Toast.makeText(FireDataBase.this, "Message send successfully", Toast.LENGTH_SHORT).show();



                }
            });
        }
        return downloadURL;


    }

    public String passUrl(){

        passValue= downloadURL;
        return passValue;


    }

    public static String getMimeType(Context context, Uri uri) {
        String extension;

        //Check uri format to avoid null
        if (uri.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
            //If scheme is a content
            final MimeTypeMap mime = MimeTypeMap.getSingleton();
            extension = mime.getExtensionFromMimeType(context.getContentResolver().getType(uri));
        } else {
            //If scheme is a File
            //This will replace white spaces with %20 and also other special characters. This will avoid returning null values on file name with spaces and special characters.
            extension = MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());

        }
        return extension;
    }
    */
}