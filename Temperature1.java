import java.util.*;
/**
 * Temperature1
 *
 * @author (Caique Trivelato)
 * @version (3/21/2024)
 */
public class Temperature1
{
    private double degrees;
    private double convertedDegrees;
    private char units; //'C' for Celsius, 'F' for Fahrenheit
    
    
    //Four Constructors
    
    //Constructor to specify both temperature and units.
    
    public Temperature1(double newDegrees, char newUnits)
    {
        degrees = newDegrees;
        units = newUnits;
    }
    
    //Constructor to specify just the temperature.
    //Defaults to 'C' for Celsius.
    
    public Temperature1(double newDegrees)
    {
        degrees = newDegrees;
        units = 'C';
    }
    
    //Constructor to specify just the units.
    //Defaults to 0 degrees.
    
    public Temperature1(char newUnits)
    {
        degrees = 0;
        units = newUnits;
    }
    
    //Default constructor (specifies neither temperature or units).
    //Defaults to 0 degrees Celsius.
    
    public Temperature1()
    {
        degrees = 0;
        units = 'c';
    }
    
    
    //----------------------------------------------------
    //Method for user to specify parameters interactively.
    public void readInput()
    {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter a temperature in degrees (for example 29.6): ");
        degrees = keyboard.nextFloat();
        System.out.println();
        System.out.println("Enter 'F' (or 'f') for Fahrenheit or 'C' (or 'c') for Celsius: ");
        units = keyboard.next().charAt(1);
        System.out.println();
    }
    
    
    //Three "write" methods to display temperature.
    
    //Method to display parameter values.
    public void writeOutput()
    {
        System.out.println();
        System.out.println("Temperature = " + Math.round(degrees*10)/10.0 + " degrees " + units + ".");
        System.out.println();
    }
    
    
    //Method to display temperature in degrees C.
    //Note that the temperature is rounded and
    //displayed to one decimal place.
    public void writeC()
    {
        switch(units)
        {
            case 'F':
            case 'f':
                convertedDegrees = 5 * (degrees - 32)/9;
                //Divide by 10.0 so division result is floating point
                //(with one decimal place).
                System.out.println("Temperature = " + Math.round(convertedDegrees*10)/10.0 + " degrees Celsius.");
                break;
                
            case 'C':
            case 'c':
                System.out.println("Temperature = " + Math.round(degrees*10)/10.0 + " degrees Celsius.");
                break;
                
            default:
                System.out.println("Unknown units -");
                System.out.println(" cannot determine temperature.");
                System.out.println("Next time enter either 'F' for Fahrenheit or 'C' for Celsius.");
        }
    }
    
    //Method to display temperature in degrees F.
    //Note that the temperature is rounded and
    //displayed to one decimal place.
    public void writeF()
    {
        switch(units)
        {
            case 'F':
            case 'f':
                System.out.println("Temperature = " + Math.round(degrees*10)/10.0 + " degrees Fahrenheit.");
                break;
                
            case 'C':
            case 'c':
                convertedDegrees =degrees * 9/5 + 32;
                System.out.println("Temperature = " + Math.round(convertedDegrees*10)/10.0 + " degrees Fahrenheit.");
                break;
                
            default:
                System.out.println("Unknown units -");
                System.out.println(" cannot determine temperature.");
                System.out.println("Next time enter either 'F' for Fahrenheit or 'C' for Celsius.");
        }
    }
    
    //Two methods to get (return) temperature value in either degrees
    //C or degrees F.
    
    //Method to return temperature in degrees C.
    //Returns value of variable degrees if units is
    //an invalid character (other than c,C,f, or F).
    public double getC()
    {
        switch(units)
        {
            case 'F':
            case 'f':
                convertedDegrees = 5* (degrees-32)/9;
                return Math.round(convertedDegrees*10)/10.0;
            
            case 'C':
            case 'c':
                return Math.round(degrees*10)/10.0;
                
            default:
                return Math.round(degrees*10)/10.0;
        }
    }
    
    //Method to return temperature in degrees C.
    //Returns value of variable degrees if units is
    //an invalid character (other than c,C,f, or F).
    public double getF()
    {
        switch(units)
        {
            case 'F':
            case 'f':
                return Math.round(degrees*10)/10.0;
            
            case 'C':
            case 'c':
                convertedDegrees = degrees * 9/5 + 32;
                return Math.round(convertedDegrees*10)/10.0;
                
            default:
                return Math.round(degrees*10)/10.0;
        }
    }
    
    //Three methods to set(reset) the parameters values.
    
    //Method to set both parameters.
    //Postconditions: does not guarantee legitimate value for
    //units (allows any character, not just c, C, f, or F).
    public void set(double newDegrees, char newUnits)
    {
        degrees = newDegrees;
        units = newUnits;
    }
    
    //Method to set temperature only.
    public void set(double newDegrees)
    {
        degrees = newDegrees;
    }
    
    //Method to set units only.
    //Post conditions: Does not guarantee legitimate value for
    //units (allows any character, not just c, C, f, or F).
    public void set(char newUnits)
    {
        units = newUnits;
    }
    
    //Three comparison methods.
    
    //Are two temperatures equal?
    //Convert temperatures to an integer number of tenths of degrees
    //to avoid errors due to comparing floating point numbers, which
    //often cannot be stored in memory precisely.
    public boolean equals(Temperature1 another)
    {
        //Use same units for comparison
        return(Math.round(this.getC()*10) == Math.round(another.getC()*10));
    }
    
    //Is one temperature greater than another?
    //Convert temperatures to an integer number of tenths of degrees
    //to avoid errors due to comparing floating point numbers, which
    //often cannot be stored in memory precisely.
    public boolean isGreaterThan(Temperature1 another)
    {
        //Use same units for comparison
        return(Math.round(this.getC()*10) > Math.round(another.getC()*10));
    }
    
    //Is one temperature less than another?
    //Convert temperatures to an integer number of tenths of degrees
    //to avoid errors due to comparing floating point numbers, which
    //often cannot be stored in memory precisely.
    public boolean isLessThan(Temperature1 another)
    {
        //Use same units for comparison
        return(Math.round(this.getC()*10) < Math.round(another.getC()*10));
    }
}
