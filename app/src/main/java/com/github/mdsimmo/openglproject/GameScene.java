package com.github.mdsimmo.openglproject;

public class GameScene implements Scene {

    Assets assets;
    World world;
    Camera camera;

    public GameScene( Assets assets ) {
        this.assets = assets;
    }

    @Override
    public void create() {
        world = new World( assets );
        camera = new Camera()
                .position( world.width()/2, world.height()/2 )
                .size( world.width(), world.height() );
    }

    @Override
    public void update() {
        world.update();
    }

    @Override
    public void draw() {
        camera.apply();
        world.draw();
    }
}
