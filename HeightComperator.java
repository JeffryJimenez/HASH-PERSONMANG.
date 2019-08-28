import java.util.*;

public class HeightComperator implements Comparator<Person> {
    PersonDataHashMap hashMap;
    List<Person> list;
    int title;

    /**
     * Constructor creates a new HeightComparator object.
     *
     * @param hashmap HashMap to be sorted.
     */
    public HeightComperator(PersonDataHashMap hashmap){
        this.hashMap = hashmap;
        list = new ArrayList<>(hashMap.getHashMap().values());
        title = -1;
    }

    /**
     * Sorts information in HashMap in ascending order of height.
     *
     * This method turn the HashMap into a linkList and than sorts the information with Collections.sort
     * and the overridden compare method.
     */
    public void heightComparator(){

        Collections.sort(list,this::compare);


        HashMap<String,Person> sorted = new HashMap<>();

        for(Person person: list){
            sorted.put(person.getName(),person);
        }

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
     * This method compare two Person object's height.
     *
     * @param o1 Some Person object.
     * @param o2 Some person object.
     *
     * @return 0 if Person 01's height is greater than Person o2, false otherwise.
     */
    @Override
    public int compare(Person o1, Person o2) {
        double height1 = o1.getHeight();
        double height2 = o2.getHeight();


        if(height1 > height2){
            return 0;
        }

        else if(height1 < height2){
            return -1;
        }

        else{
            String name1 = o1.getName();
            String name2 = o2.getName();

            return name1.compareTo(name2);
        }



    }


}
