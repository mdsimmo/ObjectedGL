package com.github.mdsimmo.openglproject;

import java.util.ArrayList;
import java.util.List;

public class World {

    private int width, height;
    private Garry garry;
    List<Cactus> cacti;

    public World( Assets assets ) {
        this.width = 10;
        this.height = 6;
        garry = new Garry( assets, this );
        cacti = new ArrayList<>();
        for (float i = 0; i < width; i += 2 ) {
            Cactus cactus = new Cactus( assets );
            cactus.position( i, 0 );
            cacti.add( cactus );
        }
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public void update() {
        for ( Cactus cactus : cacti )
            cactus.update();
        garry.update();
    }

    public void draw() {
        for (Cactus cactus : cacti )
            cactus.draw();
        garry.draw();
    }

}
