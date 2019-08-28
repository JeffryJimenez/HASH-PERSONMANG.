import java.io.FileNotFoundException;
import java.util.Scanner;

public class PersonDataManager {
    public static void main(String[] args) {

        PersonDataHashMap hashMap = new PersonDataHashMap();


        String choice = "S";


        Scanner info = new Scanner(System.in);
        Scanner in = new Scanner(System.in);



        while (!choice.equals("Q")) {


            try {

                System.out.println("\nI. - Import from File \nA. - Add Person \nR. - Remove Person \nG. - Get Person" +
                        "\nP. - Print Table \nS. - Sort \nQ. Quit");

                System.out.print("Please select an option: ");
                choice = in.nextLine();


                switch (choice) {
                    case "Q":
                        System.out.println("Ayy so you is leaving... Goodbye.");
                        break;

                    case "S":

                        System.out.println("Please select by what: ");
                        System.out.println("     N. - Name.\n     W. - Weight \n     H. Height ");
                        System.out.print("Choose an option: ");

                        choice = info.nextLine();
                        switch (choice){
                            case "H":
                                HeightComperator heightComperator = new HeightComperator(hashMap);
                                System.out.println("Here is a HashMap sorted by height: ");
                                heightComperator.heightComparator();

                                break;
                            case "W":
                                WeightComparator weightComparator = new WeightComparator(hashMap);
                                System.out.println("Here is a HashMap sorted by weight: ");
                                weightComparator.weightComparator();

                                break;
                            case "N":
                                NameComparator nameComparator = new NameComparator(hashMap);
                                System.out.println("Here is a HashMap sorted by name: ");
                                nameComparator.nameComparator();

                                break;

                        }

                        break;
                    case "P":
                        hashMap.printTable();
                        break;

                    case "G":
                        System.out.print("Please enter the name of the person: ");
                        String nameG = info.nextLine();

                        hashMap.get(nameG);

                        break;


                    case "R":
                        System.out.print("Please enter the name of the person: ");
                        String nameR = info.nextLine();

                        hashMap.remove(nameR);

                        System.out.println(nameR + " has been removed!");
                        break;


                    case "A":
                        System.out.print("Please enter the name of the person: ");
                        String nameA = info.nextLine();

                        System.out.print("Please enter the age of the person: ");
                        String ageS = info.nextLine();                                                //taking number as strings
                        int age = Integer.parseInt(ageS);                                             // and the parsing avoids errors

                        System.out.print("Please enter the gender (M or F): ");
                        String gender = info.nextLine();

                        System.out.print("Please enter the height (in inches): ");
                        String heightS = info.nextLine();
                        double height = Double.parseDouble(heightS);

                        System.out.print("Please enter the weight (in lbs): ");
                        String weightS = info.nextLine();
                        double weight = Double.parseDouble(weightS);

                        Person newPerson = new Person(nameA,gender,age,height,weight);

                        hashMap.add(newPerson.getName(), newPerson);

                        System.out.println("\n" + newPerson.getName() + " has been added to the list!");
                        break;

                    case "I":
                        System.out.print("Please enter the location: ");
                        String location = info.nextLine();
                        hashMap = PersonDataHashMap.buildFromFile(location);

                        System.out.println("\n\nStarting... \nPerson data loaded successful!");
                        break;



                }

            } catch (FileNotFoundException e){
                System.out.println("\nFile not found please try again!");
            }catch (PersonAlreadyExistsException e){
                System.out.println("\n\nPERSON ALREADY EXIST!!)");
            }catch (PersonDoesNotExistException e){
                System.out.println("\n\nPERSON DOES NOT EXIST SORRY!");
            }catch (Exception e){
                System.out.println("\n\nTHE INPUT YOU ENTERED IS INCORRECT. PLEASE TRY AGAIN!");
            }
        }
    }
}