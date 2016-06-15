package com.github.mdsimmo.openglproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

import java.io.IOException;
import java.io.InputStream;

import static android.opengl.GLES10.*;

/**
 * A wrapper for loading and using a Texture in OpenGL
 */
public class Texture {

    private InputStream source;
    private int id;
    private int width, height;

    public Texture( InputStream source ) {
        this.source = source;
        load();
    }

    private void load() {
        // generate the texture
        Bitmap bitmap = BitmapFactory.decodeStream( source );
        try {
            source.reset();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        int[] textureIds = new int[1];
        glGenTextures( 1, textureIds, 0 );
        int texId = id = textureIds[0];
        glBindTexture( GL_TEXTURE_2D, texId );
        GLUtils.texImage2D( GL_TEXTURE_2D, 0, bitmap, 0 );

        // set scaling system
        glTexParameterf( GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST );
        glTexParameterf( GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST );

        // read width and height
        width = bitmap.getWidth();
        height = bitmap.getHeight();

        // clean up
        glBindTexture( GL_TEXTURE_2D, 0 );
        bitmap.recycle();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void reload() {
        load();
    }

    public void bind() {
        glBindTexture( GL_TEXTURE_2D, id );
    }

    public void unbind() {
        glBindTexture( GL_TEXTURE_2D, 0 );
    }

    public void dispose() {
        bind();
        int[] textures = { id };
        glDeleteTextures( 1, textures, 0 );
    }
}
