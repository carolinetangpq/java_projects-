//Name: Caroline Tang 
//T06
//Declaration: This is my own work
import java.util.ArrayList;
import java.util.Random;

enum ShapeColor {Blue, Yellow, Red, Green, White};

interface Recolorable 
{
    public void recolor(ShapeColor sc);
}

interface Shape
{
    public double area(); 
}
abstract class TwoD implements Recolorable, Shape
{
    protected ShapeColor sc; 
    protected int a, b, c, d; 

    public TwoD()
    {
    }

    public TwoD(ShapeColor sc, int a)
    {
        this.sc = sc; 
        this.a = a; 
    }
    
    public TwoD(ShapeColor sc, int a, int b)
    {
        this.sc = sc; 
        this.a = a; 
        this.b = b; 
    }

    public TwoD(ShapeColor sc, int a, int b, int c)
    {
        this.sc = sc; 
        this.a = a; 
        this.b = b; 
        this.c = c;
    }

    public TwoD(ShapeColor sc, int a, int b, int c, int d)
    {
        this.sc = sc; 
        this.a = a; 
        this.b = b; 
        this.c = c;
        this.d = d; 
    }

    public TwoD(TwoD td)
    {
        this(td.sc, td.a, td.b, td.c, td.d);
    }

    public int getA()
    {
        return a; 
    }
    
    public int getB()
    {
        return b; 
    }

    public int getC()
    {
        return c; 
    }
    
    public int getD()
    {
        return d; 
    }

    public ShapeColor getShapeColor()
    {
        return sc; 
    }

    public void setTwoD(ShapeColor sc, int a, int b, int c, int d)
    {
        this.sc = sc; 
        this.a = a; 
        this.b = b; 
        this.c = c;
        this.d = d; 
    }

    public void recolor(ShapeColor sc)
    {
        this.sc = sc; 
    }

    @Override
    public String toString()
    {
        return String.format("Area = %.3f", area());
    }
}

class Circle extends TwoD
{
    public Circle()
    {
    }

    public Circle(ShapeColor sc, int radius)
    {
        super(sc, radius); 
    }

    //copy constructor 
    public Circle(Circle c)
    {
        this(c.sc, c.a);
    }

    @Override
    public double area()
    {
        return (Math.PI * a * a); 
    }

    public int getRadius()
    {
        return a;   
    }

    public void setCircle(ShapeColor sc, int radius)
    {
        this.sc = sc; 
        this.a = radius; 
    }

    @Override
    public String toString()
    {
        return String.format("%s", super.toString()); 
    }
}

class Rectangle extends TwoD
{
    public Rectangle()
    {
    }

    public Rectangle(ShapeColor sc, int length, int width)
    {
        super (sc, length, width); 
    }

    //b becomes length, c becomes width
    public Rectangle(Rectangle r)
    {
        this(r.sc, r.a, r.b); 
    }

    @Override
    public double area()
    {
        return (a * b); 
    }

    public int getLength()
    {
        return b; 
    }

    public int getWidth()
    {
        return c; 
    }

    public void setRectangle(ShapeColor sc, int length, int width)
    {
        this.sc = sc; 
        this.a = length; 
        this.b = width;
    }

    @Override
    public String toString()
    {
        return String.format("%s", super.toString());
    }
}

class Triangle extends TwoD 
{
    public Triangle()
    {
    }

    public Triangle(ShapeColor sc, int a, int b, int c)
    {
        super (sc, a, b, c); 
    }

    public Triangle(Triangle t)
    {
        this(t.sc, t.a, t.b, t.c); 
    }

    @Override
    public double area()
    {
        double s = (a + b + c / 2.0);
        return Math.sqrt (s * (s - a) * (s - b) * (s - c));
    
    }

    public int getA()
    {
        return a; 
    }

    public int getB()
    {
        return b; 
    }

    public int getC()
    {
        return c; 
    }

    public void setTriangle(ShapeColor sc, int a, int b, int c)
    {
        this.sc = sc; 
        this.a = a; 
        this.b = b; 
        this.c = c; 
    }

    @Override
    public String toString()
    {
        return String.format("%s", super.toString());
    }
}

class Trapezoid extends TwoD
{
    private int h; 

    public Trapezoid()
    {
    }

    public Trapezoid (ShapeColor sc, int a, int b, int c, int d, int h)
    {
        super (sc, a, b, c, d); 
        this.h = h; 
    }

    public int getA()
    {
        return a; 
    }

    public int getB()
    {
        return b; 
    }

    public int getC()
    {
        return c; 
    }

    public int getD()
    {
        return d; 
    }

    public int getHeight()
    {
        return h; 
    }

    @Override
    public double area()
    {
        return (a + b / 2.0) * h; 
    }

    public void set (ShapeColor sc, int a, int b, int c, int d)
    {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public String toString()
    {
        return String.format("%s", super.toString());  
    }
}

interface Resizable 
{
    public void resize(double percentage); 
}

abstract class ThreeD implements Resizable, Shape 
{
    protected ShapeColor sc; 
    protected double a; 

    public ThreeD()
    {
        sc = ShapeColor.White; 
        a = 1; 
    }

    public ThreeD(ShapeColor sc, double a)
    {
        this.sc = sc; 
        this.a = a; 
    }

    public ThreeD(ThreeD td)
    {
        this(td.sc, td.a); 
    }

    public double getA()
    {
        return a; 
    }

    public void setThreeD(ShapeColor sc, double a)
    {
        this.sc = sc; 
        this.a = a; 
    }

    //reduce size by 15%
    public void resize(double percentage)
    {
        this.a = (a * percentage); 
    }

    //return a default value 
    public double volume()
    {
        return 0.0; 
    }

    @Override
    public String toString()
    {
        return String.format("Area = %.3f%n" + "Volume = %.3f", area(), volume());
    }
}

class Sphere extends ThreeD
{
    public Sphere()
    {
        super(); 
    }

    public Sphere(ShapeColor sc, double a)
    {
        this.sc = sc; 
        this.a = a; 
    }

    public Sphere(Sphere s)
    {
        this(s.sc, s.a); 
    }

    @Override
    public double area()
    {
        return 4 * Math.PI * a * a; 
    }

    public double volume()
    {
        return 4/3 * Math.PI * a * a; 
    }

    public double getA()
    {
        return a; 
    }

    public void setSphere(ShapeColor sc, double a)
    {
        this.sc = sc; 
        this.a = a;
    }

    @Override
    public String toString()
    {
        return String.format("%s", super.toString()); 
    }
}

class Cube extends ThreeD
{
    public Cube()
    {
        super(); 
    }

    public Cube(ShapeColor sc, double a)
    {
        this.sc = sc; 
        this.a = a; 
    }

    public Cube(Cube c)
    {
        this(c.sc, c.a);
    }

    @Override
    public double area()
    {
        return 6 * a * a; 
    }

    public double volume()
    {
        return a * a * a; 
    }

    public double getA()
    {
        return a; 
    }

    public void setCube(ShapeColor sc, double a)
    {
        this.sc = sc; 
        this.a = a; 
    }

    @Override
    public String toString()
    {
        return String.format("%s", super.toString()); 
    }
}

class Tetrahedron extends ThreeD
{
    public Tetrahedron()
    {
        super(); 
    }

    public Tetrahedron(ShapeColor sc, double a)
    {
        this.sc = sc; 
        this.a = a; 
    }

    public Tetrahedron(Tetrahedron t)
    {
        this(t.sc, t.a);
    }

    @Override
    public double area()
    {
        return Math.sqrt(3) * a * a; 
    }

    public double volume()
    {
        return (a * a * a)/(6 * Math.sqrt(2));  
    }

    @Override
    public String toString()
    {
        return String.format("%s", super.toString());
    }
}


class Caroline_A2 
{
    private static int getInt()
    {
        return (int)(Math.random() * 11); 
    }

    private static double getDouble()
    {
        return Math.random() * 10; 
    }

    //generate a random color
    private static ShapeColor getColor()
    { 
        Random rand = new Random(); 
        int sc = rand.nextInt(ShapeColor.values().length);
        return ShapeColor.values()[sc];
    }

    private static boolean isTriangle (int a, int b, int c)
    {
        if ((a + b > c) && (a + b > c) && (b + c > a))
            {
                return true;
            }
        else 
            {
                return false; 
            }
    }

    private static TwoD getTwoD()
    {
        Random rand = new Random(); 
        int twod = rand.nextInt(4);
		
		switch(twod)
		{	
            default: TwoD circle = new Circle(getColor(), getInt());
            return circle;
            
            case 1: TwoD rectangle = new Rectangle(getColor(), getInt(), 
												   getInt());
            return rectangle;
            
            case 2: TwoD trapezoid = new Trapezoid(getColor(), getInt(), 
												   getInt(), getInt(), 
												   getInt(), getInt());
            return trapezoid;
            
            case 3: TwoD triangle = new Triangle(getColor(), getInt(), 
												 getInt(), getInt());
												 
            if (isTriangle(triangle.getA(), triangle.getB(), 
						   triangle.getC()) == true)
            {
                return triangle;
            }
            else
            {
				return getTwoD();
            }
		}
    }

    private static ThreeD getThreeD()
    {
        Random rand = new Random(); 

        int ThreeD = rand.nextInt(3); 

        switch (ThreeD)
        {
            case 0: ThreeD sphere = new Sphere(getColor(), getDouble());
            return sphere; 
            
            case 1: ThreeD cube = new Cube(getColor(), getDouble());
            return cube; 

            case 2: ThreeD tetrahedron = new Tetrahedron(getColor(), getDouble());
            return tetrahedron; 

            default: return getThreeD(); 
        }
    }
    private static void displayAList(ArrayList <Shape> alist)
    {
        for (Shape s : alist)
        {
            System.out.printf("Shape %d: %s", alist.indexOf(s) + 1, s.getClass().getName());

             //Print resized values
			if (s instanceof ThreeD)
            {
                ThreeD threed = (ThreeD) (s);
                System.out.printf("(3D (%s, %.3f))%n", threed.sc, threed.getA());
                System.out.println(s);
                threed.resize(0.85);

            }

            if (s instanceof Cube)
            {
                ThreeD threed = (ThreeD) (s); 
                System.out.printf("Size reduced by 15%%: %s (3D (%s, %.3f))%n", 
                                  s.getClass().getName(), 
                                  threed.sc, threed.getA());
                System.out.printf("Updated surface area = %.3f%n" + 
                                  "Updated volume = %.3f%n",
                                  threed.area(), threed.volume());
                System.out.println("I am a cube shape");
            }

            else if (s instanceof Tetrahedron)
            {
                ThreeD threed = (ThreeD) (s);
                System.out.printf("Size reduced by 15%%: %s (3D (%s, %.3f))%n", 
                                  s.getClass().getName(), 
                                  threed.sc, threed.getA());
                System.out.printf("Updated surface area = %.3f%n" + 
                                  "Updated volume = %.3f%n",
                                  threed.area(), threed.volume());
                System.out.println("I am a tetrahedron shape");
            }

            else if (s instanceof Sphere)
            {
                ThreeD threed = (ThreeD) (s);
                System.out.printf("Size reduced by 15%%: %s (3D (%s, %.3f))%n", 
                                  s.getClass().getName(), 
                                  threed.sc, threed.getA());
                System.out.printf("Updated surface area = %.3f%n" + 
                                  "Updated volume = %.3f%n",
                                  threed.area(), threed.volume());
                System.out.println("I am a Sphere shape");
            }
            
            if (s instanceof TwoD)
            {
                if (s instanceof Triangle)
                {
                    Triangle t = (Triangle) (s);
                    System.out.printf("(2D (%s, %d, %d, %d))%n", 
                                  t.getShapeColor(), t.getA(), 
                                  t.getB(), t.getC());
                    System.out.printf("Updated color: %s%n", getColor());
                    System.out.println(s);
                    System.out.println("I am a triangle shape");
                }

                else if (s instanceof Circle)
                {
                    Circle c = (Circle) (s);
                    System.out.printf("(2D (%s, %d))%n", 
                                  c.getShapeColor(), c.getA()); 
                    System.out.printf("Updated color: %s%n", getColor());
                    System.out.println(s);
                    System.out.println("I am a circle shape");
                }

                else if (s instanceof Rectangle)
                {
                    Rectangle r = (Rectangle) (s);
                System.out.printf("(2D (%s, %d, %d))%n", 
                                  r.getShapeColor(), 
                                  r.getA(), r.getB());
                System.out.printf("Updated color: %s%n", getColor());
                System.out.println(s);
                System.out.println("I am a rectangle shape");
                }

                else if (s instanceof Trapezoid)
                {
                    Trapezoid tr = (Trapezoid) (s); 
                    System.out.printf("(2D (%s, %d, %d, %d, %d,)%d)%n", 
                                  tr.getShapeColor(), 
                                  tr.getA(), tr.getB(), 
                                  tr.getC(), tr.getD(),
                                  tr.getHeight());
                    System.out.printf("Updated color: %s%n", getColor());
                    System.out.println(s);
                    System.out.println("I am a trapezoid shape");
                }
            }

            System.out.println("---------------------------------------------");
        }

    }
    public static void main (String [] arg)
    {
        ArrayList <Shape> alist = new ArrayList <Shape> (); 

        Random rand = new Random(); 
        int k = rand.nextInt(3); 

        do
        {
            if (k == 1)
            {
                alist.add(getTwoD());
                k = rand.nextInt(3);
            }
            
            else if (k == 2)
            {
                alist.add(getThreeD());
                k = rand.nextInt(3);
            }
		}
        while(k != 0);
		
		//Print ArrayList
		displayAList(alist);
    }

}