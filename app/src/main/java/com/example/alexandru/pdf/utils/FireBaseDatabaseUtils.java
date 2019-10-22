package com.example.alexandru.pdf.utils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBaseDatabaseUtils {

    public static final String SONG = "song";
    private static FirebaseDatabase database;
    private static DatabaseReference myRef;

    private static void createDatabaseConn(){
        database = FirebaseDatabase.getInstance();
        database.setPersistenceEnabled(true);
        myRef = database.getReference(SONG);
    }

    public static DatabaseReference getDatabaseConn(){
        if(database == null && myRef == null){
            createDatabaseConn();
            return myRef;
        }
        return myRef;
    }


}
