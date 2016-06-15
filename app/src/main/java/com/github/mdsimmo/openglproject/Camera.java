package com.github.mdsimmo.openglproject;

import android.opengl.GLES10;

/**
 * A class that defines how the user will see the world
 */
public class Camera {

    private float x, y;
    private float w, h;

    public Camera() {
        position( 0, 0 );
        size( 1, 1 );
    }

    public Camera position( float x, float y ) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Camera size( float width, float height ) {
        this.w = width;
        this.h = height;
        return this;
    }

    /**
     * Applies the camera to the screen.
     * Note: we do not want the  camera to apply itself whenever a change is made
     * because that would mean that we couldn't have two camera's in existence.
     */
    public void apply() {
        float w2 = w / 2;
        float h2 = h / 2;
        GLES10.glMatrixMode( GLES10.GL_PROJECTION );
        GLES10.glLoadIdentity();
        GLES10.glOrthof( x - w2, x + w2, y - h2, y + h2, 1, -1 );
    }
}
