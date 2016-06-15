package com.github.mdsimmo.openglproject;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

/**
 * MainActivity is the entry point into the code from android. This class does
 * very little except to pass of all the work to our GLRenderer class
 */
public class MainActivity extends Activity {

    private GLSurfaceView surface;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        GLSurfaceView surface = this.surface = new GLSurfaceView( this );
        surface.setRenderer( new GLRenderer( new GameScene( new AndroidAssets( getAssets() ) ) ) );
        setContentView( surface );
    }

    @Override
    protected void onPause() {
        super.onPause();
        surface.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        surface.onResume();
    }
}
