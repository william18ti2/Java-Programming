import greenfoot.*;

public class Enemy extends Actor
{
    private int vx=0;
    private boolean toRemove=false;
    private static boolean flag;
    public Enemy()
    {
        
    }
    public Enemy(int v)
    {
        vx=v;
    }
    public void addedToWorld(World MyWorld)
    {
     setRotation(180);   
    }
    public void move()
    {
        setLocation(getX()+vx,getY());
        Actor actor=getOneIntersectingObject(Player.class);
        if(getX()<-200)toRemove=true;
    }
    public static void halt()
    {
      flag = true;
    }
    public void Hancur()
    {
        for(int i=0;i<10;i++){
            int px=-20+Greenfoot.getRandomNumber(40);
            int py=-20+Greenfoot.getRandomNumber(40);
            getWorld().addObject(new Pieces(getImage()),getX()+px,getY()+py);
        }
        getWorld().addObject(new Circle(),getX(),getY());
        toRemove=true;
    }
    public void act() 
    {
        if(!flag){
        if(!toRemove)move();
        else getWorld().removeObject(this);
    }
    }    
}
