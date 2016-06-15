package com.github.mdsimmo.openglproject;

/**
 * A simple way to define a set of rectangular vertices
 */
public class Rectangle {

    public float x, y;
    public float width, height;
    public float xOrigin, yOrigin;
    public float u1, v1, u2, v2;

    public Rectangle() {
        // set some defaults
        size( 1, 1 );
        position( 0, 0 );
        origin( 0, 0 );
        setTexture( 0, 1, 1, 0 );
    }

    public Rectangle size( float width, float height ) {
        this.width = width;
        this.height = height;
        return this;
    }

    public Rectangle position( float x, float y ) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Rectangle origin( float x, float y ) {
        this.xOrigin = x;
        this.yOrigin = y;
        return this;
    }

    public Rectangle setTexture( float u1, float v1, float u2, float v2 ) {
        this.u1 = u1;
        this.v1 = v1;
        this.u2 = u2;
        this.v2 = v2;
        return this;
    }

    /** Makes a rectangle out of a set of vertices */
    public Vertices apply( Vertices vertices ) {
        float xx = x - xOrigin;
        float yy = y - yOrigin;
        float w = width;
        float h = height;

        vertices.setVertices( new float[]{
            //    position        texture
            //     x       y       u  v
                xx,     yy,       u1, v1,  //  1---2
                xx,     yy + h,   u1, v2,  //  | / |
                xx + w, yy + h,   u2, v2,  //  0---3
                xx + w, yy,       u2, v1
        } );
        vertices.setIndices( new short[]{
                0, 1, 2,
                0, 2, 3
        } );
        return vertices;
    }

    /** Short cut for creating a new set of vertices */
    public Vertices create() {
        return apply( new Vertices() );
    }
}
