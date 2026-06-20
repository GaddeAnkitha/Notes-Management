public class Encapslation {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Encapslation(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Encapsulation1 {
    public static void main(String[] args) {
        Encapslation e = new Encapslation("sai", 22);
        System.out.println("name: " + e.getName());
        System.out.println("age: " + e.getAge());
    }
}
