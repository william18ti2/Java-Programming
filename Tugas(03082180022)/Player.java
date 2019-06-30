import greenfoot.*;

public class Player extends Actor
{
    private int targetx=0,targety=0;
    private int pause=0;
    private boolean toRemove=false;
    private static boolean flag;
    public void addedToWorld(World MyWorld){
        targetx=getX();targety=getY();
    }
    public static void halt()
    {
        flag = true;
    }
    public void move(){
        double rx=targetx-getX();
        double ry=targety-getY();
        double r=Math.sqrt(rx*rx+ry*ry);
        int bts=5;
        int posx=0,posy=0;
        if(r>bts){
            posx=(int)(getX()+bts*rx/r);
            posy=(int)(getY()+bts*ry/r);
        }else{
            posx = targetx;
            posy = targety;
        }
        setLocation(posx,posy);
    }
    
    public void planeKill() {
        Actor collide = getOneIntersectingObject(Enemy.class);
        if (collide != null) {
            Hancur();
            Greenfoot.stop();
        }
    }
    
    public void Hancur()
    {
        for(int i=0;i<10;i++){
            int px=-20+Greenfoot.getRandomNumber(40);
            int py=-20+Greenfoot.getRandomNumber(40);
            getWorld().addObject(new Pieces(getImage()),getX()+px,getY()+py);
        }
        this.toRemove=true;
    }
    
    public void act() 
    {
       if(!flag){
       if(Greenfoot.mouseMoved(null)){
           MouseInfo mouse=Greenfoot.getMouseInfo();
           targetx=mouse.getX();
           targety=mouse.getY();
        }
        
        move();
        
        planeKill();
        
        if(pause>0)pause--;
        if(pause==1)getWorld().addObject(new Laser(),getX()+100,getY());
        if(pause==0)pause=40;
        if(toRemove)getWorld().removeObject(this);
        }
    }    
}
