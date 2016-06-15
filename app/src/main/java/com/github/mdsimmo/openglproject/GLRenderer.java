package com.github.mdsimmo.openglproject;

import android.opengl.GLSurfaceView;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static android.opengl.GLES10.*;

/**
 * The GLRenderer class handles our custom rendering code to talk to OpenGL
 */
public class GLRenderer implements GLSurfaceView.Renderer {

    private Scene scene;

    public GLRenderer( Scene scene ) {
        this.scene = scene;
    }

    // Called when the surface is created with a valid OpenGL context
    @Override
    public void onSurfaceCreated( GL10 unused, EGLConfig config ) {
        scene.create();
    }

    // Called whenever the screen size changes
    @Override
    public void onSurfaceChanged( GL10 unused, int width, int height ) {
        // tell OpenGL to use the entire screen
        glViewport( 0, 0, width, height );
    }

    // called once every frame
    @Override
    public void onDrawFrame( GL10 unused ) {
        glClearColor( 0f, 0f, 0f, 1 );
        glClear( GL_COLOR_BUFFER_BIT );

        // enable alpha blending
        glEnable( GL_BLEND );
        glBlendFunc( GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA );

        scene.update();
        scene.draw();
    }
}