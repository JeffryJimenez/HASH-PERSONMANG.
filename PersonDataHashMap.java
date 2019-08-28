import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PersonDataHashMap {
    private HashMap<String, Person> hashMap;
    private int currentSize;

    /**
     * This constructor creates a PersonDataHashMap object.
     *
     */
    public PersonDataHashMap(){
        hashMap = new HashMap();
        currentSize = 0;
    }

    /**
     * Creates a hashMap with information given on a file.
     *
     * This method creates a new PersonDataHashMap object with the necessary information provided
     * in a .csv file. The .csv file MUST be located in the same directory as the project. The name of the
     * Person objects are the keys.
     *
     * @param location the name of the .csv file
     * @return A new hashMap built from the .csv file
     * @throws IllegalArgumentException If file is not found.
     * @throws FileNotFoundException If file is not found.
     */
    public static PersonDataHashMap buildFromFile(String location) throws IllegalArgumentException, FileNotFoundException {


        Person[] personBuilder = new Person[100];
        String[] line = new String[19];
        PersonDataHashMap personDataHashMap = new PersonDataHashMap();
        HashMap<String, Person> hashMap = new HashMap();
        int currentSize = 0;
        String[] data = new String[5];
        File inFile = new File(location);
        try (Scanner console = new Scanner(inFile)) {


            for (int i = 0; i < line.length; i++)
                line[i] = console.nextLine();                                         //Splits all the info in the array
                                                                                      //individual indexes.

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException();

        }


        for (int i = 0; i < line.length - 1; i++) {

            personBuilder[i] = new Person();
            for (int j = 0; j < 1; j++) {
                data = line[i + 1].split(",");                                                       //Retrieves information from line.
                String name = data[0].replaceAll("\"", "");                               //Deletes the ("")
                String gender = data[1].replaceAll("\"", "");                             //in names and genders.
                String age = data[2];
                String height = data[3];
                String weight = data[4];                                                                    //Every index in data
                                                                                                            //has specific information.
                int parseAge = Integer.parseInt(age.trim());
                double parseHeight = Double.parseDouble(height.trim());
                double parseWeight = Double.parseDouble(weight.trim());
                gender = gender.trim();
                name = name.trim();

                personBuilder[i].setName(name);
                personBuilder[i].setGender(gender);
                personBuilder[i].setAge(parseAge);
                personBuilder[i].setHeight(parseHeight);
                personBuilder[i].setWeight(parseWeight);


                hashMap.put(personBuilder[i].getName(), personBuilder[i]);


            }
            currentSize++;

        }


        personDataHashMap.setCurrentSize(currentSize);
        personDataHashMap.setHashMap(hashMap);
        return personDataHashMap;

    }

    /**
     * Adds a new Person object to the hashMap.
     *
     * The nma ein the person objct is the key for the hashMap, and the Person object is the value.
     *
     * @param name name of the person (key).
     * @param newPerson Person object that is going to be stored (value).
     * @throws PersonAlreadyExistsException Thrown if person already exists in the hashMap.
     */
    public void add(String name, Person newPerson) throws PersonAlreadyExistsException{


        if(findPerson(name)){                                                               //Pre - condition
            throw new PersonAlreadyExistsException();
        }

        hashMap.put(name, newPerson);
    }

    /**
     * Gets the information from a person object in the hashMap.
     *
     * This method access a given Person object and returns its data in tubular form.
     *
     * @param name The name of the person (key).
     * @throws PersonDoesNotExistException Thrown if person does not exist.
     */
    public void get(String name) throws PersonDoesNotExistException{


        if(!findPerson(name)){                                                                 //pre-condition
            throw new PersonDoesNotExistException();
        }


        System.out.print(hashMap.get(name).toString());

    }

    /**
     * This method removes a Person object from the hashMap.
     *
     * @param name The name of the person being removed (key).
     * @throws PersonDoesNotExistException Thrown if person does not exist.
     */
    public void remove(String name) throws PersonDoesNotExistException{
        if(!findPerson(name)){                                                             //pre-condition
            throw new PersonDoesNotExistException();
        }

        hashMap.remove(name);
    }

    /**
     *Method helps determine whether a person exists or not in the hashMap.
     *
     * @param name name of the person.
     * @return True if person exists, false otherwise.
     */
    public boolean findPerson(String name){
        boolean found = false;

        for(String nameKey: hashMap.keySet()){
            if(name.equalsIgnoreCase(nameKey)){
                found = true;
            }
        }

        return found;
    }

    /**
     * This method prints out all data in the hashMap instance variable.
     */
    public void printTable(){

        List<Person> list = new ArrayList<>(hashMap.values());
        int title = -1;

        for(int i = 0; i < list.size(); i++) {


            String format = "\n|%1$-30s|%2$-30s|%3$-30s|%4$-30s|%5$-30s|\n";                  //Format for the Tittle
            String formatData = "|%1$-30s|%2$-30s|%3$-30s|%4$-30s|%5$-30s|\n";       //Format for the Data.


            if (title < 0)  {                                                                                 //When to print the tittle.
                System.out.format(format, "Name", "Age", "Gender", "Height", "Weight");
                System.out.println("==============================================================" +
                        "============================================================================" +
                        "=================================================");
                title = 1;
            }

            System.out.format(formatData,list.get(i).getName(), list.get(i).getAge(),list.get(i).getGender()  //Prints the info
                    ,(int)list.get(i).getHeight()/12 +" feet " + (int)list.get(i).getHeight()%12 + " inches",(int)list.get(i).getWeight() +" pounds");
        }
    }


    /**
     * Sets the hashMap instance variable equals to another hashMap.
     *
     * @param hashMap the update hashMap.
     */
    public void setHashMap(HashMap hashMap) {
        this.hashMap = hashMap;
    }

    /**
     * Sets the current size of PersonDataManager.
     *
     * @param currentSize The new size.
     */
    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    /**
     *
     * @return Return the hashMap instance variable.
     */
    public HashMap getHashMap() {
        return hashMap;
    }
}
