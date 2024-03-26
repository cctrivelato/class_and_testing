import java.util.*;
/**
 * Species
 *
 * @author (Caique Trivelato)
 * @version (3/22/2024)
 */
public class Species
{
    private String name;
    private int population;
    private double growthRate;
    
    //Five Constructor Methods:
    
    //three parameters
    public Species(String newSpecies, int newPopulation, double newGrowthRate)
    {
        name = newSpecies;
        population = newPopulation;
        growthRate = newGrowthRate;
    }
    
    //one parameter: Species Name
    public Species(String newSpecies)
    {
        name = newSpecies;
        population = 100;
        growthRate = 35;
    }
    
    //one parameter: Population
    public Species(int newPopulation)
    {
        name = "Tiger";
        population = newPopulation;
        growthRate = 35;
    }
    
    //one parameter: Growth Rate
    public Species(double newGrowthRate)
    {
        name = "Tiger";
        population = 100;
        growthRate = newGrowthRate;
    }
    
    //no parameters, default constructors
    public Species()
    {
        name = "Tiger";
        population = 100;
        growthRate = 35;
    }
    
    
    //-------------------------------------------
    //Method for user to specify parameters interactively.
    public void readInput()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is the species' name?");
        name = keyboard.nextLine();
        
        System.out.println("What is the population of the species?");
        population = keyboard.nextInt();
        while (population < 0)
        {
            System.out.println("Population cannot be negative.");
            System.out.println("Reenter population:");
            population = keyboard.nextInt();
        }
        System.out.println("Enter growth rate (% increase per year):");
        growthRate = keyboard.nextDouble();
    }
    
    public void writeOutput()
    {
        System.out.println("Name = " + name);
        System.out.println("Population = " + population);
        System.out.println("Growth rate = " + growthRate + "%");
    }
    
    /** 
     * Precondition: years is a nonnegative number.
     * Returns the projected population of the receiving object
     * after the specified number of years.
     */
    public int predictPopulation(int years)
    {
        int result = 0;
        double populationAmount = population;
        int count = years;
        while ((count > 0) && (populationAmount > 0))
        {
            populationAmount = (populationAmount + (growthRate/100) * populationAmount);
            count--;
        }
        if (populationAmount > 0)
            result = (int)populationAmount;
            return result;
    }
    
    //Four Set Methods
    public void setSpecies(String newName, int newPopulation, double newGrowthRate)
    {
        name = newName;
        if (newPopulation >= 0)
            population = newPopulation;
        else
        {
            System.out.println("Error: using a negative population.");
            System.exit(0);
        }
        growthRate = newGrowthRate;
    }
    
    //set methods for each individual instance variable
    public void set(String newName)
    {
        name = newName;
    }
    
    public void set(int newPopulation)
    {
        population = newPopulation;
    }
    
    public void set(double newGrowthRate)
    {
        growthRate = newGrowthRate;
    }
    
    //get returns of each instance variable methods
    public String getName()
    {
        return name;
    }
    
    public int getPopulation()
    {
        return population;
    }
    
    public double getGrowthRate()
    {
        return growthRate;
    }
    
    
    //method to compare both selected species
    public boolean equals(Species otherObject)
    {
        return (name.equalsIgnoreCase(otherObject.name)) && (population == otherObject.population) && (growthRate == otherObject.growthRate);
    }
}
