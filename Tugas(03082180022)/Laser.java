import greenfoot.*;

public class Laser extends Actor
{
    private boolean toRemove=false;
    private int vx=3;
    public void addedToWorld(World MyWorld)
    {
        GreenfootImage image=new GreenfootImage(40,10);
        image.setColor(Color.RED);
        image.drawLine(0,5,image.getWidth()-1,5);
        setImage(image);
        
    }
    
    public void act() 
    {
        if(!toRemove){
            setLocation(getX()+vx,getY());
            Actor actor=getOneIntersectingObject(Enemy.class);
            if(actor!=null){
                ((Enemy)actor).Hancur();
            }
            if(getX()>getWorld().getWidth()+200)toRemove=true;
        }else{
            getWorld().removeObject(this);
        }
    }
}
