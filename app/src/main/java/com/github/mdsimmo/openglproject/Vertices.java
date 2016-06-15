package com.github.mdsimmo.openglproject;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import static android.opengl.GLES10.*;

/**
 * A wrapper class for pushing a set of vertices onto OpenGL. This class will
 * handle dynamically expanding to any size required.
 */
public class Vertices {

    private static final int BYTES_PER_FLOAT = Float.SIZE / Byte.SIZE;
    private static final int BYTES_PER_SHORT = Short.SIZE / Byte.SIZE;

    private static final int POSITION_PARTS = 2;
    private static final int TEXTURE_PARTS = 2;
    private static final int VERTEX_PARTS = POSITION_PARTS + TEXTURE_PARTS;
    private static final int VERTEX_SIZE = BYTES_PER_FLOAT * VERTEX_PARTS;

    private static final int INDEX_SIZE = BYTES_PER_SHORT;

    private FloatBuffer vertices;
    private ShortBuffer indices;

    public Vertices setVertices( float[] verts ) {
        ensureVertexCapacity( verts.length );
        vertices.position( 0 );
        vertices.put( verts );
        vertices.flip();
        return this;
    }

    public Vertices setIndices( short[] inds ) {
        if (inds == null) {
            indices = null;
            return this;
        }
        ensureIndexCapacity( inds.length );
        indices.position( 0 );
        indices.put( inds );
        indices.flip();
        return this;
    }

    private void ensureVertexCapacity( int maxVertices ) {
        if (vertices == null || vertices.capacity() < maxVertices * VERTEX_SIZE ) {
            ByteBuffer buffer = ByteBuffer.allocateDirect( maxVertices * VERTEX_SIZE );
            buffer.order( ByteOrder.nativeOrder() );
            vertices = buffer.asFloatBuffer();
        }
    }

    private void ensureIndexCapacity( int maxIndices ) {
        if ( indices == null || indices.capacity() < maxIndices * INDEX_SIZE ) {
            ByteBuffer buffer = ByteBuffer.allocateDirect( maxIndices * INDEX_SIZE );
            buffer.order( ByteOrder.nativeOrder() );
            indices = buffer.asShortBuffer();
        }
    }

    public void draw( int mode ) {
        // enable some features
        glEnable( GL_TEXTURE_2D );
        glEnableClientState( GL_VERTEX_ARRAY );
        glEnableClientState( GL_TEXTURE_COORD_ARRAY );

        // bind the vertices
        vertices.position( 0 );
        glVertexPointer( POSITION_PARTS, GL_FLOAT, VERTEX_SIZE, vertices );
        vertices.position( POSITION_PARTS );
        glTexCoordPointer( TEXTURE_PARTS, GL_FLOAT, VERTEX_SIZE, vertices );

        if ( indices != null ) {
            glDrawElements( mode, indices.limit(), GL_UNSIGNED_SHORT, indices );
        } else {
            glDrawArrays( mode, 0, vertices.limit() );
        }
    }
}
