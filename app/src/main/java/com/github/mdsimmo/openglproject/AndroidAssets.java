package com.github.mdsimmo.openglproject;

import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;

public class AndroidAssets implements Assets {

    AssetManager assetManager;

    public AndroidAssets( AssetManager assetManager ) {
        this.assetManager = assetManager;
    }

    @Override
    public InputStream open( String name ) {
        try {
            return assetManager.open( name );
        } catch ( IOException e ) {
            throw new RuntimeException( "Couldn't open file " + name, e );
        }
    }
}
