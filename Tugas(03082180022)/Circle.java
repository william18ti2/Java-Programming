import greenfoot.*;

public class Circle extends Actor
{
    private int pause=5;
    public Circle()
    {
        GreenfootImage image=new GreenfootImage(100,100);
        image.setColor(new Color(255,255,0,180));
        image.fillOval(0,0,image.getWidth()-1,image.getHeight()-1);
        image.fillOval(20,20,image.getWidth()-41,image.getHeight()-41);
        setImage(image);
        pause=5;
    }
    public void act() 
    {
        if(pause>0)pause--;
        else getWorld().removeObject(this);
    }    
}
