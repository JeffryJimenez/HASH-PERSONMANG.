public class Person {

    private String name;
    private String gender;
    private int age;
    private double height;
    private double weight;

    /**
     *
     * @return The name of a person object.
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the name of a Person object.
     *
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method sets the gender of a Person object.
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * This method sets the age of a Person object.
     *
     * @param age The age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * This method sets the height of a Person object.
     *
     * @param height The height.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * This method sets the weight of Person
     *
     * @param weight The weight.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     *
     * @return The gender of a Person object.
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @return The age of a Person object.
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @return The height of a Person object.
     */
    public double getHeight() {
        return height;
    }

    /**
     *
     * @return The weight of a Person object.
     */
    public double getWeight() {
        return weight;
    }


    /**
     * Constructor creates a person object with no parameters.
     *
     */
    public Person(){
    }

    /**
     * Constructor creates a new Person object.
     *
     * @param name The name of the person.
     * @param gender The gender of the person.
     * @param age The age of the person.
     * @param height The height of the person.
     * @param weight The weight of the person/
     */
    public Person(String name, String gender, int age, double height, double weight){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Returns string of data members in tubular form
     * @return Data members in tubular form
     */
    public String toString(){

        String genderWord;

        if(gender.equalsIgnoreCase("M")){
            genderWord = "male";
        }

        else {
            genderWord = "female";
        }


        return name + " is a "+ age + " year old " + genderWord + " who is " + (int)height/12 + " and " + (int)height%12 + " inches" + " and weighs " + (int)weight + " pounds";



    }
}
