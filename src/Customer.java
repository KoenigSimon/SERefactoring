
import java.lang.*;
import java.util.*;

class Customer 
{
    private String name;
    private Vector rentals = new Vector();

    public Customer (String newName)
    {
        name = newName;
    }

    public void addRental(Rental rental) 
    {
        rentals.addElement(rental);
    }

    public String getName ()
    {
        return name;
    }

    public String statement() 
    {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();	    
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        for (Rental rental : customer.rentals) {
            double rentalPrice;

            //determine amounts for rental line
            rentalPrice = rental.amountFor();

            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            //show figures for this rental
            resultBuilder.append("\t").append(rental.getMovie().getTitle()).append("\t").append("\t").append(rental.getDaysRented()).append("\t").append(rentalPrice).append("\n");
            totalAmount += rentalPrice;
        }

        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private double amountFor(Rental rental) 
    {
        double rentalPrice = 0;
        switch (rental.getMovie().getPriceCode()) 
        {
            case Movie.REGULAR:
                rentalPrice += 2;
                if (rental.getDaysRented() > 2)
                    rentalPrice += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalPrice += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                rentalPrice += 1.5;
                if (rental.getDaysRented() > 3)
                    rentalPrice += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return rentalPrice;
    }

}
    